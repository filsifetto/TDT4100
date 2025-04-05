package fundament;

import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class AbstractMatrix<T> extends ArrayList<Row<T>> implements Matrix<T> {

    public void setRow(int rowNumber, Row<T> row) {
        set(rowNumber, row);
    }

    public void setNumber(int rowNumber, int columnNumber, T number) {
        get(rowNumber).set(columnNumber, number);
    }

    public T getNumberAt(int rowNumber, int columnNumber) {
        return get(rowNumber).get(columnNumber);
    }

    public int width() {
        return get(0).size();
    }

    public abstract Matrix<T> copy();

    public AbstractMatrix(Row<T>... rows) {
        addAll(Stream.of(rows).toList());
    }
}
