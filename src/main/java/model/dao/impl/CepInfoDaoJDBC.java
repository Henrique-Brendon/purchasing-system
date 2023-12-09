package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.Db;
import DB.DbException;
import Util.cep.CepExcetion;
import Util.cep.CepInfo;
import model.dao.CepInfoDao;

public class CepInfoDaoJDBC implements CepInfoDao {
        private Connection connection;

    public CepInfoDaoJDBC(Connection conn){
        this.connection =  conn;
    }

    @Override
    public ResultSet insert(CepInfo cepInfo) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                    "INSERT INTO cepLocale (cep, street, neighborhood, City, State) "
                    + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, cepInfo.getCep());
            st.setString(2, cepInfo.getStreet());
            st.setString(3, cepInfo.getNeighborhood());
            st.setString(4, cepInfo.getCity());
            st.setString(5, cepInfo.getState());
    
            int rowsAffected = st.executeUpdate();
            rs = st.getGeneratedKeys();
    
            if (rowsAffected > 0 && rs.next()) {
                int id = rs.getInt(1);
                System.out.println("cep id: " + id);
            } else {
                throw new CepExcetion("Unexpected error! No rows affected or no generated keys!");
            }
    
        } catch (SQLException e) {
            throw new CepExcetion(e.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
        return rs;
    }

    @Override
    public List<CepInfo> findAll() {
        PreparedStatement st = null;
        ResultSet rs =  null;
        try {
            st =  connection.prepareStatement(
                "SELECT * FROM cepLocale");
            rs = st.executeQuery();

            List<CepInfo> list = new ArrayList<>();
            while(rs.next()){
                CepInfo info = startCep(rs);
                list.add(info);

            }
            return list;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    public CepInfo startCep(ResultSet rs)throws SQLException{
        CepInfo cep = new CepInfo();
        cep.setCepId(rs.getInt("cepId"));
        cep.setCep(rs.getString("cep"));
        cep.setStreet(rs.getString("street"));
        cep.setNeighborhood(rs.getString("neighborhood"));
        cep.setCity(rs.getString("City"));
        cep.setState(rs.getString("State"));
        return cep;
    }
    

    
}
