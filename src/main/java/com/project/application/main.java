package com.project.application;
import java.sql.Date;

import DB.Db;
import Util.cep.CepInfo;
import model.dao.entities.Client;
import model.dao.impl.CepInfoDaoJDBC;
import model.dao.impl.ClientDaoJDBC;







public class main {
    public static void main(String[] args) {
        /* 
        
        
        System.out.println(p);
        */
        Date dateOfBirth = Date.valueOf("1949-01-01");
        ClientDaoJDBC client = new ClientDaoJDBC(Db.getConnection());
        Client cliente = new Client("Brendon", dateOfBirth, "Brendon@gmail", "123");
        cliente.setCepInfo(CepInfo.cepObject("08240530"));
        client.insert(cliente);
        
        }


}
          




