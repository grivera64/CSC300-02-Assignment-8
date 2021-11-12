//package assignment8.vaccination;

/* 
 * 
 * Name: OlderTeen.java
 * Purpose: Represents A Patient of 16-19 years old
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.util.Random;

public class OlderTeen extends Patient {
    
    private static Random randyOlderTeen = new Random(10);
    private int age;
    private String patType;
    
    public OlderTeen(int arrivalTime) {
        
        super(arrivalTime);
        this.setAge();
        this.setPatType();
        
    }
    
    public void setAge() {
        
        this.age = OlderTeen.randyOlderTeen.nextInt(4) + 16;
        
    }
    
    public int getAge() {
        
        return this.age;
        
    }
    
    public void setPatType() {
        
        this.patType = "OlderTeen";
        
    }
    
    public String getPatType() {
        
        return this.patType;
        
    }
    
    public int compareTo(Patient patient) {
        
        return (int) Math.signum(this.age - patient.getAge());
        
    }
    
    public String toString() {
        
        return String.format("%13s%16s%11d%16s%12d%12d%12d     $%.2f", 
                this.getPatientID(), this.patType, this.age, this.getVacDose().getMaker(),
                this.getArrivalTime(), this.getWaitTime(), this.getTotalTime(), this.getVacDose().getDoseCost());
        
    }

}