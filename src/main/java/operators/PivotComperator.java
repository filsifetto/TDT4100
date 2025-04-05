package operators;

import java.util.Comparator;

import fundament.Row;

public class PivotComperator<T> implements Comparator<Row<T>> {
    // @Override
    // public int compare(RealRow arg0, RealRow arg1) {
    //     return arg0.getPivotIndex() == arg1.getPivotIndex() ? 0 : (arg0.getPivotIndex() == 10000 ? 1 : (arg0.getPivotIndex() < arg1.getPivotIndex() ? -1 : 1));
    // }    

    @Override
    public int compare(Row<T> o1, Row<T> o2) {
        if (o2.getPivotIndex().isEmpty() && o1.getPivotIndex().isEmpty()) {
            return 0;
        }
        if (o2.getPivotIndex().isEmpty()) {
            return -1;
        }
        if (o1.getPivotIndex().isEmpty()) {
            return 1;
        }
        return o1.getPivotIndex().getAsInt() - o2.getPivotIndex().getAsInt();
    }
}