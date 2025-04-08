package gausseliminasjon;

import java.util.ArrayList;

import fundament.RealMatrix;
import operators.PivotComperator;
import operators.RealMatrixOperator;
import operators.RealToolMatrix;

public class RadOperasjoner {

    public static void radbytte(ArrayList<RealMatrix> radOperasjoner, RealMatrix matrix, int rad1, int rad2) {
        RealMatrix radBytteMatrix = RealToolMatrix.radBytte(matrix, rad1, rad2);
        RealMatrixOperator.multiply(matrix, radBytteMatrix);
        radOperasjoner.add(radBytteMatrix);
    }

    public static void scaleRow(ArrayList<RealMatrix> radOperasjoner, RealMatrix matrix, int radNummer, double scalar) {
        RealMatrix scaleMatrix = RealToolMatrix.scale(matrix, radNummer, scalar);
        RealMatrixOperator.multiply(matrix, scaleMatrix);
        radOperasjoner.add(scaleMatrix);
    }

    public static void rowReduction(ArrayList<RealMatrix> radOperasjoner, RealMatrix matrix, int radFra, int radTil,
            double scalar) {
        RealMatrix reductionMatrix = RealToolMatrix.reduction(matrix, radFra, radTil, scalar);
        RealMatrixOperator.multiply(matrix, reductionMatrix);
        radOperasjoner.add(reductionMatrix);
    }

    public static void scaleByPivot(ArrayList<RealMatrix> radOperasjoner, RealMatrix matrix) {
        RealMatrix scaleByPivotMatrix = RealToolMatrix.scaleByPivot(matrix);
        RealMatrixOperator.multiply(matrix, scaleByPivotMatrix);
        radOperasjoner.add(scaleByPivotMatrix);
    }

    public static void eliminateUp(ArrayList<RealMatrix> radOperasjoner, RealMatrix matrix) {
        RealMatrix eliminateUpMatrix = RealToolMatrix.eliminateUp(matrix);
        RealMatrixOperator.multiply(matrix, eliminateUpMatrix);
        radOperasjoner.add(eliminateUpMatrix);
    }

    public static void sortByPivot(ArrayList<RealMatrix> radOperasjoner, RealMatrix matrix) {
        for (int i = 1; i < matrix.size(); i++) {
            // if (matrix.get(i).getPivotIndex().getAsInt() < matrix.get(i - 1).getPivotIndex().getAsInt()) {
            //     RealMatrix radBytteMatrix = RealToolMatrix.radBytte(matrix, i, i - 1);
            //     RealMatrixOperator.multiply(matrix, radBytteMatrix);
            //     radOperasjoner.add(radBytteMatrix);
            // }
            if (new PivotComperator<Double>().compare(matrix.get(i), matrix.get(i - 1)) < 0) {
                RealMatrix radBytteMatrix = RealToolMatrix.radBytte(matrix, i, i - 1);
                RealMatrixOperator.multiply(matrix, radBytteMatrix);
                radOperasjoner.add(radBytteMatrix);
            }
        }
    }

    private RadOperasjoner() {
    };
}