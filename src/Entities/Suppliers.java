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

//true	idsuppliers	Integer	false	false	id поставщика		false	false	false
//false	name	VarChar(10)	false	false	имя		false	false	false
//false	representative	VarChar(10)	false	false	компания/фирма		false	false	false
//false	address	VarChar(10)	false	false	адрес		false	false	false
//false	number	VarChar(11)	false	false	номер телефона		false	false	false


public class Suppliers {
    private int idsuppliers;
    private String name;
    private String representative;
    private String address;
    private String number;

    
    public Suppliers(int idsuppliers,String name,String representative,String address,String number) {
        this.idsuppliers = idsuppliers;
        this.representative =representative;
        this.name = name;
        this.address =address;
        this.number = number;

        
    }
    
    @Override
    public String toString() {
        return getname();
    }
    
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public int getidsuppliers() {
        return idsuppliers;
    }

    public void setidsuppliers(int idsuppliers) {
        this.idsuppliers = idsuppliers;
    }

     public String getrepresentative() {
        return representative;
    }

    public void setrepresentative(String representative) {
        this.representative = representative;
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
    
     
}
