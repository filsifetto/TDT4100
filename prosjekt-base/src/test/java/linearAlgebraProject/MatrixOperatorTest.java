package linearAlgebraProject;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundament.Matrix;

public class MatrixOperatorTest {
    private Matrix matrix1;
    private Matrix matrix2;
    
    @BeforeEach
    public void setUp() {
        ArrayList<Double> rm1 = new ArrayList<>();
        rm1.add(0.0);
        rm1.add(0.0);
        rm1.add(0.0);
    
        ArrayList<Double> rm2 = new ArrayList<>();
        rm2.add(1.0);
        rm2.add(2.0);
        rm2.add(1.0);
        ArrayList<Double> rm3 = new ArrayList<>();
        rm3.add(0.0);
        rm3.add(0.0);
        rm3.add(0.0);
        ArrayList<ArrayList<Double>> m1 = new ArrayList<>();
        m1.add(rm1);
        m1.add(rm2);
        m1.add(rm3);

        ArrayList<Double> rm12 = new ArrayList<>();
        rm12.add(1.0);
        rm12.add(2.0);
        rm12.add(5.0);
        ArrayList<Double> rm22 = new ArrayList<>();
        rm22.add(0.0);
        rm22.add(1.0);
        rm22.add(1.0);
        ArrayList<Double> rm32 = new ArrayList<>();
        rm32.add(0.0);
        rm32.add(0.0);
        rm32.add(1.0);
        ArrayList<ArrayList<Double>> m2 = new ArrayList<>();
        m2.add(rm12);
        m2.add(rm22);
        m2.add(rm32);

        this.matrix1 = new Matrix(m1);
        this.matrix2 = new Matrix(m2);
    }

    @Test
    void testIsValidMultiplication() {

    }

    @Test
    void testMatrixMultiplication() {

    }
}
