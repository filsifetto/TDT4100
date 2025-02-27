package operators;

import fundament.Matrix;
import fundament.Row;

public class ToolMatrix {
    private MatrixOperator operator = new MatrixOperator();

    private void isValidRow(Matrix matrix, int rowNumber) {
        if (rowNumber < 0 || rowNumber >= matrix.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Matrix identity(Matrix matrix) { // MatrixOperator
        Matrix identityMatrix = new Matrix();
        for (int i = 0; i < matrix.size(); i++) {
            Row row = new Row();
            for (int j = 0; j < matrix.size(); j++) {
                if (i == j) {
                    row.add(1.0);
                } else {
                    row.add(0.0);
                }
            }
            identityMatrix.add(row);
        }
        return identityMatrix;
    }

    public Matrix radBytte(Matrix matrix, int rad1, int rad2) { // MatrixOperator
        isValidRow(matrix, rad1);
        isValidRow(matrix, rad2);
        Matrix iD = identity(matrix);
        Row temp = iD.get(rad1);
        iD.setRow(rad1, iD.get(rad2));
        iD.setRow(rad2, temp);
        return iD;
    }

    public Matrix scale(Matrix matrix, int row, double scalar) { // MatrixOperator
        isValidRow(matrix, row);
        Matrix iD = identity(matrix);
        for (int i = 0; i < iD.width(); i++) {
            iD.setNumber(row, i, iD.getNumberAt(row, i) * scalar);
        }
        return iD;
    }

    public Matrix reduction(Matrix matrix, int rowFrom, int rowTo, double scalar) { // MatrixOperator
        isValidRow(matrix, rowFrom);
        isValidRow(matrix, rowTo);
        Matrix iD = identity(matrix);
        iD.setNumber(rowTo, rowFrom, -scalar);
        return iD;
    }

    public Matrix scaleByPivot(Matrix matrix) { // MatrixOperator
        Matrix iD = identity(matrix);
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.width(); j++) {
                if (matrix.getNumberAt(i, j) != 0) {
                    iD.setNumber(i, i, 1 / matrix.getNumberAt(i, j));
                    break;
                }
            }
        }
        return iD;
    }

    public Matrix eliminateUp(Matrix matrix) { // Gauss-Klasse istedet
        Matrix iD = identity(matrix);
        for (int i = matrix.size() - 1; i > 0; i--) {
            int pivotIndex = matrix.get(i).getPivotIndex();
            if (pivotIndex == 100000) {
                continue;
            }
            for (int j = 1; j <= i; j++) {
                double scalar = matrix.getNumberAt(i - j, pivotIndex);
                Matrix temp = reduction(matrix, i, i - j, scalar);
                operator.multiply(iD, temp);
            }
        }
        return iD;
    }
}
