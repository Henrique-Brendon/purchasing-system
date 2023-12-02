package com.project.application;


import DB.Db;
import model.dao.entities.Product;


public class main {
    public static void main(String[] args) {
        
        Product product = new Product();

        Db.getConnection();

        

        System.out.println(product.popularDataBase(1));

    }
}
