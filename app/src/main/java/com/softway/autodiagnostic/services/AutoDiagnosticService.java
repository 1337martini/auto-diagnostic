package com.softway.autodiagnostic.services;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for diagnosing health indices and determining the appropriate medical
 * units.
 */
public class AutoDiagnosticService {

    /**
     * Diagnoses the health index and returns the corresponding medical units to
     * be redirected to.
     *
     * @param healthIndex the health index to diagnose
     * @return a string containing the medical units or an empty string if no
     * units match
     */
    public static String diagnose(int healthIndex) {
        // any value less than or equal to 0 is invalid
        if (healthIndex <= 0) {
            return "";
        }

        List<String> medicalUnits = new ArrayList<>();
        // health index divisible by 3
        if (healthIndex % 3 == 0) {
            medicalUnits.add("Cardiologie");
        }
        // health index divisible by 5
        if (healthIndex % 5 == 0) {
            medicalUnits.add("Traumatologie");
        }
        // we should be able to add more medical units in the future...

        return String.join(", ", medicalUnits);
    }
}
