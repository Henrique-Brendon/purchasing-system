package com.project.application;

import DB.Db;
import model.dao.impl.CepInfoDaoJDBC;

public class main {
    public static void main(String[] args) {

        CepInfoDaoJDBC cep = new CepInfoDaoJDBC(Db.getConnection());
        System.out.println(cep.findAll());
        
        /* 
        ClientDaoJDBC client = new ClientDaoJDBC(Db.getConnection());

        
        Date dateOfBirth = Date.valueOf("1989-01-01");
        Client cliente = new Client("Vanderlei", dateOfBirth, "Vanderleiy@gmail", "123");
        cliente.setCepInfo(CepInfo.cepObject("85604-466")); 
        client.insert(cliente);
        System.out.println(client.findAll());
        */
        
        }


}
          




