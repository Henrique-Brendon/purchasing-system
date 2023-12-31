package model.entities;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Sector implements Serializable{
    private  static final long serialVersionUID = 1l;

    private String sectors;
    private int sectorId;
    
    public Sector(){

    }

    public Sector(String element){
        sectors =  element; 
    }

    public Sector(String element, int sectorId){
        sectors =  element; 
        this.sectorId = sectorId;
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
        map.put("RTX 2080 TI", new Sector("Hardware"));
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
        map.put("Mouse Gamer", new Sector("Hardware"));
        map.put("Monitor 144hz", new Sector("Hardware"));
        map.put("Samsung s22", new Sector("Electronics"));
        map.put("Iphone 13 Pro", new Sector("Electronics"));
        map.put("Iphone 9", new Sector("Electronics"));
        map.put("Iphone X", new Sector("Electronics"));
        map.put("keyboard gamer", new Sector("peripherals"));
        map.put("chair Gamer", new Sector("peripherals"));
        map.put("monitor 1480p", new Sector("peripherals"));
        map.put("monitor 1080p", new Sector("peripherals"));
        map.put("monitor 4k", new Sector("peripherals"));
        map.put("Moto g20", new Sector("Electronics"));
        map.put("Moto g8", new Sector("Electronics"));
        map.put("Moto z", new Sector("Electronics"));
        map.put("Iphone 8", new Sector("Electronics"));
        map.put("Iphone 15", new Sector("Electronics"));
        map.put("Iphone 14", new Sector("Electronics"));
        map.put("galaxy s22", new Sector("Electronics"));
        map.put("galaxy g7", new Sector("Electronics"));
        map.put("Microwave", new Sector("Electronics"));
        map.put("Air conditioning", new Sector("Electronics"));
        map.put("i5 13700k", new Sector("Hardware"));
        map.put("i7 9800", new Sector("Hardware"));
        map.put("i7 12700k", new Sector("Hardware"));
        map.put("i9 10100H", new Sector("Hardware"));
        map.put("i5 10400h", new Sector("Hardware"));
        map.put("Ryzen 3 2200G", new Sector("Hardware"));
        map.put("Ryzen 3 3400G", new Sector("Hardware"));
        map.put("Ryzen 5 3600", new Sector("Hardware"));
        map.put("Ryzen 5 3600X", new Sector("Hardware"));
        map.put("Ryzen 5 5600", new Sector("Hardware"));
        map.put("Ryzen 7 3600X", new Sector("Hardware"));
        map.put("RTX 4090 TI", new Sector("Hardware"));
        map.put("RX 6900 XTX", new Sector("Hardware"));
        map.put("RX 7600 XT", new Sector("Hardware"));
        map.put("Xiamoi 14", new Sector("Electronics"));
        map.put( "refrigerator", new Sector("Electronics"));
        map.put("RTX 2070 TI", new Sector("Hardware"));

        Sector sec = new Sector();
        
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
        } else {
            sector.setSectorId(4);
        }
    }

    
    public void mapSectorString(Integer number) {
        if(number == 1){
            setSectors("Hardware");
        }else if(number == 2){
            setSectors("peripherals");
        }else if(number == 3){
            setSectors("Electronics");
        }else {
            setSectors("Object not map");
        }
    }
 
}
