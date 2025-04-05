package validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.RealMatrix;

public class TrappeformPredicateTest {
    private RealMatrix matrix1;
    private RealMatrix matrix2;
    private RealMatrix matrix3;

    @BeforeEach
    private void setUp() {
        matrix1 = new RealMatrix(2,2,
        1,2,3,4);
        matrix2 = new RealMatrix(2, 2, 
        1,2,0,2);
        matrix3 = new RealMatrix(3, 3, 
        1,2,3,
        0,1,2,
        0,0,1);
    }

    @Test
    void testTest() {
        assertFalse(TrappeformPredicate.test(matrix1));
        assertTrue(TrappeformPredicate.test(matrix2));
        assertTrue(TrappeformPredicate.test(matrix3));
    }
}
