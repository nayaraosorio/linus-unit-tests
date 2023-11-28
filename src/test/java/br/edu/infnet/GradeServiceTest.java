package br.edu.infnet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(GradeServiceTest.class);

    @DisplayName("Testar calculateAverage() com entrada válida")
    @Test
    void testCalculateAverage() {
        List<Double> grades = Arrays.asList(7.5, 8.0, 6.5, 9.0);
        double result = GradeService.calculateAverage(grades);

        // Log de informação
        logger.info("Média calculada com sucesso: {}", result);

        assertEquals(7.75, result, 0.01);
    }

    @DisplayName("Testar calculateAverage() com lista vazia")
    @Test
    void testCalculateAverageEmptyList() {
        List<Double> grades = Arrays.asList();

        // Log de depuração
        logger.debug("Testando calculateAverage com uma lista vazia");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GradeService.calculateAverage(grades));

        String expectedMessage = "A lista de notas não pode ser nula ou vazia";
        String actualMessage = exception.getMessage();

        // Log de erro
        logger.error("Mensagem de exceção: {}", actualMessage);

        assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()));
    }

    @DisplayName("Testar isStudentPassed() com nota de aprovação")
    @Test
    void testIsStudentPassed() {
        assertTrue(GradeService.isStudentPassed(8.0, 7.0));

        // Log de informação
        logger.info("Teste isStudentPassed com nota de aprovação concluído com sucesso");
    }

    @DisplayName("Testar isStudentPassed() com nota de reprovação")
    @Test
    void testIsStudentFailed() {
        assertFalse(GradeService.isStudentPassed(5.5, 6.0));

        // Log de informação
        logger.info("Teste isStudentFailed com nota de reprovação concluído com sucesso");
    }

    @DisplayName("Testar isStudentPassed() com entrada negativa")
    @Test
    void testIsStudentPassedNegativeInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GradeService.isStudentPassed(-5.0, -6.0));

        String expectedMessage = "As notas e a nota de aprovação não podem ser negativas";
        String actualMessage = exception.getMessage();

        // Log de erro
        logger.error("Mensagem de exceção: {}", actualMessage);

        assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()));
    }
}
