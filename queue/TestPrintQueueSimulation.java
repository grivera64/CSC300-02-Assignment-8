//package assignment8.queue;

/* 
 * 
 * Name: TestPrintQueueSimulation.java
 * Purpose: Tests the Printer Simulation
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.util.Scanner;

public class TestPrintQueueSimulation {
    
    public static void main(String[] args) {
        
        /* Local Variables */
        Scanner keyboard = new Scanner(System.in);
        int printers, printerJobs;
        long seed;
        
        System.out.printf("Please enter the number of %s for the simulation: ", "printers");
        printers = keyboard.nextInt();
        System.out.printf("Please enter the number of %s for the simulation: ", "printer jobs");
        printerJobs = keyboard.nextInt();
        System.out.print("Please enter a random number seed for the simulation: ");
        seed = keyboard.nextLong();
        
        System.out.print("\n\n");
        
        (new PrintQueueSimulation(printerJobs, printers, seed)).simulate();
        
        keyboard.close();
        
    }

}
