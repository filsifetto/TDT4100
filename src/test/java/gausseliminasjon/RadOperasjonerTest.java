package gausseliminasjon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.RealMatrix;

public class RadOperasjonerTest {
    
    private RealMatrix testMatrix;
    private ArrayList<RealMatrix> matrixs;

    @BeforeEach
    void setUp() {
        testMatrix = new RealMatrix(
            3,3,
            1, 2, -4,
            0, 0, 1,
            0, 1, 0);
        matrixs = new ArrayList<>();
    }


    @Test
    void testEliminateUp() {

    }

    @Test
    void testRadbytte() {

    }

    @Test
    void testRowReduction() {

    }

    @Test
    void testScaleByPivot() {

    }

    @Test
    void testScaleRow() {

    }

    @Test
    void testSortByPivot() {
        RealMatrix expected = new RealMatrix(3,3,
        1, 2, -4,
        0, 1, 0,
        0, 0, 1);
        RadOperasjoner.sortByPivot(matrixs, testMatrix);

        assertEquals(expected, testMatrix);
    }
}
