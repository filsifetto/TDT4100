package operators;

import java.util.stream.IntStream;

import fundament.Kompleks;
import fundament.RealMatrix;
import fundament.RealRow;
import fundament.Vektor;
import fundament.VektorRom;
import kalkulasjoner.InverseMatrixCalculator;

public class RealToolMatrix {

    private static void isValidRow(RealMatrix matrix, int rowNumber) {
        if (rowNumber < 0 || rowNumber >= matrix.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static RealMatrix identity(RealMatrix matrix) { // MatrixOperator
        RealMatrix identityMatrix = new RealMatrix();
        for (int i = 0; i < matrix.size(); i++) {
            RealRow row = new RealRow();
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

    public static RealMatrix radBytte(RealMatrix matrix, int rad1, int rad2) { // MatrixOperator
        isValidRow(matrix, rad1);
        isValidRow(matrix, rad2);
        RealMatrix iD = identity(matrix);
        RealRow temp = (RealRow) iD.get(rad1);
        iD.setRow(rad1, iD.get(rad2));
        iD.setRow(rad2, temp);
        return iD;
    }

    public static RealMatrix scale(RealMatrix matrix, int row, double scalar) { // MatrixOperator
        isValidRow(matrix, row);
        RealMatrix iD = identity(matrix);
        for (int i = 0; i < iD.width(); i++) {
            iD.setNumber(row, i, iD.getNumberAt(row, i) * scalar);
        }
        return iD;
    }

    public static RealMatrix reduction(RealMatrix matrix, int rowFrom, int rowTo, double scalar) { // MatrixOperator
        isValidRow(matrix, rowFrom);
        isValidRow(matrix, rowTo);
        RealMatrix iD = identity(matrix);
        iD.setNumber(rowTo, rowFrom, -scalar);
        return iD;
    }

    public static RealMatrix scaleByPivot(RealMatrix matrix) { // MatrixOperator
        RealMatrix iD = identity(matrix);
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

    public static RealMatrix eliminateUp(RealMatrix matrix) { // Gauss-Klasse istedet
        RealMatrix iD = identity(matrix);
        for (int i = matrix.size() - 1; i > 0; i--) {
            int pivotIndex = matrix.get(i).getPivotIndex().getAsInt();
            if (pivotIndex == 100000) {
                continue;
            }
            for (int j = 1; j <= i; j++) {
                double scalar = matrix.getNumberAt(i - j, pivotIndex);
                RealMatrix temp = reduction(matrix, i, i - j, scalar);
                RealMatrixOperator.multiply(iD, temp);
            }
        }
        return iD;
    }

    public static Vektor nullVektor(int dim) {
        Vektor nullVektor = new Vektor();
        IntStream.range(0, dim)
                .forEach(i -> {
                    RealRow row = new RealRow();
                    row.add(0.0);
                    nullVektor.add(row);
                });
        return nullVektor;
    }

    public static RealMatrix projection(VektorRom vektorRom) {
        if (!vektorRom.hasOrthogonalBasis()) {
            throw new IllegalArgumentException("Kan ikke finne projeksjonsmatrise uten ortogonal basis");
        }
        RealMatrix A = new RealMatrix(vektorRom);
        RealMatrix AT = A.copy();
        RealMatrixOperator.transpose(AT);
        RealMatrix ATA = A.copy();
        RealMatrixOperator.multiply(ATA, AT);
        RealMatrix ATAinvers = InverseMatrixCalculator.getInverse(ATA);
        RealMatrix P = AT.copy();
        RealMatrixOperator.multiply(P, ATAinvers);
        RealMatrixOperator.multiply(P, A);
        return P;
    }

    public static RealMatrix complex(Kompleks z) {
        RealRow r1 = new RealRow();
        r1.add(z.getReal());
        r1.add(-z.getImaginary());
        RealRow r2 = new RealRow();
        r2.add(z.getImaginary());
        r2.add(z.getReal());
        return new RealMatrix(r1, r2);
    }

    private RealToolMatrix() {
    };
}
