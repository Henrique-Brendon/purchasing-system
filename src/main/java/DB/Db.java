package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Db {
    private static Connection conn = null;

    private static Properties loadProperties(){
        try(FileInputStream arq = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(arq);
            return props;
        }catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                String name = props.getProperty("user");
                String password = props.getProperty("password");
                conn = DriverManager.getConnection(url, name, password);
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    } 

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try{
                st.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResult(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    }

