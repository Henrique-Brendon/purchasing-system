package com.project.application;


import java.sql.Date;

import DB.Db;
import Util.cep.CepInfo;
import model.dao.entities.Client;
import model.dao.entities.Product;
import model.dao.impl.CepInfoDaoJDBC;
import model.dao.impl.ClientDaoJDBC;
import model.dao.impl.ProductDaoJDBC;

public class main {
    public static void main(String[] args) {
        CepInfoDaoJDBC cep = new CepInfoDaoJDBC(Db.getConnection());
        ClientDaoJDBC client = new ClientDaoJDBC(Db.getConnection());

        ProductDaoJDBC product = new ProductDaoJDBC(Db.getConnection());


        Product product2 =  product.findById(1);
        product2.setName("Rx");
        product.update(product2);
        
        Client c1 = client.findById(2);
        c1.setName("Anna");
        client.update(c1);

        System.out.println(c1); 
        }
        
    }
          




