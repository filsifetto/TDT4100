package fundament;

import java.util.Comparator;

public class CompareByPivot implements Comparator<Row> {
    @Override
    public int compare(Row arg0, Row arg1) {
        return arg0.getPivotIndex() == arg1.getPivotIndex() ? 0 : (arg0.getPivotIndex() == 10000 ? 1 : (arg0.getPivotIndex() < arg1.getPivotIndex() ? -1 : 1));
        // if (arg0.getPivotIndex() == arg1.getPivotIndex()) {
        //     return 0;
        // }
        // if (arg0.getPivotIndex() == 100000) {
        //     return 1;
        // }
        // if (arg1.getPivotIndex() == 100000) {
        //     return -1;
        // }
        // if (arg0.getPivotIndex() < arg1.getPivotIndex()) {
        //     return -1;
        // }
        // else {
        //     return 1;
        // }
    }    

    public static void main(String[] args) {
        Row rm1 = new Row();
        rm1.add(0.0);
        rm1.add(0.0);
        rm1.add(0.0);
        Row rm2 = new Row();
        rm2.add(1.0);
        rm2.add(2.0);
        rm2.add(1.0);
        Row rm3 = new Row();
        rm3.add(3.0);
        rm3.add(2.0);
        rm3.add(3.0);
        Matrix M1 = new Matrix();
        M1.add(rm1);
        M1.add(rm2);
        M1.add(rm3);

        System.out.println(M1);
        M1.sort(new CompareByPivot());
        System.out.println(M1);
    }
}
