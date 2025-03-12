package Kladd;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LesingFraFil {
    private static IntStream read() {
        try {
            return Files.lines(Paths
            .get(LesingFraFil.class
            .getResource("tekst.txt")
            .toURI()))
            .flatMap(l -> Stream.of(l.split("[\\s,]+")))
            .map(t -> t.strip())
            .mapToInt(t -> Integer.valueOf(t));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(read().summaryStatistics());
    }
}