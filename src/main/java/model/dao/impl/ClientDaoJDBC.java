package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.dao.ClientDao;
import model.dao.entities.Client;

public class ClientDaoJDBC implements ClientDao{

    private Connection connection;

    public ClientDaoJDBC(Connection conn){
        this.connection =  conn;
    }

    @Override
    public void insert(Client cliente) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");

    }

    @Override
    public void update(Client cliente) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    private Client iniciarClient(PreparedStatement ps){
        return null;
    }
    
}
