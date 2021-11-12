//package assignment8.vaccination;

/* 
 * 
 * Name: Pfizer.java
 * Purpose: Represents A Vaccine made by Pfizer
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

public class Pfizer extends Vaccine {
    
    private static int pfizerDoseCounter;
    private String doseID;
    private final double doseCost = 15.50;
    
    public Pfizer() {
        
        super("Pfizer");
        this.setDoseID();
        
    }
    
    public void setDoseID() {
        
        this.doseID = "Pfizer" + ++Pfizer.pfizerDoseCounter;
        
    }
    
    public String getDoseID() {
        
        return this.doseID;
        
    }
    
    public double getDoseCost() {
        
        return this.doseCost;
        
    }

}