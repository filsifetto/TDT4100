package fundament;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class RealRow extends AbstractRow<Double> {

    /**
     * 
     * @return {@code double} pivot
     */
    public Optional<Double> getPivot() {
        return stream().filter(d -> d!=0).findFirst();
    }

    public RealRow(Double... doubles) {
        super(doubles);
    }

    @Override
    public boolean entryIsZero(int index) {
        return get(index) == 0;
    }

    /**
     * 
     * Constructs a {@code Row} by casting integers to doubles
     * @param Integers to cast to doubles
     * 
     */
    public RealRow(Integer... integers) {
        Stream.of(integers).mapToDouble(i -> (int)i)
        .forEach(d -> add(d));
    }

    public RealRow(double[] doubles) {
        DoubleStream.of(doubles).forEach(d -> add(d));
    }

    public RealRow() {}
}