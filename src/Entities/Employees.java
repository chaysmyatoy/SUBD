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

//true	personid	Integer	false	
//false	position	VarChar(10)	

public class Employees {
    private String position;
    private int personid;

    public Employees(int personid, String position) {
        this.position = position;
        this.personid = personid;
    }
    
    @Override
    public String toString() {
        return getposition();
    }

    public String getposition() {
        return position;
    }

    public void setposition(String position) {
        this.position = position;
    }
    
    public int getpersonid() {
        return personid;
    }

    public void setpersonid(int personid) {
        this.personid = personid;
    }
}
