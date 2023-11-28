package br.edu.infnet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceTest {

    @DisplayName("Test calculateAverage() with valid input")
    @Test
    void testCalculateAverage() {
        List<Double> grades = Arrays.asList(7.5, 8.0, 6.5, 9.0);
        double result = GradeService.calculateAverage(grades);
        assertEquals(7.75, result, 0.01); // Delta (tolerance) is set to 0.01 for double comparison
    }

    @DisplayName("Test calculateAverage() with empty list")
    @Test
    void testCalculateAverageEmptyList() {
        List<Double> grades = Arrays.asList();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GradeService.calculateAverage(grades));
        assertEquals("A lista de notas não pode ser nula ou vazia", exception.getMessage());
    }

    @DisplayName("Test isStudentPassed() with passing grade")
    @Test
    void testIsStudentPassed() {
        assertTrue(GradeService.isStudentPassed(8.0, 7.0));
    }

    @DisplayName("Test isStudentPassed() with failing grade")
    @Test
    void testIsStudentFailed() {
        assertFalse(GradeService.isStudentPassed(5.5, 6.0));
    }

    @DisplayName("Test isStudentPassed() with negative input")
    @Test
    void testIsStudentPassedNegativeInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GradeService.isStudentPassed(-5.0, -6.0));
        assertEquals("As notas e a nota de aprovação não podem ser negativas", exception.getMessage());
    }
}
