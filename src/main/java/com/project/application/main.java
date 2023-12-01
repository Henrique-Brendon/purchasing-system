package com.project.application;

import java.util.Date;

import entities.Product;
import entities.Sector;

public class main {
    public static void main(String[] args) {
        
        Product product = new Product(1, "Cell", 500, 700, new Date(), new Date(), new Sector("hardware"));

        System.out.println(product);

    }
}
