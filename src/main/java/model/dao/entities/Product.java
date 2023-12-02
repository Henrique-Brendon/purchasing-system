package model.dao.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Product implements Serializable {
    private Integer id;
    private String name;
    private double cost;
    private double price;
    private Date dateEntry;
    private Date dateExit;
    private Sector sector;

    public Product(){

    }

    public Product(Integer id, String name, double cost, double price, Date dateEntry, Date dateExit, Sector sector) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.dateEntry = dateEntry;
        this.dateExit = dateExit;
        this.sector = sector;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    private String formatDate(Date date) {
        if(date != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(date);
        }else {
            return "N/A";
        }
    }

    @Override
    public String toString() {
        return "{Product} =  #" + id + ", name " + name + ", cost " + cost + "$ \n"
                + " price=" + price + "$ , dateEntry("
                + formatDate(getDateEntry()) + ") , dateExit(" + formatDate(getDateExit()) + "), sector=" + sector;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    private String generatedString() {
        String[] aux = new String[60];
        aux[0] = "Ryzen 3 2200G";
        aux[1] = "Ryzen 3 3400G";
        aux[2] = "Ryzen 5 3600";
        aux[3] = "Ryzen 5 3600X";
        aux[4] = "Ryzen 5 5600";
        aux[5] = "Ryzen 5 500G";
        aux[6] = "Ryzen 5 500X";
        aux[7] = "Ryzen 7 3600X";
        aux[8] = "i5 10400h";
        aux[9] = "i5 13700k";
        aux[10] = "i7 9800";
        aux[11] = "i7 12700k";
        aux[12] = "i9 10100H";
        aux[13] = "RTX 2060 SUPER";
        aux[14] = "RTX 3060";
        aux[15] = "RTX 3060 TI";
        aux[16] = "RTX 3070 TI";
        aux[17] = "RTX 3080 TI";
        aux[18] = "RTX 4060 TI";
        aux[19] = "RTX 4070 TI";
        aux[20] = "RTX 4080 TI";
        aux[21] = "RTX 4090 TI";
        aux[22] = "RX 6600";
        aux[23] = "RX 6700 XT";
        aux[24] = "RX 6900 XTX";
        aux[25] = "RX 7600 XT";
        aux[26] = "Mouse gamer";
        aux[27] = "keyboard gamer";
        aux[28] = "chair Gamer";
        aux[29] = "monitor 1080p";
        aux[30] = "monitor 1400p";
        aux[31] = "monitor 4k";
        aux[32] = "Moto g20";
        aux[33] = "Moto g8";
        aux[34] = "Moto z";
        aux[35] = "Iphone 8";
        aux[36] = "Iphone 15";
        aux[37] = "Xiamoi 12";
        aux[38] = "Xiamoi 14";
        aux[39] = "galaxy s22";
        aux[40] = "galaxy g7";
        aux[41] = "Microwave";
        aux[42] = "refrigerator";
        aux[43] = "Air conditioning";
        aux[44] = "RTX 2060";
        aux[45] = "RTX 2070";
        aux[46] = "RTX 2070 TI";
        aux[47] = "RTX 2080";
        aux[48] = "RTX 2080 TI";
        aux[49] = "RTX 3070";
        aux[50] = "RTX 3070 TI";
        aux[51] = "RTX 3080";
        aux[52] = "RTX 3080 TI";
        aux[54] = "RX 6800 ";
        aux[55] = "RX 6800 XT";
        aux[56] = "i5 1100";
        aux[57] = "i7 9800";
        aux[58] = "i7 1200";
        aux[59] = "i9 1300K";

        Random random = new Random();

        return aux[random.nextInt(59)]; 
    }

    private static Date generateDate() {
        Random random = new Random();
        int day = random.nextInt(28) + 1;
        int month = random.nextInt(12) + 1;
        int year = random.nextInt(2019, 2020);
        LocalDate localDate = LocalDate.of(year, month, day);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private Product mappingObject() {
        Map<String, Product> map = new HashMap<>();
        Sector sector = new Sector(""); 
        map.put("RTX 2060", new Product(null, "RTX 2060", 700.0, 1500.0, null,null, sector));
        map.put("RTX 2060 SUPER", new Product(null, "RTX 2060 SUPER", 900, 1700.0, null,null, sector));
        map.put("RTX 2070", new Product(null, "RTX 2070", 1200, 1900.0, null,null, sector));
        map.put("RTX 2080", new Product(null, "RTX 2080", 800, 2300.0, null,null, sector));
        map.put("RTX 3060", new Product(null, "RTX 3060", 2150, 2350.0, null,null, sector));
        map.put("RTX 3060 TI", new Product(null, "RTX 3060 TI", 2300, 2600.0, null,null, sector));
        map.put("RTX 3070", new Product(null, "RTX 3070", 2350, 2500.0, null,null, sector));
        map.put("RTX 3070 TI", new Product(null, "RTX 3070 TI", 2500, 2800.0, null,null, sector));
        map.put("RTX 3080", new Product(null, "RTX 3080", 2600, 3000.0, null,null, sector));
        map.put("RTX 3080 TI", new Product(null, "RTX 3080 TI ", 3000, 3500.0, null,null, sector));
        map.put("RTX 4060", new Product(null, "RTX 4060", 2500, 3000.0, null,null, sector));
        map.put("RTX 4060 TI", new Product(null, "RTX 4060 TI", 3000, 3500.0, null,null, sector));
        map.put("RTX 4070", new Product(null, "RTX 4070", 3100, 3300.0, null,null, sector));
        map.put("RTX 4070 TI", new Product(null, "RTX 4070 TI", 3400, 3700.0, null,null, sector));
        map.put("RTX 4080", new Product(null, "RTX 4080", 3800, 4200.0, null,null, sector));
        map.put("RTX 4080 TI", new Product(null, "RTX 4080 TI", 3800, 4500.0, null,null, sector));
        map.put("RX 6600", new Product(null, "RX 6600", 2000, 2300.0, null,null, sector));
        map.put("RX 6600 XT", new Product(null, "RX 6600 XT", 1900, 2500.0, null,null, sector));
        map.put("RX 6700", new Product(null, "RX 6700", 2100, 2600.0, null,null, sector));
        map.put("RX 6700 XT", new Product(null, "RX 6700 XT", 2200, 2800.0, null,null, sector));
        map.put("RX 6800", new Product(null, "RX 6800", 2300, 3000.0, null,null, sector));
        map.put("RX 6800 XT", new Product(null, "RX 6800 XT", 2800, 3200.0, null,null, sector));
        map.put("Ryzen 5 3600", new Product(null, "Ryzen 5 3600", 100, 500.0, null,null, sector));
        map.put("Ryzen 5 4650", new Product(null, "Ryzen 5 4650", 100, 600.0, null,null, sector));
        map.put("Ryzen 5 5600G", new Product(null, "Ryzen 5 5600G", 100, 700.0, null,null, sector));
        map.put("Ryzen 5 5600X", new Product(null, "Ryzen 5 5600X", 500, 900.0, null,null, sector));
        map.put("i5 1100", new Product(null, "i5 1100", 600, 850.0, null,null, sector));
        map.put("i7 9800", new Product(null, "i7 9800", 800, 1100.0, null,null, sector));
        map.put("i7 1200", new Product(null, "i7 1200", 1900, 2500.0, null,null, sector));
        map.put("i9 1300K", new Product(null, "i9 1300K", 2100, 3200.0, null,null, sector));
        map.put("Mouse Gamer", new Product(null, "Mouse Gamer", 30, 70.0, null,null, sector));
        map.put("Monitor 144hz", new Product(null, "Monitor 144hz", 700, 1200.0, null,null, sector));
        map.put("Samsung s22", new Product(null, "Samsung s22", 2100, 2500.0, null,null, sector));
        map.put("Iphone 13 Pro", new Product(null, "Iphone 13 Pro", 2500, 3000.0, null,null, sector));
        map.put("Iphone 9", new Product(null, "Iphone 9", 400, 900.0, null,null, sector));
        map.put("Iphone X", new Product(null, "Iphone X", 4000, 1000.0, null,null, sector));
        map.put("keyboard gamer", new Product(null, "Keyboard gamer", 200, 400, null,null, sector));
        map.put("chair Gamer", new Product(null, "chair Gamer", 400, 700, null,null, sector));
        map.put("monitor 1480p", new Product(null, "monitor 1480p", 800, 1500, null,null, sector));
        map.put("monitor 1080p", new Product(null, "monitor 1080p", 500, 1000, null,null, sector));
        map.put("monitor 4k", new Product(null, "monitor 4k", 2000, 4000, null,null, sector));
        map.put("Moto g20", new Product(null, "Moto g20", 1000, 1500, null,null, sector));
        map.put("Moto g8", new Product(null, "Moto g8", 800, 1000, null,null, sector));
        map.put("Moto z", new Product(null, "Moto z", 1500, 3000, null,null, sector));
        map.put("Iphone 8", new Product(null, "Iphone 8", 800, 1000, null,null, sector));
        map.put("Iphone 15", new Product(null, "Iphone 15", 3000, 5000, null,null, sector));
        map.put("Iphone 12", new Product(null, "Iphone 12", 1300, 2800, null,null, sector));
        map.put("Iphone 14", new Product(null, "Iphone 14", 1600, 3200, null,null, sector));
        map.put("galaxy s22", new Product(null, "galaxy s22", 1100, 2200, null,null, sector));
        map.put("galaxy g7", new Product(null, "galaxy g7", 600, 900, null, new Date( 2010), sector));
        map.put("Microwave", new Product(null, "Microwave", 200, 500, null,null, sector));
        map.put("Air conditioning", new Product(null, "Air conditioning", 1100, 2200, null,null, sector));
        map.put("i5 13700k", new Product(null, "i5 13700k", 1600, 2000, null,null, sector));
        map.put("i7 9800", new Product(null, "i7 9800", 800, 1400, null,null, sector));
        map.put("i7 12700k", new Product(null, "i7 12700k", 1100, 1500, null,null, sector));
        map.put("i9 10100H", new Product(null, "i9 10100H", 1300, 2500, null,null, sector));
        map.put("i5 10400h", new Product(null, "i5 10400h", 700, 1400, null,null, sector));
        map.put("Ryzen 3 2200G", new Product(null, "Ryzen 3 2200G", 80, 200, null,null, sector));
        map.put(" Ryzen 3 3400G", new Product(null, " Ryzen 3 3400G", 150, 300, null,null, sector));
        map.put("Ryzen 5 3600", new Product(null, "Ryzen 5 3600", 250, 500, null,null, sector));
        map.put("Ryzen 5 3600X", new Product(null, "Ryzen 5 3600X", 300, 600, null,null, sector));
        
        Product product = new Product();
        String aux = generatedString();
        Product productAux = map.get(aux);

        if(productAux == null && productAux == null){
            Product productTrash =  productAux; 
        } else {
            product =  productAux; 
        }
        product.setDateEntry(generateDate());
        product.setDateExit(generateDate());
        product.setSector(sector.mapSector(product.getName()));
        return product;
    }

    public List<Product> popularDataBase(int quantity){
        List<Product> products = new LinkedList<>();
        for(int i = 0; i<quantity; i++){
            products.add(mappingObject());
        }

        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            if(iterator.next() == null){
                iterator.remove();
            }
        }
         return products;
    }

}
