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

//true	idservices	Integer	
//false	name	VarChar(10)	
//false	description	VarChar(10)	
//false	value	VarChar(10)	

public class Services {
    private int idservices;
    private String name;
    private String description;
    private String value;
    
    public Services(int idservices,String name,String description,String value) {
        this.idservices =idservices;
        this.name = name;
        this.description =description;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return getname();
    }

   
    
    public int getidservices() {
        return idservices;
    }

    public void setidservices(int idservices) {
        this.idservices = idservices;
    }
     public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    
    
    
    public String getvalue() {
        return value;
    }

    public void setvalue(String value) {
        this.value = value;}
        
    
    
         public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
}
