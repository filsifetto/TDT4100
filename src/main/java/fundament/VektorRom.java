package fundament;

import java.util.ArrayList;

import kalkulasjoner.EquationSolver;
import operators.RealMatrixOperator;
import operators.RealToolMatrix;
import operators.VektorOperator;

public class VektorRom {
    private ArrayList<Vektor> basis = new ArrayList<>();

    public boolean contains(Vektor vektor) {
        ArrayList<Vektor> vektorMengde = new ArrayList<>();
        basis.forEach(t -> vektorMengde.add(t));
        vektorMengde.add(vektor);
        RealMatrix A = new RealMatrix(vektorMengde);
        if (EquationSolver.dimSolution(A, RealToolMatrix.nullVektor(vektor.size())) > 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Vektor> getBasis() {
        return basis;
    }

    public void setOrtogonalBasis() {
        ArrayList<Vektor> temp = new ArrayList<>();
        basis.forEach(v -> temp.add(v));
        basis.clear();
        for (Vektor v : temp) {
            Vektor u = v.copy();
            for (Vektor w : basis) {
                RealMatrix ProjW = RealToolMatrix.projection(new VektorRom(w));
                Vektor uProjW = u.copy();
                RealMatrixOperator.multiply(uProjW, ProjW);
                u.subtract(uProjW);
            }
            basis.add(u);
        }
    }

    public VektorRom(Vektor... vektorer) {
        for (Vektor v : vektorer) {
            if (basis.size() > 0) {
                if (v.size() != basis.get(0).size()) {
                    throw new IllegalArgumentException("Kan ikke ha en basis bestående av vektorer av ulike dimensjoner!");
                }
            }
            if (!contains(v)) {
                this.basis.add(v);
            }
        }
    }

    public boolean hasOrthogonalBasis() {
        boolean status = true;
        for (Vektor v : basis) {
            for (Vektor u : basis) {
                double scalarProduct = Math.round(VektorOperator.skalarProdukt(v, u)*100)/100.0;
                if (scalarProduct != 0 && !(u == v)) {
                    status = false;
                }
            }
        }
        return status;
    }

    @Override
    public String toString() {
        String string = "Vektorrommet spent ut av kolonnene i matrisen \n";
        string += new RealMatrix(basis);
        return string;
    }

    public int dim() {
        return basis.size();
    }
}