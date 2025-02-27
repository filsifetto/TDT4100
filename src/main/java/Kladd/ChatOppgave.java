package Kladd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChatOppgave {
    public static void main(String[] args) {
        List<Car> biler = new ArrayList<>();
        // Flere Toyota-biler
        biler.add(new Car("Toyota", 3, 12));
        biler.add(new Car("Toyota", 5, 17));
        biler.add(new Car("Toyota", 2, 190));

        // Flere Ford-biler
        biler.add(new Car("Ford", 4, 67));
        biler.add(new Car("Ford", 6, 54));

        // Flere BMW-biler
        biler.add(new Car("BMW", 1, 0));
        biler.add(new Car("BMW", 3, 89));

        // Flere Audi-biler
        biler.add(new Car("Audi", 4, 40));
        biler.add(new Car("Audi", 2, 23));

        // Andre merker med flere biler
        biler.add(new Car("Mercedes", 1, 92));
        biler.add(new Car("Mercedes", 14, 14));
        biler.add(new Car("Honda", 2, 21));
        biler.add(new Car("Honda", 4, 109));

        List<Car> ungeCars = biler.stream()
        .filter(p -> p.getAge()<=10)
        .toList();

        Map<String, List<Car>> sortByBrand = ungeCars.stream()
        .collect(Collectors
        .groupingBy(p -> p.getBrand()));

        Map<String, List<Double>> stats = new HashMap<>();

        sortByBrand.forEach((k, v) -> {
            List<Double> temp = new ArrayList<>();
            double numberOfCars = Double.valueOf(v.stream().count());
            double avgAge = v.stream()
            .mapToDouble(c -> c.getAge())
            .sum();
            double km = v.stream()
            .mapToDouble(s -> s.getKm())
            .sum();
            temp.add(numberOfCars);
            temp.add(avgAge);
            temp.add(km);
            stats.put(k, temp);
        });

    }
}
