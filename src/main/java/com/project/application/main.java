package com.project.application;


import java.sql.Date;

import DB.Db;
import Util.cep.CepInfo;
import model.dao.entities.Client;
import model.dao.impl.ClientDaoJDBC;







public class main {
    public static void main(String[] args) {
        
        /*Criar um teste para implementar no findAll */

        ClientDaoJDBC client = new ClientDaoJDBC(Db.getConnection());

        
        Date dateOfBirth = Date.valueOf("1989-01-01");
        Client cliente = new Client("Vanderlei", dateOfBirth, "Vanderleiy@gmail", "123");
        cliente.setCepInfo(CepInfo.cepObject("85604-466")); 
        client.insert(cliente);
        System.out.println(client.findAll());
        
        }


}
          




