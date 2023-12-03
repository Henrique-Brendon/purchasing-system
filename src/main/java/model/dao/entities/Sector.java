package model.dao.entities;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sector implements Serializable{
    private  static final long serialVersionUID = 1l;

    private String sectors;
    private int sectorId;
    
    public Sector(){}

    public Sector(String element){
        sectors =  element; 
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }
    

    @Override
    public String toString() {
        return "(" + sectors + ") sectorId = " + getSectorId();
    }

    public Sector mapSector(String aux){
        Map<String, Sector> map = new HashMap<>();
        map.put("RTX 2060", new Sector("Hardware"));
        map.put("RTX 2060 SUPER", new Sector("Hardware"));
        map.put("RTX 2070", new Sector("Hardware"));
        map.put("RTX 2080", new Sector("Hardware"));
        map.put("RTX 3060", new Sector("Hardware")); 
        map.put("RTX 3060 TI", new Sector("Hardware"));
        map.put("RTX 3070", new Sector("Hardware"));
        map.put("RTX 3070 TI", new Sector("Hardware"));
        map.put("RTX 3080", new Sector("Hardware"));
        map.put("RTX 3080 TI", new Sector("Hardware"));
        map.put("RTX 4060", new Sector("Hardware")); 
        map.put("RTX 4060 TI", new Sector("Hardware"));
        map.put("RTX 4070", new Sector("Hardware"));
        map.put("RTX 4070 TI", new Sector("Hardware"));
        map.put("RTX 4080", new Sector("Hardware"));
        map.put("RTX 4080 TI", new Sector("Hardware"));
        map.put("RX 6600", new Sector("Hardware"));
        map.put("RX 6600 XT", new Sector("Hardware"));
        map.put("RX 6700", new Sector("Hardware"));
        map.put("RX 6700 XT", new Sector("Hardware"));
        map.put("RX 6800", new Sector("Hardware"));
        map.put("RX 6800 XT", new Sector("Hardware"));   
        map.put("Ryzen 5 3600", new Sector("Hardware"));
        map.put("Ryzen 5 4650", new Sector("Hardware"));
        map.put("Ryzen 5 5600G", new Sector("Hardware"));
        map.put("Ryzen 5 5600X", new Sector("Hardware"));
        map.put("i5 1100", new Sector("Hardware"));
        map.put("i7 9800", new Sector("Hardware")); 
        map.put("i7 1200", new Sector("Hardware")); 
        map.put("i9 1300K", new Sector("Hardware"));
        map.put("Mouse Gamer", new Sector("peripherals"));
        map.put("Monitor 144hz", new Sector("peripherals"));
        map.put("Samsung s22", new Sector("peripherals"));
        map.put("Iphone 13 Pro", new Sector("peripherals"));
        map.put("Iphone 9", new Sector("peripherals"));
        map.put("Iphone X", new Sector("peripherals"));
        map.put("keyboard gamer", new Sector("peripherals"));
        map.put("chair Gamer", new Sector("peripherals"));
        map.put("monitor 1480p", new Sector("Electronics"));
        map.put("monitor 1080p", new Sector("Electronics"));
        map.put("monitor 4k", new Sector("Electronics"));
        map.put("Moto g20", new Sector("peripherals"));
        map.put("Moto g8", new Sector("peripherals"));
        map.put("Moto z", new Sector("peripherals"));
        map.put("Iphone 8", new Sector("peripherals"));
        map.put("Iphone 15", new Sector("peripherals"));
        map.put("Iphone 12", new Sector("peripherals"));
        map.put("Iphone 14", new Sector("peripherals"));
        map.put("galaxy s22", new Sector("peripherals"));
        map.put("galaxy g7", new Sector("peripherals"));
        map.put("Microwave",  new Sector("Electronics"));
        map.put("Air conditioning", new Sector("Electronics"));
        map.put("i5 13700k",new Sector("Hardware"));
        map.put("i7 9800",new Sector("Hardware"));
        map.put("i7 12700k", new Sector("Hardware"));
        map.put("i9 10100H", new Sector("Hardware"));
        map.put("i5 10400h", new Sector("Hardware"));
        map.put("Ryzen 3 2200G", new Sector("Hardware"));
        map.put(" Ryzen 3 3400G", new Sector("Hardware"));
        map.put("Ryzen 5 3600", new Sector("Hardware"));
        map.put("Ryzen 5 3600X", new Sector("Hardware"));
        Sector sec = new Sector("");
        
        if(map.get(aux) != null){
            sec = map.get(aux);
        }
        mapSectorId(sec);
        return sec;
    }

    public void mapSectorId(Sector sector) {
        if ("Hardware".equals(sector.getSectors())) {
            sector.setSectorId(1);
        } else if ("peripherals".equals(sector.getSectors())) {
            sector.setSectorId(2);
        } else if ("Electronics".equals(sector.getSectors())) {
            sector.setSectorId(3);
        }
    }
    
    
}
