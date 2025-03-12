package fundament;

import java.util.Scanner;
import java.util.stream.Stream;

public class Vektor extends Matrix {
    public Vektor(int rader) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rader; i++) {
            Row row = new Row();
            String string = "Rad " + i;
            System.out.println(string);
            // scanner.nextLine();
            String tall = scanner.nextLine();
            row.add(Double.valueOf(tall));
            add(row);
        }
    }

    public double getNumberAt(int rowNumber) {
        return get(rowNumber).get(0);
    }

    public void setNumberAt(int rowNumber, double newNumber) {
        get(rowNumber).set(0, newNumber);
    }

    public void add(Vektor vektor) {
        if (size() != vektor.size()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size(); i++) {
            setNumberAt(i, getNumberAt(i) + vektor.getNumberAt(i));
        }
    }

    public void subtract(Vektor vektor) {
        if (size() != vektor.size()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size(); i++) {
            setNumberAt(i, getNumberAt(i) - vektor.getNumberAt(i));
        }
    }

    public void scale(double scalar) {
        forEach(r -> {
            r.set(0, r.get(0)*scalar);
        });
    }

    public int dim() {
        return size();
    }

    @Override
    public Vektor copy() {
        Vektor vektor = new Vektor();
        forEach(r -> vektor.add(r));
        return vektor;
    }

    public Vektor() {
    }

    public Vektor(Double... doubles) {
        Stream.of(doubles)
                .forEach(d -> {
                    Row row = new Row();
                    row.add(d);
                    add(row);
                });
    }

    public Vektor(Integer... integers) {
        Stream.of(integers)
                .mapToDouble(i -> Double.valueOf(i))
                .forEach(d -> {
                    Row row = new Row();
                    row.add(d);
                    add(row);
                });
    }

    public static void main(String[] args) {
        Vektor vektor = new Vektor(1, 2, 3);
        System.out.println(vektor);
    }
}
