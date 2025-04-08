package fundament;

import java.util.Collection;

public interface Matrix<T> extends Collection<Row<T>> {
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
    Row<T> get(int i);
}