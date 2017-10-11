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
//idorders	Integer	
//servicesid	Integer	
//suppliersid	Integer
//dod	Date	
//personid	Integer
public class Orders {
    private int idorders;
    private String dod;
    private int servicesid;
    private int suppliersid;
    private int personid;

    public Orders(int idorders,  int servicesid, int suppliersid,String dod, int personid) {
        this.idorders = idorders;
        this.dod = dod;
        this.servicesid= servicesid;
        this.suppliersid = suppliersid;
      this.personid = personid;
    }
    
    @Override
    public String toString() {
        return getdod();
    }
    
    public int getIdorders() {
        return idorders;
    }

    public void setIdorders(int idorders) {
        this.idorders = idorders;
    }

    public String getdod() {
        return dod;
    }

    public void setdod(String dod) {
        this.dod = dod;
    }

    public int getservicesid() {
        return servicesid;
    }

    public void setservicesid(int servicesid) {
        this.servicesid = servicesid;
    }

    public int getsuppliersid() {
        return suppliersid;
    }

    public void setsuppliersid(int suppliersid) {
        this.suppliersid = suppliersid;
    }

    public int getpersonid() {
        return personid;
    }

    public void setpersonid(int personid) {
        this.personid = personid;
    }
}