package br.edu.infnet;

import java.util.List;

public class GradeService {

    public static double calculateAverage(List<Double> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("A lista de notas não pode ser nula ou vazia");
        }

        for (Double grade : grades) {
            validateGrade(grade);
        }

        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public static boolean isStudentPassed(double average, double passingGrade) {
        if (average < 0 || passingGrade < 0) {
            throw new IllegalArgumentException("As notas e a nota de aprovação não podem ser negativas");
        }

        return average >= passingGrade;
    }

    private static void validateGrade(double grade) {
        if (grade < 0 || grade > 10) {
            throw new InvalidGradeException("A nota deve estar no intervalo de 0 a 10");
        }
    }
}
