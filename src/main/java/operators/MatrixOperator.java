package operators;

import java.util.stream.Collectors;

import fundament.Matrix;
import fundament.Row;

public class MatrixOperator {
    private static void isValidMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix2.width() != matrix1.size()) {
            throw new IllegalArgumentException("Du kan ikke multiplisere en matrise med " + matrix2.width()
                    + " kolonner med en matrise med " + matrix1.size() + " rader!");
        }
    }

    public static void multiply(Matrix matrix1, Matrix matrix2) {
        isValidMultiplication(matrix1, matrix2);
        Matrix tempMatrix = matrix1.copy();
        matrix1.clear();
        for (int i = 0; i < matrix2.size(); i++) {
            Row row = new Row(); // Endre til row
            for (int j = 0; j < tempMatrix.width(); j++) {
                double temp = 0;
                for (int p = 0; p < matrix2.width(); p++) {
                    temp += matrix2.getNumberAt(i, p) * tempMatrix.getNumberAt(p, j);
                }
                row.add(temp);
            }
            if (row.isEmpty()) {
                throw new IllegalArgumentException();
            }
            matrix1.add(row);
        }
        if (matrix1.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void transpose(Matrix matrix) {
        Matrix tempMatrix = matrix.copy();
        matrix.clear();
        for (int i = 0; i < tempMatrix.width(); i++) {
            Row temp = new Row();
            for (int j = 0; j < tempMatrix.size(); j++) {
                temp.add(tempMatrix.getNumberAt(j, i));
            }
            matrix.add(temp);
        }
    }


    public static void clean(Matrix matrix) {
        matrix.forEach(row -> {
            Row temp = (Row) row.clone();
            row.clear();
            temp.stream()
                    .map(d -> Math.round(d * 100) / 100.0)
                    .collect(Collectors
                            .toCollection(Row::new))
                    .forEach(d -> row.add(d));
        });
    }

    private MatrixOperator() {
    };
}