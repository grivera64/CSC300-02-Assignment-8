//package assignment8.vaccination;

/* 
 * 
 * Name: Senior.java
 * Purpose: Represents A Patient of the age 61-100
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.util.Random;

public class Senior extends Patient {
    
    private static Random randy = new Random(8);
    private int age;
    private String patType;
    
    public Senior(int arrivalTime) {
        
        super(arrivalTime);
        this.setAge();
        this.setPatType();
        
    }
    
    public void setAge() {
        
        this.age = Senior.randy.nextInt(40) + 61;
        
    }
    
    public int getAge() {
        
        return this.age;
        
    }
    
    public void setPatType() {
        
        this.patType = "Senior";
        
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