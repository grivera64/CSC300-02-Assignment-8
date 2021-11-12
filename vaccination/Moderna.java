//package assignment8.vaccination;

/* 
 * 
 * Name: Moderna.java
 * Purpose: Represents A Vaccine made by Moderna
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

public class Moderna extends Vaccine {
    
    private static int modernaDoseCounter;
    private String doseID;
    private final double doseCost = 12.50;
    
    public Moderna() {
        
        super("Moderna");
        this.setDoseID();
        
    }
    
    public void setDoseID() {
        
        this.doseID = "Moderna" + ++Moderna.modernaDoseCounter;
        
    }
    
    public String getDoseID() {
        
        return this.doseID;
        
    }
    
    public double getDoseCost() {
        
        return this.doseCost;
        
    }

}