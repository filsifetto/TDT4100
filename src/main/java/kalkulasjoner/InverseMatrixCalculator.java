package kalkulasjoner;

import fundament.Matrix;
import gausseliminasjon.Gausser;
import operators.MatrixOperator;
import operators.ToolMatrix;

public class InverseMatrixCalculator {

    public static Matrix getInverse(Matrix matrix) {
        Matrix inverse = ToolMatrix.identity(matrix);
        Gausser gausser = new Gausser(matrix);
        gausser.gaussEliminasjon();
        for (Matrix m : gausser.getRowOperations()) {
            MatrixOperator.multiply(inverse, m);
        }
        return inverse;
    }
}