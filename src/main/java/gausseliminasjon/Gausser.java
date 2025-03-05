package gausseliminasjon;

import java.util.ArrayList;

import fundament.Matrix;
import validators.TrappeformPredicate;

public class Gausser {
    private Matrix matrix;
    private ArrayList<Matrix> radOperasjonListe = new ArrayList<>();
    
    private ArrayList<Integer> identifyElimination() {
        ArrayList<Integer> eliminationRows = new ArrayList<>();
        for (int i = 1; i < matrix.size(); i++) {
            if (matrix.get(i).getPivotIndex() == matrix.get(i - 1).getPivotIndex()) {
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

    public ArrayList<Matrix> getRowOperations() {
        return radOperasjonListe;
    }

    public Gausser(Matrix matrix) {
        this.matrix = matrix.copy();
    }
}
