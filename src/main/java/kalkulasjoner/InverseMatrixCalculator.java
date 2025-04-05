package kalkulasjoner;

import fundament.RealMatrix;
import gausseliminasjon.Gausser;
import operators.RealMatrixOperator;
import operators.RealToolMatrix;

public class InverseMatrixCalculator {

    public static RealMatrix getInverse(RealMatrix matrix) {
        RealMatrix inverse = RealToolMatrix.identity(matrix);
        Gausser gausser = new Gausser(matrix);
        gausser.gaussEliminasjon();
        for (RealMatrix m : gausser.getRowOperations()) {
            RealMatrixOperator.multiply(inverse, m);
        }
        RealMatrixOperator.clean(inverse);
        return inverse;
    }

    private InverseMatrixCalculator() {
    };
}