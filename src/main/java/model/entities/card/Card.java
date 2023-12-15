package model.entities.card;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import Util.card.CardInterface;

public class Card implements CardInterface{
    private int id;
    private String agencia;
    private String conta;
    private Integer vvc;
    private Date dateLimit;

    public Card(){

    }

    public Card(String agencia, String conta, Integer vvc, Date dateLimt){
        this.agencia =  agencia;
        this.conta = conta;
        this.vvc = vvc;
        this.dateLimit = dateLimt;
    }

    public String getAgencia() {
        return agencia;
    }
    
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getVvc() {
        return vvc;
    }

    public void setVvc(Integer vvc) {
        this.vvc = vvc;
    }

    public Date getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Date dateLimit) {
        this.dateLimit = dateLimit;
    }

    @Override
    public Card localeBank(String obj) {
        if(obj.equals("1010")){
            return new BankBrasil().localeBank(obj);
        }else if(obj.equals("6060")){
            return new Bradesco().localeBank(obj);
        }
        else if(obj.equals("9090")){
            return new Caixa().localeBank(obj);
        }else if(obj.equals("8080")){
            return new Itau().localeBank(obj);
        }
        else if(obj.equals("5050")){
            return new Santander().localeBank(obj);
        }else {
            return null;
        }
    }

    @Override
    public void initialDebit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialDebit'");
    }

    @Override
    public double getDebit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDebit'");
    }

    @Override
    public double getCredit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCredit'");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Card other = (Card) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public void attLimitDebit(double limit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attLimitDebit'");
    }

    @Override
    public void attLimitCredit(double limit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attLimitCredit'");
    }


    @Override
    public String toString() {
        return " Agencia(" + agencia + "), conta(" + conta + "), vvc:" + vvc + ", dateLimit " + formatDate(dateLimit);
    }

    @Override
    public Date generateDate() {
        Random random = new Random();
        int day = random.nextInt(28) + 1;
        int month = random.nextInt(12) + 1;
        int year = random.nextInt(2030, 2035);
        LocalDate localDate = LocalDate.of(year, month, day);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDate(Date date) {
        if(date != null){
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
            return sdf.format(date);
        }else {
            return "N/A";
        }
    }

}
