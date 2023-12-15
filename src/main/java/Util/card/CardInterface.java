package Util.card;

import java.util.Date;

public interface CardInterface{
    Object localeBank(String obj);
    void initialDebit();
    double getDebit();
    double getCredit();
    void attLimitDebit(double limit);
    void attLimitCredit(double limit);
    Date generateDate();
   
}
