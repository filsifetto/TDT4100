package fundament;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RealMatrixTest {
    private RealMatrix matrix;
    private RealMatrix matrix2;
    private Vektor v1;
    private Vektor v2;
    private ArrayList<Vektor> vektors;


    @BeforeEach
    private void setUp() {
        matrix = new RealMatrix(2,2,
        1,2,
        3,4);
        matrix2 = new RealMatrix(2, 2, 
        0,0,1,2);


        v1 = new Vektor(1,3);
        v2 = new Vektor(2,4);
        vektors = new ArrayList<>();
        vektors.add(v1);
        vektors.add(v2);
    }

    @Test
    void testWidth() {
        assertEquals(matrix, matrix);
    }

    @Test
    void testEntryIsZero() {
        assertFalse(matrix.entryIsZero(1, 1));
        assertTrue(matrix2.entryIsZero(0, 1));
    }

    @Test
    void testEntryIsNormalized() {
        assertTrue(matrix.entryIsNormalized(0, 0));
        assertFalse(matrix2.entryIsNormalized(0, 1));
    }

    @Test
    void testsortedByZeroRows() {
        assertTrue(matrix.sortedByZeroRows());
        assertFalse(matrix2.sortedByZeroRows());
    }

    @Test
    void testMultiplyEntries() {
        assertEquals(3, 
        matrix.multiplyEntries(1, 0, matrix2, 1, 0));
    }

    @Test
    void testMultiply() {
        matrix.multiply(matrix2);
        assertEquals(new RealMatrix(2, 2,
        0, 0,
        7, 10), matrix);
    }

    @Test
    void testTranspose() {
        matrix.transpose();
        assertEquals(new RealMatrix(2, 2,
        1,3,
        2,4), matrix);
    }

    @Test
    void testConstructor() {
        assertEquals(matrix, new RealMatrix(vektors));
    }
}
