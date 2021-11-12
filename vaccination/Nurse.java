//package assignment8.vaccination;

/* 
 * 
 * Name: Nurse.java
 * Purpose: Represents A Nurse at a Vaccination Site
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

public class Nurse {
    
    private static int nurseCounter;  // not used
    private boolean isFree;
    private int nurseIDNumber, totalPatientsProcessedByNurse, timeRemainingForShot;
    private Patient assignedPatient;
    
    public Nurse(int nurseIDNumber) {
        
        this.setNurseIDNumber(nurseIDNumber);
        this.setIsFree(true);
        
    }
    
    public void setNurseIDNumber(int nurseIDNumber) {
        
        this.nurseIDNumber = nurseIDNumber;
        Nurse.nurseCounter++;         // not used
        
    }
    
    public int getNurseIDNumber() {
        
        return this.nurseIDNumber;
        
    }
    
    public void setIsFree(boolean isFree) {
        
        this.isFree = isFree;
        
    }
    
    public boolean isFree() {
        
        return this.isFree;
        
    }
    
    public void setAssignedPatient(Patient assignedPatient) {
        
        this.assignedPatient = assignedPatient;
        this.setIsFree(false);
        
    }
    
    public Patient getAssignedPatient() {
        
        return this.assignedPatient;
        
    }
    
    public Patient removeAssignedPatient() {
        
        Patient temporaryPatient = this.assignedPatient;
        this.assignedPatient = null;
        
        this.setIsFree(true);
        this.totalPatientsProcessedByNurse++;
        
        return temporaryPatient;
        
    }
    
    public void setTimeRemainingForShot(int timeRemainingForShot) {
        
        this.timeRemainingForShot = timeRemainingForShot;
        
    }
    
    public int getTimeRemainingForShot() {
        
        return this.timeRemainingForShot;
        
    }
    
    public void decrementTimeRemainingForShot() {
        
        this.timeRemainingForShot--;
        
    }
    
    public String toString() {
        
        return String.format("Nurse %s gives shots to %d persons", this.nurseIDNumber, this.totalPatientsProcessedByNurse);
        
    }

}