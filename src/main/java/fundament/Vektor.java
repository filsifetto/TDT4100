package fundament;

import java.util.Scanner;

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

    public Vektor() {
    }
}
