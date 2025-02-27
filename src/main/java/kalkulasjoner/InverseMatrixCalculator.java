package kalkulasjoner;

import fundament.Clean;
import fundament.Matrix;
import gausseliminasjon.Gausser;
import operators.MatrixOperator;
import operators.ToolMatrix;

public class InverseMatrixCalculator {

    public Matrix getInverse(Matrix matrix) {
        Matrix inverse = new ToolMatrix().identity(matrix);
        Gausser gausser = new Gausser(matrix);
        gausser.gaussEliminasjon();
        for (Matrix m : gausser.getRowOperations()) {
            new MatrixOperator().multiply(inverse, m);
        }
        return inverse;
    }

    public static void main(String[] args) {
        Matrix inverse = new InverseMatrixCalculator().getInverse(new Matrix(3, 3));
        new Clean().clean(inverse);
        System.out.println(inverse);
    }
}
