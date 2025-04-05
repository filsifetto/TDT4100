package validators;

import java.util.function.Predicate;

import fundament.Matrix;

public class TrappeformPredicate {
    private static Predicate<Matrix> predicate = (matrix) -> {
        boolean ut = true;
        for (int i = 0; i < matrix.width(); i++) {



            for (int j = 0; j < matrix.size(); j++) {




                if (!matrix.entryIsZero(j, i)) {
                    boolean pivot = true;
                    for (int p = 0; p < i; p++) { // Sjekker om det finnes et tall ulik 0 til venstre for pivot
                        if (!matrix.entryIsZero(j, p)) {
                            pivot = false;
                        }
                    }
                    if (pivot) {
                        for (int p = j + 1; p < matrix.size(); p++) { // Sjekker om det finnes et tall under
                            if (!matrix.entryIsZero(p, i)) {
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

    /**
     * sjekker om matrisen er på trappeform. Her er det KAOS
     * @param matrix
     * @return {@code boolean} 
     */

    public static boolean test(Matrix matrix) {
        return predicate.test(matrix);
    }

    private TrappeformPredicate() {
    };
}