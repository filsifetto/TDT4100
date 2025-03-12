package fundament;

import operators.MatrixOperator;
import operators.ToolMatrix;

public class Kompleks extends Vektor {  

    @Override
    public String toString() {
        if (getImaginary() == 0) {
            return String.valueOf(getReal());
        }
        if (getReal() == 0) {
            return String.format("%.1fi", getImaginary());
        }
        if (getImaginary() < 0) {
            return String.format("%.1f - %.1fi", getReal(), -getImaginary());
        }
        return String.format("%.1f + %.1fi", getReal(), getImaginary());
    }

    public double getReal() {
        return getNumberAt(0);
    }

    public double getImaginary() {
        return getNumberAt(1);
    }

    public Kompleks getConjugate() {
        return new Kompleks(getReal(), -getReal());
    }

    public void multiply(Kompleks w) {
        MatrixOperator.multiply(
            this, 
            ToolMatrix.complex(w));
    }

    Kompleks(double a, double b) {
        super(a, b);
    }

    Kompleks(double a) {
        this(a, 0);
    }

    public static void main(String[] args) {
        Kompleks kompleks = new Kompleks(1.2, 2.0);
        Kompleks k2 = new Kompleks(2);
        System.out.println(kompleks);
        System.out.println(k2);
        kompleks.multiply(k2);
        System.out.println(kompleks);
    }
}
