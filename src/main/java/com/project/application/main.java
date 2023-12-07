package com.project.application;

import java.sql.Date;


import model.dao.entities.Person;





public class main {
    public static void main(String[] args) {

        Date dateOfBirth = Date.valueOf("1999-01-01");
        Person p = new Person("Henrique", dateOfBirth, "henrique@gmail.com", null);
        System.out.println(p);
        
        }


}
          




