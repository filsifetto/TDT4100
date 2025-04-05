package gausseliminasjon;

import java.util.ArrayList;

import fundament.RealMatrix;
import validators.TrappeformPredicate;

public class Gausser {
    private RealMatrix matrix;
    private ArrayList<RealMatrix> radOperasjonListe = new ArrayList<>();
    
    private ArrayList<Integer> identifyElimination() {
        ArrayList<Integer> eliminationRows = new ArrayList<>();
        for (int i = 1; i < matrix.size(); i++) {
            if (matrix.get(i).getPivotIndex().isEmpty() || matrix.get(i - 1).getPivotIndex().isEmpty()) {
                continue;
            }
            if (matrix.get(i).getPivotIndex().getAsInt() == matrix.get(i - 1).getPivotIndex().getAsInt()) {
                eliminationRows.add(i-1);
                eliminationRows.add(i);
                break;
            }
        }
        return eliminationRows;
    }

    public void gaussNed() {
        while (!TrappeformPredicate.test(matrix)) {
            RadOperasjoner.sortByPivot(radOperasjonListe, matrix);
            RadOperasjoner.scaleByPivot(radOperasjonListe, matrix);
            if (TrappeformPredicate.test(matrix)) {
                break;
            }
            ArrayList<Integer> elimRows = identifyElimination();
            RadOperasjoner.rowReduction(radOperasjonListe, matrix, elimRows.get(0), elimRows.get(1), 1);
            RadOperasjoner.scaleByPivot(radOperasjonListe, matrix);
        }
    }

    public void gaussOpp() {
        RadOperasjoner.scaleByPivot(radOperasjonListe, matrix);
        RadOperasjoner.eliminateUp(radOperasjonListe, matrix);
        RadOperasjoner.sortByPivot(radOperasjonListe, matrix);
    }

    public void gaussEliminasjon() {
        gaussNed();
        gaussOpp();
    }

    public ArrayList<RealMatrix> getRowOperations() {
        return radOperasjonListe;
    }

    public Gausser(RealMatrix matrix) {
        this.matrix = matrix.copy();
    }
}
