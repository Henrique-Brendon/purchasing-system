package model.dao.entities;

import java.sql.Date;

import Util.cep.CepInfo;

public class Client extends Person{
    
    private CepInfo cepInfo;
    private Card card;
    private int id;

    /**
     * 
     */

    public Client(){
    }

    public Client(CepInfo cepInfo){
        this.cepInfo = cepInfo;
    }

    public Client(String name, Date birthDate, String email, String password) {
        super(name, birthDate, email, password);
    }

    public Client(int id, String name, Date birthDate, String email, String password, CepInfo cepInfo) {
        super(name, birthDate, email, password);
        this.cepInfo = cepInfo;
        this.id = id;
    }

    public Client(String name, Date birthDate, String email, String password, CepInfo cepInfo) {
        super(name, birthDate, email, password);
        this.cepInfo = cepInfo;
    }



    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

    public void setCepInfo(CepInfo cepInfo){
        this.cepInfo = cepInfo;
    }
    
    public CepInfo getCepInfo(){
        return cepInfo;
    }




    @Override
    public String toString() {
        return  super.toString() + "\n" + cepInfo.toString() + "\n";
    }

}
