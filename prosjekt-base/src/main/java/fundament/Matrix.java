package fundament;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix extends ArrayList<Row> { // Extends ArrayList<Row> // Vurder å endre til LinkedList<Row>

    public void setRow(int rowNumber, Row row) {
        set(rowNumber, row);
    }

    public void setNumber(int rowNumber, int columnNumber, double number) {
        get(rowNumber).set(columnNumber, number);
    }

    public double getNumberAt(int rowNumber, int columnNumber) {
        return get(rowNumber).get(columnNumber);
    }

    public Matrix copy() {
        Matrix newMatrix = new Matrix();
        for (Row row : this) {
            Row tempRow = new Row();
            for (double d : row) {
                tempRow.add(d);
            }
            newMatrix.add(tempRow);
        }
        return newMatrix;
    }

    public int width() {
        return get(0).size();
    }

    @Override
    public String toString() { // Matrix
        String ut = "";
        for (Row rad : this) {
            ut += rad + "\n";
        }
        return ut;
    }

    public Matrix(int rader, int kolonner) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rader; i++) {
            Row row = new Row();
            for (int j = 0; j < kolonner; j++) {
                String string = "Index " + i + j;
                System.out.println(string);
                String tallString = scanner.nextLine();
                row.add(Double.valueOf(tallString));
            }
            add(row);
        }
        // scanner.close();
    }

    public Matrix() {
    }

    public static void main(String[] args) { // Lag testCase
        // System.out.println("Working");
        // Row rm1 = new Row();
        // rm1.add(0.0);
        // rm1.add(0.0);
        // rm1.add(0.0);
        // Row rm2 = new Row();
        // rm2.add(1.0);
        // rm2.add(2.0);
        // rm2.add(1.0);
        // Row rm3 = new Row();
        // rm3.add(0.0);
        // rm3.add(2.0);
        // rm3.add(3.0);
        // Matrix M1 = new Matrix();
        // M1.add(rm1);
        // M1.add(rm2);
        // M1.add(rm3);

        // Row rm12 = new Row();
        // rm12.add(1.0);
        // rm12.add(2.0);
        // rm12.add(5.0);
        // Row rm22 = new Row();
        // rm22.add(0.0);
        // rm22.add(1.0);
        // rm22.add(1.0);
        // Row rm32 = new Row();
        // rm32.add(0.0);
        // rm32.add(0.0);
        // rm32.add(1.0);
        // Matrix m2 = new Matrix();
        // m2.add(rm12);
        // m2.add(rm22);
        // m2.add(rm32);


        // System.out.println(M1);
        // System.out.println(m2);

        // Matrix M1Inverse = new InverseMatrixCalculator().getInverse(M1);
        // new MatrixOperator().multiply(M1, M1Inverse);
        // System.out.println(M1);

        // Matrix matrix = new Matrix(2, 2);
        // System.out.println(matrix);
        Matrix matrix = new Matrix(3,   3);
        System.out.println(matrix);
    }
}