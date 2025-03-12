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

    public void add(Kompleks w) {
        setNumberAt(0, getReal() + w.getReal());
        setNumberAt(1, getImaginary() + w.getImaginary());
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

    Kompleks(double a, double b) {
        super(a, b);
    }

    Kompleks(double a) {
        this(a, 0);
    }

    public static void main(String[] args) {
        Kompleks kompleks = new Kompleks(1, 1.0);
        Kompleks k2 = new Kompleks(0,1);
        System.out.println(kompleks);
        System.out.println(k2);
        kompleks.printPolar();
        k2.printPolar();
        kompleks.multiply(k2);
        System.out.println(kompleks);
    }
}
