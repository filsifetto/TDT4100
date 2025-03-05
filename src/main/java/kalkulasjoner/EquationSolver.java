package kalkulasjoner;

import java.util.ArrayList;

import fundament.Matrix;
import fundament.Row;
import fundament.Vektor;
import operators.MatrixOperator;
import validators.RedusertTrappeformPredicate;

public class EquationSolver {

    private static void isValidEquation(Matrix matrix, Vektor vektor) {
        if (matrix.size() != vektor.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static ArrayList<Integer> getZeroRowsIndex(Matrix matrix) { // Gaussklasse / Equationsolver?
        ArrayList<Integer> zero = new ArrayList<>(); // Gir ut hvilke rader som er nullrader
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).isZero()) {
                zero.add(i);
            }
        }
        return zero;
    }

    private static int dimColSpace(Matrix matrix) {
        if (!RedusertTrappeformPredicate.test(matrix)) {
            throw new IllegalArgumentException();
        }
        return matrix.size() - getZeroRowsIndex(matrix).size();
    }

    public static int dimSolution(Matrix matrix, Vektor vektor) {
        Matrix inverse = InverseMatrixCalculator.getInverse(matrix);
        MatrixOperator.multiply(vektor, inverse);
        MatrixOperator.multiply(matrix, inverse);
        MatrixOperator.clean(matrix);
        MatrixOperator.clean(vektor);
        for (int i = 0; i < vektor.size(); i++) {
            if (matrix.get(i).isZero() && !vektor.get(i).isZero()) {
                return -1;
            }
        }
        return matrix.width() - dimColSpace(matrix);
    }

    public static void printEquation(Matrix matrix, Vektor vektor) {
        for (int i = 0; i < matrix.size(); i++) {
            if (i == matrix.size() / 2) {
                System.out.println(matrix.get(i) + "[x" + (i + 1) + "]  =  " + vektor.get(i));
            } else {
                System.out.println(matrix.get(i) + "[x" + (i + 1) + "]     " + vektor.get(i));
            }
        }
        System.out.println("\n");
    }

    public static void printOneSolution(Vektor vektor) {
        for (int i = 0; i < vektor.size(); i++) {
            String streng = "x" + (i + 1) + " = " + vektor.getNumberAt(i);
            System.out.println(streng);
        }
    }

    public static void printNoSolutions() {
        System.out.println("Likningen har ingen løsninger");
    }

    private static ArrayList<Vektor> freeVectors(Matrix redusert, Vektor vektor, int frieVariabler) {
        ArrayList<Vektor> frieVektorer = new ArrayList<>();
        for (int i = dimColSpace(redusert); i < dimColSpace(redusert) + frieVariabler; i++) {
            Vektor fri = new Vektor();
            for (int j = 0; j < redusert.size(); j++) {
                if (j == i) {
                    Row vektorrad = new Row();
                    vektorrad.add(1.0);
                    fri.add(vektorrad);
                } else {
                    Row vektorrad = new Row();
                    vektorrad.add(-redusert.getNumberAt(j, i));
                    fri.add(vektorrad);
                }
            }
            frieVektorer.add(fri);
        }
        return frieVektorer;
    }

    public static void printSolutionWithFreeVariables(Matrix redusert, Vektor vektor, int frieVariabler) {
        String alfa = "stuvw";
        ArrayList<Vektor> vektorer = freeVectors(redusert, vektor, frieVariabler);
        for (int i = 0; i < redusert.width() - 1; i++) {
            if (i == redusert.size() / 2) {
                String streng = "x = [";
                for (int p = 0; p < vektorer.size() - 1; p++) {
                    streng += vektorer.get(p).get(i) + "] ";
                    streng += " + " + String.valueOf(alfa.charAt(p)) + " * [" + vektorer.get(p).getNumberAt(i) + "]";
                }
                System.out.println(streng);
            } else {
                String streng = "    [";
                for (int p = 0; p < vektorer.size(); p++) {
                    streng += vektorer.get(p).get(i) + "] ";
                    streng += " + " + String.valueOf(alfa.charAt(p)) + " * [" + vektorer.get(p).getNumberAt(i) + "]";
                }
                System.out.println(streng);
            }
        }
        System.out.println("\n");
    }

    public static void solve(Matrix matrix, Vektor vektor) {
        isValidEquation(matrix, vektor);
        printEquation(matrix, vektor);
        int numberOfSolutions = dimSolution(matrix, vektor);
        Matrix inverse = InverseMatrixCalculator.getInverse(matrix);
        MatrixOperator.multiply(vektor, inverse);
        if (numberOfSolutions == -1) {
            printNoSolutions();
        }
        if (numberOfSolutions == 0) {
            printOneSolution(vektor);
        }
    }

    private EquationSolver() {
    };
}