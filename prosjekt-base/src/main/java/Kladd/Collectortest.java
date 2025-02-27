package Kladd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fundament.Row;

public class Collectortest {
    public static void main(String[] args) {
        // List<Integer> test = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));    
        // Stream<Integer> stream = test.stream();
        // Map<Boolean, List<Integer>> oddepar  = stream.collect(
        //     Collectors.partitioningBy(s->s%2==0));
        
        // oddepar.forEach((k,v) -> System.out.println(v));

        // List<Car> biler = new ArrayList<>();
        // // Flere Toyota-biler
        // biler.add(new Car("Toyota", 3));
        // biler.add(new Car("Toyota", 5));
        // biler.add(new Car("Toyota", 2));

        // // Flere Ford-biler
        // biler.add(new Car("Ford", 4));
        // biler.add(new Car("Ford", 6));

        // // Flere BMW-biler
        // biler.add(new Car("BMW", 1));
        // biler.add(new Car("BMW", 3));

        // // Flere Audi-biler
        // biler.add(new Car("Audi", 4));
        // biler.add(new Car("Audi", 2));

        // // Andre merker med flere biler
        // biler.add(new Car("Mercedes", 1));
        // biler.add(new Car("Mercedes", 3));
        // biler.add(new Car("Honda", 2));
        // biler.add(new Car("Honda", 4));

        // Map<String, List<Car>> byBrand = biler.stream()
        // .collect(Collectors
        // .groupingBy(c -> c.merke));

        // System.out.println(biler);

        // byBrand.forEach((k,v) -> System.out.println(k + "\n" + v));
    //     Collector<Double, Row, Row> customCollector = Collector.of(
    //         null,
    //         null, 
    //         null,
    //         null);

    //     Row row = new Row(Arrays.asList(1.0, 2.0, 3.0));
    //     System.out.println(row);

    //     ArrayList<Double> r = row.stream()
    //     .collect(new Collector<Integer,Row,Row>().co {
            
    //     }) ;
    //     System.out.println(r);
    // }
}
}