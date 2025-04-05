package fundament;

import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class AbstractRow<T> extends ArrayList<T> implements Row<T> {

    /**
     * 
     * @return {@code OptionalInt} index of first non-zero entry
     */
    public OptionalInt getPivotIndex() {
        return IntStream.range(0, size())
        .filter(i -> !entryIsZero(i)).findFirst();
    }

    @Override
    public AbstractRow<T> clone() {
        return (AbstractRow) super.clone();
    }

    /**
     * 
     * @return {@code true} if all entries are zero, {@code false} otherwise
     */
    public boolean isZero() {
        // return stream().allMatch(d -> d == 0);
        return getPivotIndex().isEmpty();
    }

    public AbstractRow(T... ts) {
        Stream.of(ts).forEach(d -> add(d));
    } 
}