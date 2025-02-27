package fundament;

import java.util.Comparator;

public class CompareByPivot implements Comparator<Row> {
    @Override
    public int compare(Row arg0, Row arg1) {
        return arg0.getPivotIndex() == arg1.getPivotIndex() ? 0 : (arg0.getPivotIndex() == 10000 ? 1 : (arg0.getPivotIndex() < arg1.getPivotIndex() ? -1 : 1));
    }    
}