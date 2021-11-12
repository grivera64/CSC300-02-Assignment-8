//package assignment8.vaccination;

/* 
 * 
 * Name: ModelVaccinationSite.java
 * Purpose: Runs the Vaccination Site model
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class ModelVaccinationSite {
    
    public static void main(String[] args) throws IOException {
        
        /* Local variables */
        String siteName, outputFileName;
        int seed, numberOfNurses, totalNumberOfDosesAvailable, durationForArriving;
        Scanner keyboard = new Scanner(System.in);
        VaccinationSite vaccinationSite;
        
        /* Request VaccinationSite Details */
        System.out.println("Please enter the name of the Vaccination Site:");
        siteName = keyboard.nextLine();
        
        System.out.println("Please enter a seed value as an int:");
        seed = keyboard.nextInt();
        keyboard.nextLine(); // clear buffer
        
        System.out.println("Please enter the number of nurses as an int:");
        numberOfNurses = keyboard.nextInt();
        keyboard.nextLine(); // clear buffer
        
        System.out.println("Please enter the total number of vaccine doses as an int:");
        totalNumberOfDosesAvailable = keyboard.nextInt();
        keyboard.nextLine(); // clear buffer
        
        /* Open the Site and ask for open time */
        vaccinationSite = new VaccinationSite(siteName, seed, numberOfNurses, totalNumberOfDosesAvailable);
        vaccinationSite.openVaccinationSiteLine();
        
        System.out.println("Please enter the number of minutes to keep entrance open after the site opens:");
        durationForArriving = keyboard.nextInt();
        keyboard.nextLine(); // clear buffer
        
        /* Operate the Site and Print out the Details to requested File */
        vaccinationSite.operateVaccinationSite(durationForArriving);
        
        System.out.print("Please enter the name of the output file for Vaccine Site results: ");
        outputFileName = keyboard.nextLine();
        
        vaccinationSite.generateVaccinationSiteResults(outputFileName);
        
        keyboard.close();
        
    }

}
