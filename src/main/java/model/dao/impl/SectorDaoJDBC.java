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
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement("DELETE FROM sector WHERE SectorId = ?");
            st.setInt(1, id);

            int rows = st.executeUpdate();

            if(rows == 0){
                throw new DbException("no lines affected");
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            Db.closeStatement(st);
        }
    }
    @Override
    public Sector findById(Integer id) {///
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                "SELECT sector.* "
                +"FROM sector "
                +"WHERE sector.SectorId = ?");            
            st.setInt(1, id);
            rs  = st.executeQuery();
            if (rs.next()) {
                Sector sector = new Sector();
                sector.setSectorId(rs.getInt("SectorId"));
                sector.mapSectorString(rs.getInt("SectorId"));
               return sector;
            } else {
                throw new DbException("Error!");
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    @Override
    public List<Sector> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                "SELECT * FROM Sector ORDER By SectorId");
            rs = st.executeQuery();
    
            List<Sector> list = new LinkedList<>();
            Map<Integer, Sector> map = new HashMap<>();
            while (rs.next()) {
                Sector sec = new Sector();
                sec.setSectorId(rs.getInt("SectorId"));
                sec.setSectors(rs.getString("SectorName"));
                sec.mapSectorString(rs.getInt("SectorId"));
                list.add(sec);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }
}
    
