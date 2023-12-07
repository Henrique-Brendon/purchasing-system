package com.project.application;


import DB.Db;

import model.dao.impl.SectorDaoJDBC;




public class main {
    public static void main(String[] args) {
        SectorDaoJDBC secJDBC = new SectorDaoJDBC(Db.getConnection());
        System.out.println(secJDBC.findAll());
        

        
        
        }
}
          




