package model.entities.card;

import java.util.Date;
import java.util.Random;

class Bradesco extends Card{

    private double credit, debit;

    public Bradesco(){
    }

    public Bradesco(String agencia, String conta, Integer vvc, Date dateLimt) {
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
        if(obj.equals("6060")){
            Card card = new Bradesco();
            card.setAgencia("6060");
            card.setConta("5050");
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
        return "{Bank}:Bradesco " + super.toString();
    }
}
