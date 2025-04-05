package kalkulasjoner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.RealMatrix;

public class InverseMatrixCalculatorTest {
    private RealMatrix identityMatrix = new RealMatrix(3,3,
        1, 0, 0,
        0, 1, 0,
        0, 0, 1);

    private RealMatrix testMatrix1 = new RealMatrix(
        3,3,
        1, 2, -4,
        0, 0, 1,
        0, 1, 0);

    private RealMatrix test2;

    @BeforeEach
    void setUp() {
        test2 = new RealMatrix(3,3,
        1,  0,  2,
        1,  1,  2,
       -1, -1, -1);
    }
    

    @Test
    void testGetInverse() {
        assertEquals(identityMatrix, InverseMatrixCalculator.getInverse(identityMatrix));
        assertEquals(new RealMatrix(3,3,
        1, 4, -2,
        0, 0, 1,
        0, 1, 0),
        InverseMatrixCalculator.getInverse(testMatrix1));
        assertEquals(new RealMatrix(3, 3, 
        1,-2,-2,
        -1,1,0,
        0,1,1), InverseMatrixCalculator.getInverse(test2));
    }
}
