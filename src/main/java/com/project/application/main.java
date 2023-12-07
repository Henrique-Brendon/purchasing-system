package com.project.application;

import java.sql.Date;

import Util.cep.CepInfo;
import model.dao.entities.Client;







public class main {
    public static void main(String[] args) {
        /* 
        
        
        System.out.println(p);
        */
        Date dateOfBirth = Date.valueOf("1999-01-01");
        Client p = new Client("Henrique", dateOfBirth, "henrique@gmail.com", "1234", new CepInfo().cepObject("08240530"));
        System.out.println(p);
        
        }


}
          




