package Util.cep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class CepInfo implements Serializable{

    private int cepId;
    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    
    public static CepInfo localeCep = new CepInfo();

    public CepInfo(){

    }
    
    private CepInfo(String cep, String street, String neighborhood, String city, String state){
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public int getCepId() {
        return cepId;
    }
    
    public void setCepId(int id) {
        this.cepId = id;
    }
    //
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    //
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    //
    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    //
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    //
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    //
    
    public static String consultCep(String cep){
        try{
            String urlJson = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(urlJson);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if(conn.getResponseCode() != 200){
                throw new CepExcetion("Falha na requisição HTTP");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        }catch(IOException e){
            e.getStackTrace();
            return null;
        }
    }

    public static CepInfo cepObject(String json){
        String aux = consultCep(json);

        try{
            final JSONObject jsonObject = new JSONObject(aux);

            String cep = jsonObject.getString("cep");
            String street = jsonObject.getString("logradouro");
            String neighborhood = jsonObject.getString("bairro");
            String state = jsonObject.getString("uf");
            String city = jsonObject.getString("localidade");

            CepInfo cepInfo= new CepInfo(cep, street, neighborhood, state, city);
            CepInfo cepAux =  parametrizarObjeto(cepInfo);
            return cepAux;
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    }
    public CepInfo cepObjectNoStatic(String json){
        String aux = consultCep(json);

        try{
            final JSONObject jsonObject = new JSONObject(aux);

            String cep = jsonObject.getString("cep");
            String street = jsonObject.getString("logradouro");
            String neighborhood = jsonObject.getString("bairro");
            String state = jsonObject.getString("uf");
            String city = jsonObject.getString("localidade");

            CepInfo cepInfo= new CepInfo(cep, street, neighborhood, state, city);
            CepInfo cepAux =  parametrizarObjeto(cepInfo);
            return cepAux;
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    }

    private static CepInfo parametrizarObjeto(CepInfo cep){
        localeCep.setCep(cep.cep);
        localeCep.setStreet(cep.street);
        localeCep.setNeighborhood(cep.neighborhood);
        localeCep.setCity(cep.city);
        localeCep.setState(cep.state);
        return localeCep;
    }

    @Override
    public String toString() {
        return  "Id: " + cepId + "\n" +
                "CEP: " + cep + "\n" +
                "Street: " + street + "\n" +
                "Neighborhood: " + neighborhood + "\n" +
                "City: " + city + "\n" +
                "State: " + state;
    }
}

