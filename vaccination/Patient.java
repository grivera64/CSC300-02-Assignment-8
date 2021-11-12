//package assignment8.vaccination;

/* 
 * 
 * Name: Patient.java
 * Purpose: Represents the basic features of a Patient
 *          at a Vaccination Site
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

public abstract class Patient implements Comparable<Patient> {
    
    public static int idCounter;
    
    private int arrivalTime, shotTime, waitTime, totalTime;
    private String patientID;
    private Vaccine vacDose;
    
    public Patient(int arrivalTime) {
        
        this.setArrivalTime(arrivalTime);
        this.setPatientID();
        
    }
    
    public void setArrivalTime(int arrivalTime) {
        
        this.arrivalTime = arrivalTime;
        
    }
    
    public int getArrivalTime() {
        
        return this.arrivalTime;
        
    }
    
    public void setShotTime(int shotTime) {
        
        this.shotTime = shotTime;
        this.waitTime = shotTime - this.arrivalTime;
        
    }
    
    public int getShotTime() {
        
        return this.shotTime;
        
    }
    
    public int getWaitTime() {
        
        return this.waitTime;
        
    }
    
    public void setTotalTime(int endTime) {
        
        this.totalTime = endTime - this.arrivalTime;
        
    }
    
    public int getTotalTime() {
        
        return this.totalTime;
        
    }
    
    public void setPatientID() {
        
        this.patientID = "Patient" + ++Patient.idCounter;
        
    }
    
    public String getPatientID() {
        
        return this.patientID;
        
    }
    
    public void setVaccine(Vaccine vacDose) {
        
        this.vacDose = vacDose;
        
    }
    
    public Vaccine getVacDose() {
        
        return this.vacDose;
        
    }
    
    public abstract void setAge();
    public abstract int getAge();
    public abstract void setPatType();
    public abstract String getPatType();
    //public abstract int compareTo(Patient patient);

}