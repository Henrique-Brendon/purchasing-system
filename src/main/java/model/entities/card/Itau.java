package model.entities.card;

import java.util.Date;
import java.util.Random;

class Itau extends Card{

    private double credit, debit;

    public Itau(){
        
    }

    public Itau(String agencia, String conta, Integer vvc, Date dateLimt) {
        super(agencia, conta, vvc, dateLimt);
    }

    private void setDebit(double debit){
        this.debit = debit;
    } 

    private void setCredit(double credit){
        this.credit = credit;
    } 

    @Override
    public Card localeBank(String obj) {
        if(obj.equals("8080")){
            Card card = new Itau();
            card.setAgencia("8080");
            card.setConta("3030");
            card.setDateLimit(card.generateDate());
            Random random = new Random();
            card.setVvc(random.nextInt(900) + 100);
            return card;
        }else {
            return null;
        }
    }

    @Override
    public void initialDebit() {
        setDebit(5000.0);
        setCredit(5000.0);
    }

    @Override
    public double getDebit() {
        initialDebit();
        return debit;
    }

    @Override
    public double getCredit() {
        initialDebit();
        return credit;
    }

    @Override
    public void attLimitDebit(double limit) {
        Integer aux = (int) (getDebit() - limit);
        setDebit(aux);
    }

    @Override
    public void attLimitCredit(double limit) {
        Integer aux = (int) (getDebit() - limit);
        setCredit(aux);
    }

    @Override
    public String toString() {
        return "{Bank}:Itau " + super.toString();
    }
}