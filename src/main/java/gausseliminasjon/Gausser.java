package gausseliminasjon;

import java.util.ArrayList;

import fundament.Matrix;
import validators.TrappeformPredicate;

public class Gausser {
    private Matrix matrix;
    private ArrayList<Matrix> radOperasjonListe = new ArrayList<>();
    private TrappeformPredicate trappeform = new TrappeformPredicate();
    private RadOperasjoner gauss = new RadOperasjoner();
    
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
        while (!trappeform.test(matrix)) {
            gauss.sortByPivot(radOperasjonListe, matrix);
            gauss.scaleByPivot(radOperasjonListe, matrix);
            if (trappeform.test(matrix)) {
                break;
            }
            ArrayList<Integer> elimRows = identifyElimination();
            gauss.rowReduction(radOperasjonListe, matrix, elimRows.get(0), elimRows.get(1), 1);
            gauss.scaleByPivot(radOperasjonListe, matrix);
        }
    }

    public void gaussOpp() {
        gauss.scaleByPivot(radOperasjonListe, matrix);
        gauss.eliminateUp(radOperasjonListe, matrix);
        gauss.sortByPivot(radOperasjonListe, matrix);
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
