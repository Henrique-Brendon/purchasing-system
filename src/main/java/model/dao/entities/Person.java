package model.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Person implements Serializable{
    private String name;
    private Date birthDate;
    private String email;
    private String password;

    public Person(){

    }
    
    public Person(String name, Date birthDate, String email, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int calculateAge(Date dateOfBirth){
        LocalDate birthDate = dateOfBirth.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
        
    }

    @Override
    public String toString() {
        return "Nome: " + name + ", birthDate " + Product.formatDate(birthDate) + ": ("+ calculateAge(getBirthDate())+") years, email " + email;
    }

    
}
