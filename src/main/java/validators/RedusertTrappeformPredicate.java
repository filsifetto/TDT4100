package validators;

import java.util.function.Predicate;

import fundament.Matrix;

public class RedusertTrappeformPredicate {

    private static final Predicate<Matrix> predicate = (matrix) -> {
        boolean ut = true;
        if (!TrappeformPredicate.test(matrix)) {
            return false;
        }
        if (!matrix.sortedByZeroRows()) {
            return false;
        }
        for (int i = 0; i < matrix.width(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (!matrix.entryIsZero(j, i)) {
                    boolean pivot = true;
                    for (int p = 0; p < i; p++) {
                        if (!matrix.entryIsZero(j, p)) {
                            pivot = false;
                        }
                    }
                    if (pivot) {
                        if (!matrix.entryIsNormalized(j, i)) {
                            ut = false;
                        }
                        for (int p = 0; p < j; p++) {
                            if (!matrix.entryIsZero(p, i)) { // Sjekk om det finnes et tall ulik 0 over pivot
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

    private RedusertTrappeformPredicate() {
    };
}
