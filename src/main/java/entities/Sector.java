package entities;

import java.io.Serializable;

public class Sector implements Serializable{
    private  static final long serialVersionUID = 1l;

    private String sectors;


    public Sector(String element){
        sectors =  element; 
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    @Override
    public String toString() {
        return "{Sector} " + sectors;
    }

    
    
}
