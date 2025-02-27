package gausseliminasjon;
import java.util.ArrayList;

import fundament.Matrix;
import operators.MatrixOperator;
import operators.ToolMatrix;

public class RadOperasjoner {
    private MatrixOperator matrixOperator = new MatrixOperator();
    private ToolMatrix toolMatrix = new ToolMatrix();

    public void radbytte(ArrayList<Matrix> radOperasjoner, Matrix matrix, int rad1, int rad2) {
        // Matrix radBytteMatrix = matrix.radBytteMatrix(rad1, rad2);
        Matrix radBytteMatrix = toolMatrix.radBytte(matrix, rad1, rad2);
        matrixOperator.multiply(matrix, radBytteMatrix);
        // matrix.matrixMultiplication(radBytteMatrix);
        // inverseMatrix.matrixMultiplication(radBytteMatrix);
        radOperasjoner.add(radBytteMatrix);
    }

    public void scaleRow(ArrayList<Matrix> radOperasjoner, Matrix matrix, int radNummer, double scalar) {
        // Matrix scalarMatrix = matrix.scaleMatrix(radNummer, scalar);
        Matrix scaleMatrix = toolMatrix.scale(matrix, radNummer, scalar);
        matrixOperator.multiply(matrix, scaleMatrix);
        // matrix.matrixMultiplication(scalarMatrix);
        // inverseMatrix.matrixMultiplication(scalarMatrix);
        radOperasjoner.add(scaleMatrix);
    }

    public void rowReduction(ArrayList<Matrix> radOperasjoner, Matrix matrix, int radFra, int radTil, double scalar) {
        // Matrix reductionMatrix = matrix.reductionMatrix(radFra, radTil, scalar);
        Matrix reductionMatrix = toolMatrix.reduction(matrix, radFra, radTil, scalar);
        matrixOperator.multiply(matrix, reductionMatrix);
        // matrix.matrixMultiplication(reductionMatrix);
        // inverseMatrix.matrixMultiplication(reductionMatrix);
        radOperasjoner.add(reductionMatrix);
    }

    public void scaleByPivot(ArrayList<Matrix> radOperasjoner, Matrix matrix) {
        // Matrix scaleByPivotMatrix = matrix.scaleByPivotMatrix();
        Matrix scaleByPivotMatrix = toolMatrix.scaleByPivot(matrix);
        matrixOperator.multiply(matrix, scaleByPivotMatrix);
        // matrix.matrixMultiplication(scaleByPivotMatrix);
        // inverseMatrix.matrixMultiplication(scaleByPivotMatrix);
        radOperasjoner.add(scaleByPivotMatrix);
    }

    public void eliminateUp(ArrayList<Matrix> radOperasjoner, Matrix matrix) {
        Matrix eliminateUpMatrix = toolMatrix.eliminateUp(matrix);
        matrixOperator.multiply(matrix, eliminateUpMatrix);
        radOperasjoner.add(eliminateUpMatrix);
    }

    public void sortByPivot(ArrayList<Matrix> radOperasjoner, Matrix matrix) {                 //RadOperasjoner
        for (int i = 1; i < matrix.size(); i++) {
            if (matrix.get(i).getPivotIndex() < matrix.get(i - 1).getPivotIndex()) {
                Matrix radBytteMatrix = toolMatrix.radBytte(matrix, i, i - 1);
                matrixOperator.multiply(matrix, radBytteMatrix);
                radOperasjoner.add(radBytteMatrix);
            }
        }
    }

    public static void main(String[] args) {



        // Matrix M1 = new Matrix(m1);
        // Matrix M2 = new Matrix(m2);
        // System.out.println(M2);
        // Gausser gausser = new Gausser(M1);
        // gausser.gaussEliminasjon();
        // System.out.println(gausser.getRowOperations());

    
    }
}