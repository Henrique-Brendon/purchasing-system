package com.project.application;
import DB.Db;
import Util.cep.CepInfo;
import model.dao.impl.CepInfoDaoJDBC;







public class main {
    public static void main(String[] args) {
        /* 
        
        
        System.out.println(p);
        */
        CepInfoDaoJDBC cep = new CepInfoDaoJDBC(Db.getConnection());
        cep.insert(CepInfo.cepObject("08240530"));
        
        }


}
          




