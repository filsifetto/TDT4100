package fundament;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RealRowTest {
    private RealRow row1;
    private RealRow row2;
    private RealRow row3;

    @BeforeEach
    private void setUp() {
        row1 = new RealRow(1,2,3,4);
        row2 = new RealRow(0.0,0.0,0.0,3.4);
        row3 = new RealRow(0,0,0,0);

        
    }


    @Test
    void testGetPivot() {
        assertEquals(1.0, row1.getPivot().get());
        assertEquals(3.4, row2.getPivot().get());
        assertTrue(row3.getPivot().isEmpty());
    }

    @Test
    void testGetPivotIndex() {
        assertEquals(0, row1.getPivotIndex().getAsInt());
        assertEquals(3, row2.getPivotIndex().getAsInt());
        assertTrue(row3.getPivotIndex().isEmpty());
    }

    @Test
    void testIsZero() {
        assertFalse(row1.isZero());
        assertFalse(row2.isZero());
        assertTrue(row3.isZero());
    }
}
