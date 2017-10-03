package cz.bakaj;

import cz.bakaj.model.Item;
import cz.bakaj.model.Knapsack;
import cz.bakaj.model.Result;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Vojtěch Bakaj.
 */
public class Loader {

    private static final String SEPARATOR = " ";

    private Loader() {
        //private constructor
    }

    private static Knapsack parseLine(String line) {
        String[] result = line.split(SEPARATOR);
        int count = Integer.parseInt(result[1]);
        List<Item> items = new ArrayList<>();
        for (int i = 3; i < (count*2)+3; i+=2) { //first three is ID/COUNT/CAPACITY
            items.add(new Item(Integer.parseInt(result[i+1]), Integer.parseInt(result[i])));
        }
        return new Knapsack(Integer.parseInt(result[0]), Integer.parseInt(result[2]), items);
    }

    public static List<Knapsack> loadProblems(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            List<Knapsack> result = new ArrayList<>();
            stream.forEach(line -> {
                result.add(parseLine(line));
            });
            return result;
        } catch (IOException e) {
            System.out.println("Cannot load input file with name: " + filename);
            e.printStackTrace();
            return null;
        }
    }

    public static List<Result> loadResults(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            List<Result> result = new ArrayList<>();
            stream.forEach(line -> {
                String[] tmp = line.split(SEPARATOR);
                result.add(new Result(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[2])));
            });
            return result;
        } catch (IOException e) {
            System.out.println("Cannot load input file with name: " + filename);
            e.printStackTrace();
            return null;
        }
    }
}
