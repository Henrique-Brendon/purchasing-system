package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import DB.Db;
import DB.DbException;

import model.dao.ProductDao;
import model.dao.entities.Product;
import model.dao.entities.Sector;

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

    public void insertList(List<Product> product) {
        PreparedStatement st = null;
        try{
            for (Product produto : product) {
                produto.getSector().mapSectorId(produto.getSector());
                st = connection.prepareStatement(
                    "INSERT INTO product " 
                    +"(productName, cost, price, dateEntry, dateExit, sectorId) " 
                    +"VALUES " 
                    + "(?, ?, ?, ?, ?, ?)", 
                    Statement.RETURN_GENERATED_KEYS);
                st.setString(1, produto.getName());
                st.setDouble(2, produto.getCost());
                st.setDouble(3, produto.getPrice());
                st.setDate(4, new java.sql.Date(produto.getDateEntry().getTime()));
                st.setDate(5, new java.sql.Date(produto.getDateExit().getTime()));
                st.setInt(6, produto.getSector().getSectorId());
                int linhasAfetadas = st.executeUpdate();
    
                if (linhasAfetadas > 0) {
                    System.out.println("Pronto!");
                    ResultSet rs = st.getGeneratedKeys();
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        produto.setId(id);
                    }
                    Db.closeResult(rs);
                } else {
                    throw new DbException("error, no lines affected");
                }
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            Db.closeStatement(st);
        }
    }

    @Override
    public void update(Product product) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(
                "UPDATE product "
                + "SET productName = ?, cost = ?, price = ?, dateEntry = ?, dateExit = ?, sectorId = ? "
                + "WHERE productId = ?");
                st.setString(1, product.getName());
                st.setDouble(2, product.getCost());
                st.setDouble(3, product.getPrice());
                st.setDate(4, new java.sql.Date(product.getDateEntry().getTime()));
                st.setDate(5, new java.sql.Date(product.getDateExit().getTime()));
                st.setInt(6, product.getSector().getSectorId());
                st.setInt(7, product.getId());
            int rows =  st.executeUpdate();
            if(rows == 0){
                throw new DbException("error, no lines affected");
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
            st = connection.prepareStatement("DELETE FROM product WHERE productId = ?");
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
    public Product findById(Integer id) {///
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                "SELECT product.*, sector.SectorName "
                +"FROM product INNER JOIN sector "
                +"ON product.SectorId = sector.SectorId "
                +"WHERE product.ProductId = ?");            
            st.setInt(1, id);
            rs  = st.executeQuery();
            if(rs.next()) {
                Sector sec = instantiateSector(rs);
                Product obj = instantiateProduct(rs, sec);
                sec.mapSector(obj.getName());
                return obj;
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    @Override
    public int getSize() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                "SELECT COUNT(*) AS getProducts "
                +"FROM product");            
            rs  = st.executeQuery();
            if(rs.next()){
                Integer a = rs.getInt("getProducts");
                return a;
            } else {
                throw new DbException("Error getting table total");
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
    public List<Product> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                "SELECT product.*, sector.SectorName " +
                "FROM product " +
                "INNER JOIN sector ON product.SectorId = sector.SectorId " +
                "ORDER BY product.ProductId");
    
            rs = st.executeQuery();
    
            List<Product> list = new LinkedList<>();
            Map<Integer, Sector> map = new HashMap<>();
            while (rs.next()) {
                Sector sec = map.get(rs.getInt("SectorId"));
                if (sec == null) {
                    sec = instantiateSector(rs);
                    map.put(rs.getInt("SectorId"), sec);
                }
                Product obj = instantiateProduct(rs, sec);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    public List<Product> All() {
        PreparedStatement st = null;
        ResultSet rs =  null;
        try {
            st =  connection.prepareStatement(
                "SELECT * FROM product ORDER By SectorId");
            rs = st.executeQuery();

            List<Product> list = new ArrayList<>();
            while(rs.next()){
                Product obj = new Product();
                obj.setId(rs.getInt("ProductId"));
                obj.setName(rs.getString("ProductName"));
                obj.setCost(rs.getDouble("Cost"));
                obj.setPrice(rs.getDouble("Price"));
                obj.setDateEntry(rs.getDate("DateEntry"));
                obj.setDateExit(rs.getDate("DateExit"));
                obj.setSector(new Sector());
                obj.getSector().setSectorId(rs.getInt("SectorId")); 
                obj.getSector().mapSectorString(obj.getSector().getSectorId());
                list.add(obj);

            }
            return list;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    @Override
    public List<Product> findByDate() {
        PreparedStatement st = null;
        ResultSet rs =  null;
        try {
            st =  connection.prepareStatement(
                "SELECT product.*, sector.SectorName "
                +"FROM product "
                +"INNER JOIN sector ON product.SectorId = sector.SectorId "
                +"ORDER BY product.DateEntry");
            rs = st.executeQuery();

            List<Product> list = new ArrayList<>();
            while(rs.next()){
                Product obj = new Product();
                Sector sec = instantiateSector(rs);
                obj =  instantiateProduct(rs, sec);
                list.add(obj);
            }
            return list;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    @Override
    public List<Product> findByPrice() {
        PreparedStatement st = null;
        ResultSet rs =  null;
        try {
            st =  connection.prepareStatement(
                "SELECT product.*, sector.SectorName "
                +"FROM product "
                +"INNER JOIN sector ON product.SectorId = sector.SectorId "
                +"ORDER BY product.Price");
            rs = st.executeQuery();
            List<Product> list = new ArrayList<>();
            while(rs.next()){
                Product obj = new Product();
                Sector sec = instantiateSector(rs);
                obj =  instantiateProduct(rs, sec);
                list.add(obj);
            }
            return list;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
            Db.closeResult(rs);
        }
    }

    public Product instantiateProduct(ResultSet rs, Sector sector) throws SQLException {

        Product obj = new Product();
        obj.setId(rs.getInt("ProductId"));
        obj.setName(rs.getString("ProductName"));
        obj.setCost(rs.getDouble("Cost"));
        obj.setPrice(rs.getDouble("Price"));
        obj.setDateEntry(rs.getDate("DateEntry"));
        obj.setDateExit(rs.getDate("DateExit"));
        sector.mapSector(obj.getName());
        obj.setSector(sector);
        obj.getSector().setSectorId(rs.getInt("SectorId"));
        obj.getSector().setSectors(rs.getString("SectorName"));

        return obj;
    }


    private Sector instantiateSector(ResultSet rs) throws SQLException{
        Sector sec = new Sector();
        sec.setSectorId(rs.getInt("SectorId"));
        sec.setSectors(rs.getString("SectorName"));
        return sec;
    }

    
}
