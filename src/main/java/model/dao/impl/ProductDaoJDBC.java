package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DB.Db;
import DB.DbException;

import model.dao.ProductDao;
import model.dao.entities.Product;

public class ProductDaoJDBC implements ProductDao{

    private Connection connection;

    public ProductDaoJDBC(Connection connection){
        this.connection = connection;
    }


    @Override
    public void insert(Product product) {
        PreparedStatement st = null;
        try{

            product.getSector().mapSectorId(product.getSector());;
            st = connection.prepareStatement(
				"INSERT INTO product " 
				+"(productName, cost, price, dateEntry, dateExit, sectorId) " 
				+"VALUES " 
				+ "(?, ?, ?, ?, ?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
            st.setString(1, product.getName());
            st.setDouble(2, product.getCost());
            st.setDouble(3, product.getPrice());
            st.setDate(4, new java.sql.Date(product.getDateEntry().getTime()));
            st.setDate(5, new java.sql.Date(product.getDateExit().getTime()));
            st.setInt(6, product.getSector().getSectorId());
            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("ready!");
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    product.setId(id);
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
    public void update(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Product findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Product> finAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finAll'");
    }
    
}
