package com.project.application;


import java.util.LinkedList;
import java.util.List;

import DB.Db;
import model.dao.entities.Product;
import model.dao.impl.ProductDaoJDBC;



public class main {
    public static void main(String[] args) {

        Product product = new Product();
        ProductDaoJDBC productJDBC = new ProductDaoJDBC(Db.getConnection());

        List<Product> productList = new LinkedList<>();
        productList = product.popularDataBase(100);
        System.out.println(productList);
        productJDBC.insertList(productList);

        

        
        
        }
}
          




