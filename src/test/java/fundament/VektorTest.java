package fundament;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VektorTest {
    private Vektor vektor1;
    private Vektor vektor2;
    private Vektor vektor3;
    private Vektor vektor4;

    @BeforeEach
    private void setUp() {
        vektor1 = new Vektor(1,2,3);
        vektor2 = new Vektor(0,1,-4);
        vektor3 = new Vektor(0,0,0);
        vektor4 = new Vektor(1,2);
    }

    @Test
    void testAdd() {
        vektor1.add(vektor2);
        assertEquals(new Vektor(1,3,-1), vektor1);
        assertThrows(IllegalArgumentException.class, () -> vektor1.add(vektor4));
    }

    @Test
    void testCopy() {
        assertEquals(new Vektor(0,1,-4), vektor2.copy());
    }

    @Test
    void testDim() {
        assertEquals(3, vektor2.dim());
    }

    @Test
    void testGetNumberAt() {
        assertEquals(1, vektor2.getNumberAt(1));
        assertThrows(IllegalArgumentException.class, () -> vektor4.getNumberAt(2));
    }

    @Test
    void testScale() {
        vektor1.scale(2);
        vektor3.scale(10);
        assertEquals(new Vektor(2,4,6), vektor1);
        assertEquals(new Vektor(0, 0,0), vektor3);
    }

    @Test
    void testSetNumberAt() {
        vektor1.setNumberAt(2, 4);
        assertEquals(new Vektor(1,2,4), vektor1);
        assertThrows(IllegalArgumentException.class, () -> vektor1.setNumberAt(3, 2));   
    }

    @Test
    void testSubtract() {
        vektor1.subtract(vektor2);
        assertEquals(new Vektor(1,1,7), vektor1);
        assertThrows(IllegalArgumentException.class, () -> vektor1.subtract(vektor4));
    }
}
