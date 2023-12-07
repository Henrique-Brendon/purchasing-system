package model.dao.entities;

import java.sql.Date;

import Util.cep.CepInfo;

public class Client extends Person{
    
    private CepInfo cepInfo;
    private Card card;

    /**
     * 
     */
    public Client(){

    }

    public Client(String name, Date birthDate, String email, String password, CepInfo cepInfo) {
        super(name, birthDate, email, password);
        this.cepInfo =  cepInfo;
    }


    @Override
    public String toString() {
        return  super.toString() + "\n" + cepInfo.toString();
    }

}
