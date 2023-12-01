package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable{
    private int id;
    private String name;
    private double cost;
    private double price;
    private Date dateEntry;
    private Date dateExit;
    private Sector sector;

    public Product(){

    }

    public Product(int id, String name, double cost, double price, Date dateEntry, Date dateExit, Sector sector) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.dateEntry = dateEntry;
        this.dateExit = dateExit;
        this.sector = sector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public Date getDateExit() {
        return dateExit;
    }

    public void setDateExit(Date dateExit) {
        this.dateExit = dateExit;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    private String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String dateFormat = sdf.format(date);
        return dateFormat;
    }

    @Override
    public String toString() {
        return "{Product} =  #" + id + ", name " + name + ", cost " + cost + "$ \n"
        + " price=" + price + "$ , dateEntry("
                +  formatDate(getDateEntry()) + ") , dateExit(" + formatDate(getDateExit()) + "), sector=" + sector;
    }

    

    

    
}
