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

    public void setCepInfo(CepInfo cepInfo){
        this.cepInfo = cepInfo;
    }
    
    public CepInfo getCepInfo(){
        return cepInfo;
    }

    public Client(String name, Date birthDate, String email, String password) {
        super(name, birthDate, email, password);
    }


    @Override
    public String toString() {
        return  super.toString() + "\n" + cepInfo.toString();
    }

}
