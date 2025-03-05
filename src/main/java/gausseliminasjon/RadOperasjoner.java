package gausseliminasjon;

import java.util.ArrayList;

import fundament.Matrix;
import operators.MatrixOperator;
import operators.ToolMatrix;

public class RadOperasjoner {

    public static void radbytte(ArrayList<Matrix> radOperasjoner, Matrix matrix, int rad1, int rad2) {
        Matrix radBytteMatrix = ToolMatrix.radBytte(matrix, rad1, rad2);
        MatrixOperator.multiply(matrix, radBytteMatrix);
        radOperasjoner.add(radBytteMatrix);
    }

    public static void scaleRow(ArrayList<Matrix> radOperasjoner, Matrix matrix, int radNummer, double scalar) {
        Matrix scaleMatrix = ToolMatrix.scale(matrix, radNummer, scalar);
        MatrixOperator.multiply(matrix, scaleMatrix);
        radOperasjoner.add(scaleMatrix);
    }

    public static void rowReduction(ArrayList<Matrix> radOperasjoner, Matrix matrix, int radFra, int radTil,
            double scalar) {
        Matrix reductionMatrix = ToolMatrix.reduction(matrix, radFra, radTil, scalar);
        MatrixOperator.multiply(matrix, reductionMatrix);
        radOperasjoner.add(reductionMatrix);
    }

    public static void scaleByPivot(ArrayList<Matrix> radOperasjoner, Matrix matrix) {
        Matrix scaleByPivotMatrix = ToolMatrix.scaleByPivot(matrix);
        MatrixOperator.multiply(matrix, scaleByPivotMatrix);
        radOperasjoner.add(scaleByPivotMatrix);
    }

    public static void eliminateUp(ArrayList<Matrix> radOperasjoner, Matrix matrix) {
        Matrix eliminateUpMatrix = ToolMatrix.eliminateUp(matrix);
        MatrixOperator.multiply(matrix, eliminateUpMatrix);
        radOperasjoner.add(eliminateUpMatrix);
    }

    public static void sortByPivot(ArrayList<Matrix> radOperasjoner, Matrix matrix) {
        for (int i = 1; i < matrix.size(); i++) {
            if (matrix.get(i).getPivotIndex() < matrix.get(i - 1).getPivotIndex()) {
                Matrix radBytteMatrix = ToolMatrix.radBytte(matrix, i, i - 1);
                MatrixOperator.multiply(matrix, radBytteMatrix);
                radOperasjoner.add(radBytteMatrix);
            }
        }
    }

    private RadOperasjoner() {
    };
}