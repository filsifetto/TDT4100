package fundament;

import java.io.Serializable;

public interface Matrix<T> extends Serializable{
    void setRow(int rowNumber, Row<T> row);
    void setNumber(int rowNumber, int columnNumber, T number);
    T getNumberAt(int rowNumber, int columnNumber);
    Matrix<T> copy();
    int width();
    String toString();   
    boolean entryIsZero(int row, int column);
    boolean entryIsNormalized(int row, int column);
    int size();
    boolean sortedByZeroRows();
    void clear();
    T multiplyEntries(int row1, int col1, Matrix<T> matrix, int row2, int col2);
    void multiply(Matrix<T> matrix);
    void transpose();
    void clean();
    Matrix<T> identity();
}