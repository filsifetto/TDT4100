package operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.RealMatrix;


public class PivatComperatorTest {
    private RealMatrix matrix1;
    private RealMatrix matrix2;

    @BeforeEach
    void setUp() {
        matrix1 = new RealMatrix(2,2,
        1,2,3,4);
        matrix2 = new RealMatrix(2, 2, 
        0,0,1,2);
    }

    @Test
    void testSort() {
        matrix1.sort(new PivotComperator<>());
        matrix2.sort(new PivotComperator<>());
        assertEquals(new RealMatrix(2, 2, 1,2,3,4), matrix1);
        assertEquals(new RealMatrix(2, 2, 1,2,0,0), matrix2);
    }
}
