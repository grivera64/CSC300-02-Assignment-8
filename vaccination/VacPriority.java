//package assignment8.vaccination;

/* 
 * 
 * Name: VacPriority.java
 * Purpose: Sorts Patients by Age Group
 *          (or Arrival Time if same Age Group)
 * Author: grivera64
 * Date: 11/13/2021
 * 
 */

import java.util.Comparator;

public class VacPriority implements Comparator<Patient> {
    
    public int compare(Patient patient1, Patient patient2) {
        
        /* Local Variables */
        int patientPriority1, patientPriority2;
        
        /* Determine priority */
        patientPriority1 = getPriority(patient1);
        patientPriority2 = getPriority(patient2);
        
        /* Compare */
        if (patientPriority1 == patientPriority2) {
            
            /* based on time */
            return patient1.getArrivalTime() - patient2.getArrivalTime();
            
        } else if (patientPriority1 < patientPriority2) {
            
            return -1;
            
        } else {
            
            return 1;
            
        }
        
    }
    
    private int getPriority(Patient className) {
        
        String classString = className.getClass().toString();                       // Originally "class assignment8.vaccination.Patient"
        
        if (classString.indexOf(".") > 0) {
            
            classString = classString.substring(classString.lastIndexOf(".") + 1);
            
        } else {
            
            classString = classString.replace("class ", "");
            
        }
        
        return switch (classString) {                                               // (!) Preview Feature for JDK-13 and below, use
                                                                                    // --enable-preview --release 13 flags to run
        case "Senior" -> 1;
        case "Adult" -> 2;
        case "OlderTeen" -> 3;
        default -> throw new IllegalArgumentException("Invalid Patient Provided");
        
        };
        
        /* If the above doesn't work, comment it out and uncomment the code below */
//        switch (classString) {
//        
//        case "Senior":
//            
//            return 1;
//            
//        case "Adult":
//            
//            return 2;
//            
//        case "OlderTeen":
//            
//            return 3;
//            
//        default:
//            
//            throw new IllegalArgumentException("Invalid Patient Provided");
//        
//        }
        
    }

}