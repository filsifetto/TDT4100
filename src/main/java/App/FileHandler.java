package App;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import fundament.RealMatrix;

public class FileHandler {
    private static final String matrixBankPath = "src/main/java/App/matrixBank.txt";


    public static void writeMatrixBank() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(matrixBankPath))) {
            outputStream.writeObject(MatrixBank.createMatrices());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<RealMatrix> readMatrixBank() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(matrixBankPath))) {
            return (List<RealMatrix>) input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        FileHandler.writeMatrixBank();
        System.out.println(FileHandler.readMatrixBank());
    }
}
