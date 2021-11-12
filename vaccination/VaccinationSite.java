//package assignment8.vaccination;

/* 
 * 
 * Name: VaccinationSite.java
 * Purpose: Represents A Vaccination Site
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class VaccinationSite {
    
    private Random randy;
    private Queue<Patient> waitingQueue;
    private Queue<Vaccine> vacSupply = new LinkedList<>();
    private List<Patient> vaccinated = new ArrayList<>();
    private Nurse[] nurses;
    private String siteName;
    private int currentTime;
    
    public VaccinationSite(String name, int seed, int numNurses, int numVaccines) {
        
        this.siteName = name;
        this.waitingQueue = new PriorityQueue<>(new VacPriority());
        this.randy = new Random(seed);
        
        this.createNurses(numNurses);
        this.orderVaccines(numVaccines);
        
    }
    
    public void createNurses(int numNurses) {
        
        this.nurses = new Nurse[numNurses];
        
        for (int index = 0; index < numNurses; index++) {
            
            this.nurses[index] = new Nurse(index + 1);
            
        }
        
    }
    
    public void orderVaccines(int numVaccines) {
        
        for (int i = 0; i < numVaccines - 1; i++) {
            
            if (i % 3 == 0) {
                
                this.vacSupply.offer(new Moderna());
                
            } else {
                
                this.vacSupply.offer(new Pfizer());
                
            }
            
        }
        
    }
    
    /* Helper Method for openVaccinationSiteLine() and operateVaccinationSite() */
    private Patient rollPatient() {
        
        /* Local Variables */
        int value = this.randy.nextInt(10) + 1;
        
        switch (value) {
        
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            return new Senior(this.currentTime);
            
        case 6:
        case 7:
        case 8:
        case 9:
            return new Adult(this.currentTime);
            
        case 10:
            return new OlderTeen(this.currentTime);
            
        default:
            throw new IllegalArgumentException("Value is not between 1-10");
        
        }
        
    }
    
    public void openVaccinationSiteLine() {
        
        /* Local Variables */
        Patient queuedPatient;
        
        for (this.currentTime = 0; this.currentTime < 10; this.currentTime++) {
            
            for (int currentRoll = 0; currentRoll < 6; currentRoll++) {
                
                queuedPatient = this.rollPatient();
                this.waitingQueue.offer(queuedPatient);
                
            }
            
        }
        
    }
    
    public void operateVaccinationSite(int durationForArriving) {
        
        /* Local Variables */
        int endArrivalTimes;
        Patient tempPatient;
        Vaccine tempVaccine;
        
        endArrivalTimes = durationForArriving + this.currentTime;
        
        while (this.vaccinated.size() != Patient.idCounter || this.currentTime < endArrivalTimes) {
            
            if (this.currentTime < endArrivalTimes) {
                
                for (int currentRoll = 0; currentRoll < 8; currentRoll++) {
                    
                    tempPatient = this.rollPatient();
                    this.waitingQueue.offer(tempPatient);
                    
                }
                
            }
            
            for (Nurse nurse : this.nurses) {
                
                if (!nurse.isFree()) {
                    
                    nurse.decrementTimeRemainingForShot();
                    
                    if (nurse.getTimeRemainingForShot() == 0) {
                        
                        tempPatient = nurse.removeAssignedPatient();
                        tempPatient.setTotalTime(this.currentTime);
                        this.vaccinated.add(tempPatient);
                        
                    }
                    
                }
                
            }
            
            for (Nurse nurse : this.nurses) {
                
                if (nurse.isFree() && !this.waitingQueue.isEmpty()) {
                    
                    if (this.vacSupply.isEmpty()) {
                        
                        System.out.printf("Ran out of vaccine!! %d patients are still waiting.\nSite Shutting Down!\n", this.waitingQueue.size());
                        return;
                        
                    }
                    
                    tempPatient = this.waitingQueue.poll();
                    tempPatient.setShotTime(this.currentTime);
                    
                    tempVaccine = this.vacSupply.poll();
                    tempPatient.setVaccine(tempVaccine);
                    
                    nurse.setAssignedPatient(tempPatient);
                    
                    nurse.setTimeRemainingForShot(this.randy.nextInt(3) + 1);
                    
                }
                
            }
            
            this.currentTime++;
            
        } //end of while loop
        
    }
    
    public void generateVaccinationSiteResults(String outputFileName) throws IOException {
        
        /* Local Variables */
        File outputFile;
        PrintWriter pw;
        int seniorTotalWait = 0, adultTotalWait = 0, olderTeenTotalWait = 0;
        int seniorCount = 0, adultCount = 0, olderTeenCount = 0;
        
        outputFile = new File(outputFileName);
        pw = new PrintWriter(outputFile);
        
        /* Header */
        pw.printf("Data for Vaccination Site %s\n\n", this.siteName);
        pw.println("Summary Data");
        
        for (Nurse nurse : this.nurses) {
            
            pw.printf("%s\n", nurse);
            
        }
        
        pw.println();
        
        for (Patient patient : this.vaccinated) {
            
            if (patient instanceof Senior) {
                
                seniorTotalWait += patient.getTotalTime();
                seniorCount++;
                
            } else if (patient instanceof Adult) {
                
                adultTotalWait += patient.getTotalTime();
                adultCount++;
                
            } else {
                
                olderTeenTotalWait += patient.getTotalTime();
                olderTeenCount++;
                
            }
            
        }
        
        /* Average */
        pw.printf("The average total time per person to vaccinate %d %s is %.2f minutes\n",
                seniorCount, "Seniors", (double) seniorTotalWait / seniorCount);        
        
        pw.printf("The average total time per person to vaccinate %d %s is %.2f minutes\n",
                adultCount, "Adults", (double) adultTotalWait / adultCount);
        
        pw.printf("The average total time per person to vaccinate %d %s is %.2f minutes\n",
                olderTeenCount, "Older Teens", (double) olderTeenTotalWait / olderTeenCount);
        
        pw.printf("The average total time per person to vaccinate %d %s is %.2f minutes\n",
                this.vaccinated.size(), "Patients", (double) (seniorTotalWait + adultTotalWait + olderTeenTotalWait) / this.vaccinated.size());

        pw.println();
        
        pw.printf("%13s%16s%11s%16s%16s%12s%12s   %s\n",
                "PATIENT ID", "PATIENT TYPE", "AGE", "VACCINE", "ARIVAL TIME", "WAIT TIME", "TOTAL TIME", "COST");
        
        for (Patient patient : this.vaccinated) {
            
            pw.printf("%s\n", patient);
            
        }
        
        pw.close();
        
    }

}