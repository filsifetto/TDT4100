package operators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.Vektor;

public class VektorOperatorTest {
    Vektor v1;
    Vektor v2;
    Vektor v3;
    Vektor v4;

    @BeforeEach
    void setUp() {
        v1 = new Vektor(1,2,3);
        v2 = new Vektor(1,0,0);
        v3 = new Vektor(1,2);
        v4 = new Vektor(0,0,0);
    }

    @Test
    void testSkalarProdukt() {
        assertEquals(14, VektorOperator.skalarProdukt(v1, v1));
        assertEquals(1, VektorOperator.skalarProdukt(v1, v2));
        assertEquals(0, VektorOperator.skalarProdukt(v1, v4));
        assertThrows(IllegalArgumentException.class, () -> VektorOperator.skalarProdukt(v1, v3));
    }
}