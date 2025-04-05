package App;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Leaderboard {

    public static HashMap<String, Double> read() {
        HashMap<String, Double> map = new HashMap<>();
        try {
            Files.readAllLines(Paths.get(Leaderboard.class.getResource("liste.txt").toURI()))
                    .stream()
                    .forEach(l -> {
                        map.put(l.split(":")[0],
                                Double.valueOf(l.split(":")[1]));
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    public static void reset() {
        try (PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/App/liste.txt"))) {
            ps.print("");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(String user, String time) {
        HashMap<String, Double> map = Leaderboard.read();
        if (map.containsKey(user)) {
            if (Double.valueOf(time) < map.get(user)) {
                map.put(user, Double.valueOf(time));
            }
        }
        else {
            map.put(user, Double.valueOf(time));
        }
        try (PrintStream printStream = new PrintStream(new FileOutputStream("src/main/java/App/liste.txt"))) {
            ArrayList<Entry<String, Double>> liste = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            liste.addAll(map.entrySet());
            Collections.sort(liste, (e1, e2) -> Integer.valueOf(String.valueOf(Math.round(e1.getValue() * 100)))
                    - Integer.valueOf(String.valueOf(Math.round(e2.getValue() * 100))));
            liste.forEach(e -> {
                sb.append(e.getKey() + ":" + e.getValue() + "\n");
            });
            printStream.print(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readAsText() {
        try { 
            return Files.readString(Paths.get(Leaderboard.class.getResource("liste.txt").toURI()));
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void main(String[] args) {
        System.out.println(Leaderboard.readAsText());
    }
}
