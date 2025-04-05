package App;

import java.util.List;
import java.util.Random;

import fundament.RealMatrix;
import kalkulasjoner.InverseMatrixCalculator;

public class TaskGenerator {
    public static Task generate() {
        List<RealMatrix> list = FileHandler.readMatrixBank();
        Random random = new Random();
        RealMatrix matrix = list.get(random.nextInt(0, list.size()));
        RealMatrix inverse = InverseMatrixCalculator.getInverse(matrix);
        return new Task(matrix, inverse);
    }

    public static void main(String[] args) {
        System.out.println(TaskGenerator.generate());
    }
}