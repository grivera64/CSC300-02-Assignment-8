//package assignment8.vaccination;

/* 
 * 
 * Name: Adult.java
 * Purpose: Represents a Patient that is 20-60 years of age
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.util.Random;

public class Adult extends Patient {
    
    private static Random randyAdult = new Random(5);
    private int age;
    private String patType;
    
    public Adult(int arrivalTime) {
        
        super(arrivalTime);
        this.setAge();
        this.setPatType();
        
    }
    
    public void setAge() {
        
        this.age = Adult.randyAdult.nextInt(41) + 20;
        
    }
    
    public int getAge() {
        
        return this.age;
        
    }
    
    public void setPatType() {
        
        this.patType = "Adult";
        
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