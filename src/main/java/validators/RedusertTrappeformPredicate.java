package validators;

import java.util.function.Predicate;

import fundament.Matrix;
import operators.PivotComperator;

public class RedusertTrappeformPredicate {

    private static Predicate<Matrix> predicate = (matrix) -> {
        boolean ut = true;
        if (!TrappeformPredicate.test(matrix)) {
            return false;
        }
        if (!sortedByZeroRows(matrix)) {
            return false;
        }
        for (int i = 0; i < matrix.width(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (matrix.getNumberAt(j, i) != 0) {
                    boolean pivot = true;
                    for (int p = 0; p < i; p++) {
                        if (matrix.getNumberAt(j, p) != 0) {
                            pivot = false;
                        }
                    }
                    if (pivot) {
                        if (matrix.getNumberAt(j, i) != 1) {
                            ut = false;
                        }
                        for (int p = 0; p < j; p++) {
                            if (matrix.getNumberAt(p, i) != 0) { // Sjekk om det finnes et tall ulik 0 over pivot
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

    private static boolean sortedByZeroRows(Matrix matrix) {
        Matrix compare = matrix.copy();
        compare.sort(new PivotComperator());
        return matrix.equals(compare);
    }

    public static boolean test(Matrix matrix) {
        return predicate.test(matrix);
    }

    private RedusertTrappeformPredicate() {
    };
}
