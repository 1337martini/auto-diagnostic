package com.softway.autodiagnostic.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AutoDiagnosticCliTest {

    @Test
    void mainShouldReturnCardiologie() {
        // those values are multiples of 3 but not multiples of 5
        int[] values = {3, 6, 9, 12, 18, 21, 33, 36, 39, 42};
        String expected = "Cardiologie";
        for (int value : values) {
            String[] args = {String.valueOf(value)};
            String actual = getOutput(args);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void mainShouldReturnTraumatologie() {
        // those values are multiples of 5 but not multiples of 3
        int[] values = {5, 10, 20, 25, 35, 40, 55, 65, 70, 80};
        String expected = "Traumatologie";
        for (int value : values) {
            String[] args = {String.valueOf(value)};
            String actual = getOutput(args);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void mainShouldReturnCardiologieAndTraumatologie() {
        // those values are multiples of 3 but not multiples of 5
        int[] values = {15, 30, 45, 60, 75, 90, 105, 120, 135, 150};
        String expected = "Cardiologie, Traumatologie";
        for (int value : values) {
            String[] args = {String.valueOf(value)};
            String actual = getOutput(args);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void mainShouldReturnNothing() {
        // those values are not multiples of 3 or 5
        int[] values = {1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19};
        String expected = "";
        for (int value : values) {
            String[] args = {String.valueOf(value)};
            String actual = getOutput(args);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void mainWithWrongArgumentTypeShouldReturnsError() {
        String[] values = {"abc", "12.34", "100a", "%", "3.14", "-0.3", "x", ";", ")", "-"};
        // those values are not valid integers
        // the expected output is an error message
        String expected = "L'argument doit être un entier.";
        for (String value : values) {
            String[] args = {value};
            String actual = getOutput(args);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void mainWithNoArgumentShouldReturnUsage() {
        String[] args = {};
        String expected = "Usage: java AutoDiagnosticCli <healthIndex>";
        String actual = getOutput(args);
        assertEquals(expected, actual);
    }

    /**
     * This method captures the output of the main method of AutoDiagnosticCli.
     *
     * @param args the arguments to pass to the main method
     * @return the output as a String
     */
    private static String getOutput(String[] args) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AutoDiagnosticCli.main(args);
        System.setOut(System.out);
        return outContent.toString().trim();
    }
}
