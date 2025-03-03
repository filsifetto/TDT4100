package kalkulasjoner;

import fundament.Matrix;
import fundament.Vektor;
import fundament.VektorRom;
import operators.MatrixOperator;
import operators.ToolMatrix;

public class ProjectionCalculator {
    
    public Vektor project(Vektor vektor, VektorRom vektorRom) {
        if (vektor.dim() != vektorRom.getBasis().get(0).dim()) {
            throw new IllegalArgumentException(vektorRom + "er ikke et underrom av R" + vektor.dim());
        }
        vektorRom.setOrtogonalBasis();
        Matrix P = new ToolMatrix().projection(vektorRom);
        Vektor projection = vektor.copy();
        new MatrixOperator().multiply(projection, P);
        new MatrixOperator().clean(projection);
        return projection;
    }

    public void printProjection(Vektor vektor, VektorRom vektorRom) {
        Vektor projection = project(vektor, vektorRom);
        System.out.println("Vektoren \n" + vektor + "Projisert på " + vektorRom + " er \n" + projection);
    }
}