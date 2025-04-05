package fundament;

import java.util.Optional;
import java.util.OptionalInt;

public interface Row<T> {
    OptionalInt getPivotIndex();
    Optional<T> getPivot();
    boolean isZero();
    boolean entryIsZero(int index);
    T get(int index);
    T set(int index, T value);
    int size();
    Row<T> clone();
    void clear();
    boolean add(T t);
}