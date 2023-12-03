package com.project.application;


import java.util.Date;

import DB.Db;
import model.dao.entities.Product;
import model.dao.entities.Sector;
import model.dao.impl.ProductDaoJDBC;


public class main {
    public static void main(String[] args) {

        Sector sector = new Sector("Hardware");
        sector.mapSectorId(sector);
        
        Product product = new Product(null, "GTX 1060",  200, 500, new Date(),new Date(), sector);


        ProductDaoJDBC productJDBC = new ProductDaoJDBC(Db.getConnection());

        productJDBC.insert(product);



    }
}
