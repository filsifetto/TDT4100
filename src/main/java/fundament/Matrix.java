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
}