package com.softway.autodiagnostic.cli;

import com.softway.autodiagnostic.services.AutoDiagnosticService;

/**
 * Command Line Interface (CLI) application for auto-diagnosing health indices.
 * This application reads a health index from the command line and outputs the
 * corresponding medical units.
 */
public class AutoDiagnosticCli {

    /**
     * Main method to run the CLI application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java AutoDiagnosticCli <healthIndex>");
            return;
        }

        try {
            int healthIndex = Integer.parseInt(args[0]);
            String result = AutoDiagnosticService.diagnose(healthIndex);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("L'argument doit être un entier.");
        }
    }
}
