package App;

import fundament.RealMatrix;

public class Task {
    private RealMatrix matrix;
    private RealMatrix inverse;

    public RealMatrix getMatrix() {
        return matrix;
    }

    public RealMatrix getInverse() {
        return inverse;
    }

    public Task(RealMatrix matrix, RealMatrix inverse) {
        this.matrix = matrix;
        this.inverse = inverse;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrise: \n");
        sb.append(matrix + "\n");
        sb.append("Invers: \n");
        sb.append(inverse);
        return sb.toString();
    }
}
