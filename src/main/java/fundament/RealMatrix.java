package fundament;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import operators.RealMatrixOperator;
import operators.RealToolMatrix;
import operators.PivotComperator;

public class RealMatrix extends AbstractMatrix<Double> {

    /**
     * Copies this matrix
     * 
     * @return copied matrix
     */

    @Override
    public RealMatrix copy() {
        RealMatrix newMatrix = new RealMatrix();
        newMatrix.addAll(this);
        return newMatrix;
    }

    @Override
    public boolean sortedByZeroRows() {
        RealMatrix matrix = copy();
        matrix.sort(new PivotComperator<>());
        return matrix.equals(this);
    }

    @Override
    public String toString() {
        String ut = "";
        for (Row<Double> rad : this) {
            ut += rad + "\n";
        }
        return ut;
    }

    @Override
    public Matrix<Double> identity() {
        return RealToolMatrix.identity(this);
    }

    // public void multiply(Matrix<Double> matrix) {
    // isValidMultiplication(matrix);
    // RealMatrix tempMatrix = copy();

    // IntStream.range(0, matrix.size()).forEach(r -> {
    // IntStream.range(0, tempMatrix.width())
    // .forEach(i -> {
    // Double d = IntStream.range(0, tempMatrix.size())
    // .mapToDouble(p -> matrix.getNumberAt(r, p) * tempMatrix.getNumberAt(p, i))
    // .sum();
    // setNumber(r, i, d);
    // });
    // });
    // // matrix1.setNumber(r, r, null);IntStream.range(0, tempMatrix.size())
    // // .mapToDouble(p -> matrix2.getNumberAt(r, p)*tempMatrix.getNumberAt(p,
    // // i).hashCode().sum());
    // }

    public void multiply(Matrix<Double> matrix) {
        isValidMultiplication(matrix);
        RealMatrix tempMatrix = copy();
        clear();
        for (int i = 0; i < matrix.size(); i++) {
            RealRow row = new RealRow(); // Endre til row
            for (int j = 0; j < tempMatrix.width(); j++) {
                double temp = 0;
                for (int p = 0; p < matrix.width(); p++) {
                    temp += matrix.getNumberAt(i, p) * tempMatrix.getNumberAt(p, j);
                }
                row.add(temp);
            }
            if (row.isEmpty()) {
                throw new IllegalArgumentException();
            }
            add(row);
        }
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void transpose() {
        RealMatrix tempMatrix = copy();
        clear();
        for (int i = 0; i < tempMatrix.width(); i++) {
            RealRow temp = new RealRow();
            for (int j = 0; j < tempMatrix.size(); j++) {
                temp.add(tempMatrix.getNumberAt(j, i));
            }
            add(temp);
        }
    }

    public void clean() {
        forEach(row -> {
            RealRow temp = (RealRow) row.clone();
            row.clear();
            temp.stream()
                    .map(d -> Math.round(d * 100) / 100.0)
                    .collect(Collectors
                            .toCollection(RealRow::new))
                    .forEach(d -> row.add(d));
        });
    }

    private void isValidMultiplication(Matrix<Double> matrix2) {
        if (matrix2.width() != size()) {
            throw new IllegalArgumentException("Du kan ikke multiplisere en matrise med " + matrix2.width()
                    + " kolonner med en matrise med " + size() + " rader!");
        }
    }

    @Override
    public Double multiplyEntries(int row1, int col1, Matrix<Double> matrix, int row2, int col2) {
        return getNumberAt(row1, col1) * matrix.getNumberAt(row2, col2);
    }

    @Override
    public boolean entryIsZero(int row, int column) {
        return getNumberAt(row, column) == 0;
    }

    @Override
    public boolean entryIsNormalized(int row, int column) {
        return getNumberAt(row, column) == 1;
    }

    public RealMatrix(RealRow... rows) {
        addAll(Stream.of(rows).toList());
    }

    public RealMatrix(Row<Double>... rows) {
        super(rows);
    }

    public RealMatrix(VektorRom vektorRom) {
        this(vektorRom.getBasis());
    }

    public RealMatrix(ArrayList<Vektor> basis) {
        this(basis.stream().map(v -> new RealRow(
                v.stream().mapToDouble(r -> r.get(0))
                        .toArray()))
                .toArray(RealRow[]::new));
        RealMatrixOperator.transpose(this);
        RealMatrixOperator.clean(this);
    }

    public RealMatrix(int antallRader, int antallKolonner, Double... doubles) {
        if (doubles.length != antallRader * antallKolonner) {
            throw new IllegalArgumentException();
        }
        IntStream.range(0, antallRader).forEach(i -> {
            add(new RealRow(IntStream.range(i * antallKolonner, i * antallKolonner + antallKolonner)
                    .mapToDouble(d -> doubles[d]).toArray()));
        });
    }

    public RealMatrix(int antallRader, int antallKolonner, Integer... integers) {
        this(antallRader, antallKolonner,
                Stream.of(integers).mapToDouble(i -> i).boxed().toArray(Double[]::new));
    }

}