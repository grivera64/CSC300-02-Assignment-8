//package assignment8.vaccination;

/* 
 * 
 * Name: Vaccine.java
 * Purpose: Represents an outline of a Vaccine
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

public abstract class Vaccine {
    
    private String maker;
    
    public Vaccine(String maker) {
        
        this.setMaker(maker);
        
    }
    
    public void setMaker(String maker) {
        
        this.maker = maker;
        
    }
    
    public String getMaker() {
        
        return this.maker;
        
    }
    
    public abstract void setDoseID();
    public abstract String getDoseID();
    public abstract double getDoseCost();

}