package kalkulasjoner;

import fundament.RealMatrix;
import fundament.Vektor;
import fundament.VektorRom;
import operators.RealMatrixOperator;
import operators.RealToolMatrix;

public class ProjectionCalculator {

    public static Vektor project(Vektor vektor, VektorRom vektorRom) {
        if (vektor.dim() != vektorRom.getBasis().get(0).dim()) {
            throw new IllegalArgumentException(vektorRom + "er ikke et underrom av R" + vektor.dim());
        }
        vektorRom.setOrtogonalBasis();
        RealMatrix P = RealToolMatrix.projection(vektorRom);
        Vektor projection = vektor.copy();
        RealMatrixOperator.multiply(projection, P);
        RealMatrixOperator.clean(projection);
        return projection;
    }

    public static void printProjection(Vektor vektor, VektorRom vektorRom) {
        Vektor projection = project(vektor, vektorRom);
        System.out.println("Vektoren \n" + vektor + "Projisert på " + vektorRom + " er \n" + projection);
    }

    private ProjectionCalculator() {
    };
}