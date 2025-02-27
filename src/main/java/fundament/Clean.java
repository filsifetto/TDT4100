package fundament;

import java.util.stream.Collectors;

public class Clean {

    private void cleanRow(Row row) {
        Row temp = (Row)row.clone();
        row.clear();
        temp.stream()
        .map(d -> Math.round(d*100)/100.0)
        .collect(Collectors
        .toCollection(Row::new))
        .forEach(d -> row.add(d));
    }

    public void clean(Matrix matrix) {
        matrix.forEach(row -> cleanRow(row));
    }
}