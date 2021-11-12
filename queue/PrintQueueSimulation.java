//package assignment8.queue;

/* 
 * 
 * Name: PrintQueueSimulation.java
 * Purpose: Represents A Printer Simulation with 
 *          several prioritized jobs
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PrintQueueSimulation {
    
    private Queue<Job> waitQueue = new PriorityQueue<>();
    private int totalWaitTime;
    private Queue<Job> finishedQueue;
    private int currentTime;
    private Printer[] printer;
    private Random randy;
    private int numberOfPrinters;
    private int numberOfPrintJobs;
    
    public PrintQueueSimulation(int numberOfJobs, int numberOfPrinters, long seed) {
        
        this.numberOfPrintJobs = numberOfJobs;
        this.numberOfPrinters = numberOfPrinters;
        
        this.randy = new Random(seed);
        this.waitQueue = new PriorityQueue<>(numberOfJobs);
        this.finishedQueue = new PriorityQueue<>(numberOfJobs);
        
        this.printer = new Printer[numberOfPrinters];
        for (int index = 0; index < numberOfPrinters; index++) {
            
            this.printer[index] = new Printer("Printer" + index);
            
        }
        
    }
    
    public void simulate() {
        
        /* Local Variables */
        boolean flagDone = false;
        Job tempJob;
        int jobCount = 0;
        
        /* Loop until done */
        while (!flagDone) {
            
            /* Create new job */
            if (this.currentTime % 100 == 0 && jobCount < this.numberOfPrintJobs) {
                
                tempJob = new Job(this.currentTime, this.randy.nextInt(991) + 10, this.randy.nextInt(10) + 1);
                this.waitQueue.add(tempJob);
                jobCount++;
                
            }
            
            for (Printer p : this.printer) {
                
                tempJob = p.getJob();
                
                if (tempJob == null) {
                    
                    continue;
                    
                }
                
                if (tempJob.getTimeForJob() <= this.currentTime - tempJob.getStartTime()) {
                    
                    tempJob.setEndTime(this.currentTime);
                    this.finishedQueue.offer(tempJob);
                    p.setJob(null);
                    p.setStartIdleTime(this.currentTime);
                    
                }
                
            }
            
            for (Printer p : this.printer) {
                
                if (p.getJob() != null || this.waitQueue.isEmpty()) {
                    
                    continue;
                    
                }
                
                tempJob = this.waitQueue.poll();
                tempJob.setStartTime(this.currentTime);
                
                p.setJob(tempJob);
                p.setStartInUseTime(this.currentTime);
                
                this.totalWaitTime += tempJob.getWaitTime();
                
            }
            
            this.currentTime++;
            
            if (jobCount >= this.numberOfPrintJobs && this.waitQueue.isEmpty()) {
                
                flagDone = true;
                
            }
            
            for (Printer p : printer) {
                
                if (p.getJob() != null) {
                    
                    flagDone = false;
                    break;
                    
                }
                
            }
            
        } //end of while loop
        
        this.displayStatistics();
        
    }
    
    public void displayStatistics() {
        
        /* Local Variables */
        Job tempJob;
        
        System.out.println("Simulation Results");
        System.out.printf("Simulation with %d printers lasted %d seconds processed %d jobs\n", this.numberOfPrinters, this.currentTime, this.numberOfPrintJobs);
        System.out.printf("The average time in the wait queue for a job is %.2f seconds\n\n", (double) this.totalWaitTime / this.numberOfPrintJobs);
        
        System.out.println("Printer Statistics");
        System.out.printf("%8s\t%-9s\t%-9s%s\n", "", "Jobs", "Time", "Time");
        System.out.printf("%8s\t%-9s\t%-9s%s\n", "Name", "Processed", "In Use", "Idle");
        
        for (Printer p : printer) {
            
            System.out.printf("%8s\t%-9d\t%-9d%d\n", p.getPrinterName(), p.getTotalJobsProcessed(), p.getTotalInUseTime(), p.getTotalIdleTime(this.currentTime));
            
        }
        
        System.out.print("\n\n\n");
        
        System.out.println("Job Statistics");
        
        System.out.printf("%-12s\t%-9s\t%-10s\t%s\n", "Job No.", "Priority", "Wait Time", "Length of Job");
        
        while (!this.finishedQueue.isEmpty()) {
            
            
            tempJob = this.finishedQueue.poll();
            System.out.printf("%2d          \t %-8d\t %4d\t\t       %-3d\n", tempJob.getID(), tempJob.getPriority(), tempJob.getWaitTime(), tempJob.getTimeForJob());
            
        }
        
    }

}
