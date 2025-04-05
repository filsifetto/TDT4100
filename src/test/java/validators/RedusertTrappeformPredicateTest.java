package validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.RealMatrix;

public class RedusertTrappeformPredicateTest {
    private RealMatrix matrix1;
    private RealMatrix matrix2;
    private RealMatrix matrix3;
    private RealMatrix matrix4;

    @BeforeEach
    private void setUp() {
        matrix1 = new RealMatrix(2,2,
        1,0,0,0);
        matrix2 = new RealMatrix(2, 2, 
        1,2,0,2);
        matrix3 = new RealMatrix(3, 3, 
        1,0,3,
        0,1,2,
        0,0,0);
        matrix4 = new RealMatrix(3, 3, 
        1,0,0,
        0,1,0,
        0,0,1);
    }


    @Test
    void testTest() {
        assertTrue(RedusertTrappeformPredicate.test(matrix1));
        assertFalse(RedusertTrappeformPredicate.test(matrix2));
        assertTrue(RedusertTrappeformPredicate.test(matrix3));
        assertTrue(RedusertTrappeformPredicate.test(matrix4));
    }
}
