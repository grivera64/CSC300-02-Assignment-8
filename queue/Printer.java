//package assignment8.queue;

/* 
 * 
 * Name: Printer.java
 * Purpose: Represents A Printer
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

public class Printer {
    
    private Job printJob;
    private String printerName;
    private int startIdleTime;
    private int startInUseTime;
    private int totalIdleTime;
    private int totalInUseTime;
    private int totalJobsProcessed;
    
    public Printer() {}
    
    public Printer(String printerName) {
        
        this.setPrinterName(printerName);
        
    }
    
    public void setPrinterName(String printerName) {
        
        this.printerName = printerName;
        
    }
    
    public String getPrinterName() {
        
        return this.printerName;
        
    }
    
    public void setJob(Job printJob) {
        
        this.printJob = printJob;
        
    }
    
    public Job getJob() {
        
        return this.printJob;
        
    }
    
    public void setStartInUseTime(int startInUseTime) {
        
        this.startInUseTime = startInUseTime;
        this.totalJobsProcessed++;
        this.totalIdleTime += startInUseTime - this.startIdleTime;
        
    }
    
    public void setStartIdleTime(int startIdleTime) {
        
        this.startIdleTime = startIdleTime;
        this.totalInUseTime += startIdleTime - this.startInUseTime;
        
    }
    
    public int getTotalIdleTime(int currentTime) {
        
        return currentTime - this.startIdleTime + this.totalIdleTime;
        
    }
    
    public int getTotalInUseTime() {
        
        return this.totalInUseTime;
        
    }
    
    public int getTotalJobsProcessed() {
        
        return this.totalJobsProcessed;
        
    }

}
