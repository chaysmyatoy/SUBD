/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author la_merde
 */

//true	idperson	Integer	
//false	name	VarChar(10)	
//false	surname	VarChar(10)	
//false	patronymic	VarChar(10)	
//false	address	VarChar(10)	
//false	number	VarChar(11)	
//false	dob	Date	

public class Personal_information {
   
    private int idperson;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String number;
    private String dob;
 
    
    public Personal_information(int idperson,String name,String surname,String patronymic,String address,String number,String dob) {
        this.idperson =idperson;
        this.name = name;
        this.surname =surname;
        this.patronymic = patronymic;
        this.address =address;
        this.number = number;
        this.dob =dob;
        
    }
    
    @Override
    public String toString() {
        return getsurname();
    }
    
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public int getidperson() {
        return idperson;
    }

    public void setidperson(int idperson) {
        this.idperson = idperson;
    }

     public String getsurname() {
        return surname;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }
     public String getpatronymic() {
        return patronymic;
    }

    public void setpatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
     public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
     public String getnumber() {
        return number;
    }

    public void setnumber(String number) {
        this.number = number;
    }
     public String getdob() {
        return dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }
    
    
}
