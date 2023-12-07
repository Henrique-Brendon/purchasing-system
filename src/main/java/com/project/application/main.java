package com.project.application;


import DB.Db;
import model.dao.impl.ProductDaoJDBC;




public class main {
    public static void main(String[] args) {
        ProductDaoJDBC dao = new ProductDaoJDBC(Db.getConnection());
        System.out.println(dao.getSize());
		System.out.println("\n=== TEST 2: findAll =======");
        System.out.println(dao.findByPrice());
        

        //dao.insertList(new Product().popularDataBase(10))
		//
       // productJDBC.update(product);
        /* 

        */
        //Bug encontrado, método update muda todos os objetos se não houver parâmetro
        

        
        
        }
}
          




