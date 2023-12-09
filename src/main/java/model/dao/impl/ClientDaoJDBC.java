package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import DB.Db;
import DB.DbException;
import Util.cep.CepInfo;
import model.dao.ClientDao;
import model.dao.entities.Client;

public class ClientDaoJDBC implements ClientDao{

    private Connection connection;

    public ClientDaoJDBC(Connection conn){
        this.connection =  conn;
    }

    @Override
    public void insert(Client client) {
        PreparedStatement st = null;
        try{
            CepInfoDaoJDBC cep = new CepInfoDaoJDBC(Db.getConnection());
            cep.insert(CepInfo.cepObject(client.getCepInfo().getCep()));
            st = connection.prepareStatement(
            "INSERT INTO clientJ (ClientName, BirthDate, Email, ClientPassword, cepId) "
            +"VALUES (?, ?, ?, ?, LAST_INSERT_ID())",  Statement.RETURN_GENERATED_KEYS);
            st.setString(1, client.getName());
            st.setDate(2, new java.sql.Date(client.getBirthDate().getTime()));
            st.setString(3, client.getEmail());
            st.setString(4, client.getPassword());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("ready!");
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("client Id: " + id);
                }
                Db.closeResult(rs);
            }else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            Db.closeStatement(st);
        }
    }

    @Override
    public void update(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Client findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Client> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = connection.prepareStatement(
                "SELECT clientJ.ClientId, clientJ.ClientName, clientJ.BirthDate, "
                +"clientJ.Email, clientJ.ClientPassword, cepLocale.cep, "
                +"cepLocale.street, cepLocale.neighborhood, cepLocale.City, "
                +"cepLocale.State FROM clientJ "
                +"JOIN cepLocale ON clientJ.cepId = cepLocale.cepId ");
            rs = st.executeQuery();
    
            List<Client> list = new LinkedList<>();
            Map<Integer, CepInfo> map = new HashMap<>();
            while (rs.next()) {
                CepInfo obj = map.get(rs.getInt("ClientId"));
                if (obj == null) {
                    obj = startCep(rs);
                    map.put(rs.getInt("ClientId"), obj);
                }
                Client client = new Client(rs.getString("ClientName"), rs.getDate("BirthDate"),
                rs.getString("Email"), rs.getString("ClientPassword"), CepInfo.cepObject(obj.getCep()));
                list.add(client);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }



    public Client startClient(ResultSet rs) throws SQLException{
        Client obj = new Client();
        obj.setId(rs.getInt("ClientId"));
        obj.setName(rs.getString("ClientName"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setEmail(rs.getString("Email"));
        obj.setPassword(rs.getString("ClientPassword"));
        return obj;
    }
    
    public CepInfo startCep(ResultSet rs)throws SQLException{
        CepInfo cep = new CepInfo();
        cep.setCep(rs.getString("cep"));
        cep.setStreet(rs.getString("street"));
        cep.setNeighborhood(rs.getString("neighborhood"));
        cep.setCity(rs.getString("City"));
        cep.setState(rs.getString("State"));
        return cep;
    }
    
}
