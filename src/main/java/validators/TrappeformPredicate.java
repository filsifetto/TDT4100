package validators;

import java.util.function.Predicate;

import fundament.Matrix;

public class TrappeformPredicate {
    private static Predicate<Matrix> predicate = (matrix) -> {
        boolean ut = true;
        for (int i = 0; i < matrix.width(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (matrix.getNumberAt(j, i) != 0) {
                    boolean pivot = true;
                    for (int p = 0; p < i; p++) { // Sjekker om det finnes et tall ulik 0 til venstre for pivot
                        if (matrix.getNumberAt(j, p) != 0) {
                            pivot = false;
                        }
                    }
                    if (pivot) {
                        for (int p = j + 1; p < matrix.size(); p++) { // Sjekker om det finnes et tall under
                            if (matrix.getNumberAt(p, i) != 0) {
                                ut = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ut;
    };

    public static boolean test(Matrix matrix) {
        return predicate.test(matrix);
    }

    private TrappeformPredicate() {
    };
}