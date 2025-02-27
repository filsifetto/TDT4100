package gausseliminasjon;
import java.util.ArrayList;

import fundament.Matrix;
import operators.MatrixOperator;
import operators.ToolMatrix;

public class RadOperasjoner {
    private MatrixOperator matrixOperator = new MatrixOperator();
    private ToolMatrix toolMatrix = new ToolMatrix();

    public void radbytte(ArrayList<Matrix> radOperasjoner, Matrix matrix, int rad1, int rad2) {
        Matrix radBytteMatrix = toolMatrix.radBytte(matrix, rad1, rad2);
        matrixOperator.multiply(matrix, radBytteMatrix);
        radOperasjoner.add(radBytteMatrix);
    }

    public void scaleRow(ArrayList<Matrix> radOperasjoner, Matrix matrix, int radNummer, double scalar) {
        Matrix scaleMatrix = toolMatrix.scale(matrix, radNummer, scalar);
        matrixOperator.multiply(matrix, scaleMatrix);
        radOperasjoner.add(scaleMatrix);
    }

    public void rowReduction(ArrayList<Matrix> radOperasjoner, Matrix matrix, int radFra, int radTil, double scalar) {
        Matrix reductionMatrix = toolMatrix.reduction(matrix, radFra, radTil, scalar);
        matrixOperator.multiply(matrix, reductionMatrix);
        radOperasjoner.add(reductionMatrix);
    }

    public void scaleByPivot(ArrayList<Matrix> radOperasjoner, Matrix matrix) {
        Matrix scaleByPivotMatrix = toolMatrix.scaleByPivot(matrix);
        matrixOperator.multiply(matrix, scaleByPivotMatrix);
        radOperasjoner.add(scaleByPivotMatrix);
    }

    public void eliminateUp(ArrayList<Matrix> radOperasjoner, Matrix matrix) {
        Matrix eliminateUpMatrix = toolMatrix.eliminateUp(matrix);
        matrixOperator.multiply(matrix, eliminateUpMatrix);
        radOperasjoner.add(eliminateUpMatrix);
    }

    public void sortByPivot(ArrayList<Matrix> radOperasjoner, Matrix matrix) {   
        for (int i = 1; i < matrix.size(); i++) {
            if (matrix.get(i).getPivotIndex() < matrix.get(i - 1).getPivotIndex()) {
                Matrix radBytteMatrix = toolMatrix.radBytte(matrix, i, i - 1);
                matrixOperator.multiply(matrix, radBytteMatrix);
                radOperasjoner.add(radBytteMatrix);
            }
        }
    }
}