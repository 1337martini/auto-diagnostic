package com.softway.autodiagnostic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AutoDiagnosticServiceTest {

    @Test
    void diagnoseShouldReturnsCardilogie() {
        // those values are multiples of 3 but not multiples of 5
        int[] values = {3, 6, 9, 12, 18, 21, 33, 36, 39, 42};
        String expected = "Cardiologie";
        for (int value : values) {
            String actual = AutoDiagnosticService.diagnose(value);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void diagnoseShouldReturnsTraumatologie() {
        // those values are multiples of 5 but not multiples of 3
        int[] values = {5, 10, 20, 25, 35, 40, 55, 65, 70, 80};
        String expected = "Traumatologie";
        for (int value : values) {
            String actual = AutoDiagnosticService.diagnose(value);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void diagnoseShouldReturnsCardiologieAndTraumatologie() {
        // those values are multiples of both 3 and 5
        int[] values = {15, 30, 45, 60, 75, 90, 105, 120, 135, 150};
        String expected = "Cardiologie, Traumatologie";
        for (int value : values) {
            String actual = AutoDiagnosticService.diagnose(value);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void diagnoseShouldReturnsEmptyString() {
        // those values are not multiples of 3 or 5
        int[] values = {1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19};
        String expected = "";
        for (int value : values) {
            String actual = AutoDiagnosticService.diagnose(value);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void diagnoseWithNegativeValuesShouldReturnsEmptyString() {
        int[] values = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        String expected = "";
        for (int value : values) {
            String actual = AutoDiagnosticService.diagnose(value);
            assertEquals(expected, actual, "Failed for value: " + value);
        }
    }

    @Test
    void diagnoseWithZeroShouldReturnsEmptyString() {
        int value = 0;
        String expected = "";
        String actual = AutoDiagnosticService.diagnose(value);
        assertEquals(expected, actual);
    }

}
