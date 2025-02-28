package fundament;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix extends ArrayList<Row> { // Vurder å endre til LinkedList<Row>

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
    public String toString() {
        String ut = "";
        for (Row rad : this) {
            ut += rad + "\n";
        }
        return ut;
    }

    public Matrix(int rader, int kolonner) {
        @SuppressWarnings("resource")
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
    }

    public Matrix() {
    }

    public Matrix(ArrayList<Vektor> basis) {
        for (Vektor v : basis) {
            for (int i = 0; i < v.size(); i++) {
                if (size() <= i) {
                    Row row = new Row();
                    row.add(v.getNumberAt(i));
                    add(row);
                } else {
                    get(i).add(v.getNumberAt(i));
                }
            }
        }
        // basis.forEach(v -> v.forEach(r -> {
        // if (size() < v.indexOf(r) + 1) {
        // Row row = new Row();
        // row.add(r.get(0));
        // add(row);
        // }
        // else {
        // get(v.indexOf(r))
        // .add(r.get(0));
        // }
        // }));
        // for (int i = 0; i < list.get(0).size(); i++) {
        // Row row = new Row();
        // for (Vektor v : list) {
        // row.add(v.getNumberAt(i));
        // }
        // add(row);
        // }
    }

    public static void main(String[] args) {
        Vektor v = new Vektor(3);
        Vektor v2 = new Vektor(3);
        Vektor v3 = new Vektor(3);
        ArrayList<Vektor> basis = new ArrayList<>();
        basis.add(v);
        basis.add(v2);
        basis.add(v3);
        Matrix matrix = new Matrix(basis);
        System.out.println(matrix);
    }
}