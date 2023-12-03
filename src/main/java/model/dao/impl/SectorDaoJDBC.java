package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DB.Db;
import DB.DbException;
import model.dao.SectorDao;
import model.dao.entities.Sector;

public class SectorDaoJDBC implements SectorDao{
    private Connection connection;


    public SectorDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Sector sector) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(
				"INSERT INTO sector " 
				+"(SectorId, SectorName) " 
				+"VALUES " 
				+ "(?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, sector.getSectorId());
            st.setString(2, sector.getSectors());
            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Dam!");
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
    public void update(Sector sector) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(
				"INSERT INTO sector " 
				+"(SectorId, SectorName) " 
				+"VALUES " 
				+ "(?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, sector.getSectorId());
            st.setString(2, sector.getSectors());
            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Dam!");
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
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Sector findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Sector> finAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finAll'");
    }
    
}
