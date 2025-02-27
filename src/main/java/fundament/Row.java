package fundament;

import java.util.ArrayList;

public class Row extends ArrayList<Double> {

    public int getPivotIndex() {
        for (int i = 0; i < size(); i++) {
            if (get(i) != 0) {
                return i;
            }
        }
        return 100000;
    }

    public double getPivot() {
        for (double d : this) {
            if (d != 0) {
                return d;
            }
        }
        return Double.NaN;
    }

    public boolean isZero() {
        boolean status = true;
        for (double d : this) {
            if (d != 0) {
                status = false;
            }
        }
        return status;
    }
}