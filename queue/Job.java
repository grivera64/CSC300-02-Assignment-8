//package assignment8.queue;

/* 
 * 
 * Name: Job.java
 * Purpose: Represents A Printer Job
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

public class Job implements Comparable<Job> {
    
    private static int idCounter = 1;
    
    private int id;
    private int arrivalTime;
    private int timeForJob;
    private int priority;
    private int startTime;      // for job
    private int waitTime;       // in queue
    private int endTime;        // for job
    
    public Job() {}
    
    public Job(int arrivalTime, int timeForTheJob, int priority) {
        
        this.id = Job.idCounter++;
        
        this.setArrivalTime(arrivalTime);
        this.setTimeForJob(timeForTheJob);
        this.setPriority(priority);
        
    }
    
    public int getID() {
        
        return this.id;
        
    }
    
    public void setArrivalTime(int arrivalTime) {
        
        this.arrivalTime = arrivalTime;
        
    }
    
    public int getArrivalTime() {
        
        return this.arrivalTime;
        
    }
    
    public void setTimeForJob(int timeForTheJob) {
        
        this.timeForJob = timeForTheJob;
        
    }
    
    public int getTimeForJob() {
        
        return this.timeForJob;
        
    }
    
    public void setPriority(int priority) {
        
        this.priority = priority;
        
    }
    
    public int getPriority() {
        
        return this.priority;
        
    }
    
    public void setStartTime(int startTime) {
        
        this.startTime = startTime;
        this.waitTime = startTime - this.arrivalTime;
        
    }
    
    public int getStartTime() {
        
        return this.startTime;
        
    }
    
    public void setEndTime(int endTime) {
        
        this.endTime = endTime;
        
    }
    
    public int getEndTime() {
        
        return this.endTime;
        
    }

    public int getWaitTime() {
        
        return this.waitTime;
        
    }

    //@Override
    public int compareTo(Job o) {
        
        return this.priority - o.priority;
        
    }
    
}
