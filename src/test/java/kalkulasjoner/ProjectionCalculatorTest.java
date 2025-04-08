package kalkulasjoner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.Vektor;
import fundament.VektorRom;

public class ProjectionCalculatorTest {

    VektorRom U;
    VektorRom V;
    Vektor b;

    @BeforeEach
    void setUp() {
        U = new VektorRom(
            new Vektor(1,0,0),
            new Vektor(1,1,0)
        );
        V = new VektorRom(
            new Vektor(1,0,2),
            new Vektor(0,1,0),
            new Vektor(1,2,3)
        );
        b = new Vektor(1,2,3);
    }


    @Test
    void testProject() {
        Vektor projUb = ProjectionCalculator.project(b, U);
        Vektor projVb = ProjectionCalculator.project(b, V);

        assertEquals(new Vektor(1,2,0), projUb);
        assertEquals(b, projVb);
    }
}
