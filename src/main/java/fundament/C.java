package fundament;

import operators.MatrixOperator;
import operators.ToolMatrix;

public class C extends Vektor {

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

    public C getConjugate() {
        return new C(getReal(), -getImaginary());
    }

    public void multiply(C w) {
        MatrixOperator.multiply(
            this, 
            ToolMatrix.complex(w));
    }

    public void divideBy(C w) {
        multiply(w.getConjugate());
        scale(1/w.getLength());
    }

    public void add(C w) {
        setNumberAt(0, getReal() + w.getReal());
        setNumberAt(1, getImaginary() + w.getImaginary());

        // setNumberAt(0, getReal() + w.getReal());
        // setNumberAt(1, getImaginary() + w.getImaginary());
    }

    public void subtract(C w) {
        setNumberAt(0, getReal() + w.getReal());
        setNumberAt(1, getImaginary() + w.getImaginary());
    }

    public static C sum(C z, C w) {
        return new C(z.getReal() + w.getReal(), z.getImaginary() + w.getImaginary());
    }

    public static C difference(C z, C w) {
        return new C(z.getReal() - w.getReal(), z.getImaginary() - w.getImaginary());
    }

    public static C product(C z, C w) {
        C ny = (C)z.copy();
        MatrixOperator.multiply(
            ny, 
            ToolMatrix.complex(w));
        return ny;
    }
 
    public double getAngle() {
        return Math.atan2(getImaginary(), getReal());
    }

    public double getLength() {
        return Math.sqrt(Math.pow(getReal(), 2) + Math.pow(getImaginary(), 2));
    }

    public void printPolar() {
        String string = String.format("%.1fe^%.2fi", getLength(), getAngle());
        System.out.println(string);
    }

    C(double a, double b) {
        super(a, b);
    }

    C(double a) {
        this(a, 0);
    }

    public static void main(String[] args) {
        C z = new C(1, 0);
        C w = new C(0,1);
        System.out.println(C.product(z, w));
    }
}
