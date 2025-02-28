package fundament;

import java.util.ArrayList;

import kalkulasjoner.EquationSolver;
import operators.ToolMatrix;

public class VektorRom {
    private ArrayList<Vektor> basis = new ArrayList<>();

    public boolean contains(Vektor vektor) {
        ArrayList<Vektor> vektorMengde = new ArrayList<>();
        basis.forEach(t -> vektorMengde.add(t));
        vektorMengde.add(vektor);
        Matrix A = new Matrix(vektorMengde);
        if (new EquationSolver().dimSolution(A, new ToolMatrix().nullVektor(vektor.size())) > 0) {
            return true;
        }
        return false;
    }

    public void setBasis(ArrayList<Vektor> basis) {
        this.basis = basis;
    }

    public VektorRom(Vektor... vektorer) {
        
    }
}