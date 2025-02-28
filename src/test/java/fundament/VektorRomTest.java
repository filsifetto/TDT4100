package fundament;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VektorRomTest {
    VektorRom vektorRom;
    Vektor test1;
    Vektor test2;

    @BeforeEach
    void setup() {
        Row r1v1 = new Row();
        r1v1.add(1.0);
        Row r2v1 = new Row();
        r2v1.add(2.0);
        Vektor v1 = new Vektor();
        v1.add(r1v1);
        v1.add(r2v1);

        Row r1v2 = new Row();
        r1v2.add(2.0);
        Row r2v2 = new Row();
        r2v2.add(3.0);
        Vektor v2 = new Vektor();
        v2.add(r1v2);
        v2.add(r2v2);

        Row r1v3 = new Row();
        r1v3.add(3.0);
        Row r2v3 = new Row();
        r2v3.add(4.0);
        test1 = new Vektor();
        v1.add(r1v3);
        v1.add(r2v3);

        Row r1v4 = new Row();
        r1v4.add(1.0);
        Row r2v4 = new Row();
        r2v4.add(2.0);
        test2 = new Vektor();
        v1.add(r1v4);
        v1.add(r2v4);

        vektorRom = new VektorRom(null);
        Set<Vektor> set = new HashSet<>();
        set.add(v1);
        set.add(v2);
        vektorRom.setBasis(set);
    }

    @Test
    void testContains() {
        assertEquals(false, vektorRom.contains(test1));
        assertEquals(true, vektorRom.contains(test2));
    }
}
