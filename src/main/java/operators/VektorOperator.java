package operators;

import fundament.Vektor;

public class VektorOperator {

    public static double skalarProdukt(Vektor v1, Vektor v2) {
        double sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.getNumberAt(i) * v2.getNumberAt(i);
        }
        return sum;
    }

    private VektorOperator() {
    };
}