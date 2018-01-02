package cz.bakaj.solvers.impl.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class GeneHelper {

    public static List<Individual> createPopulation(int n, int items) {
        List<Individual> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(Individual.random(items));
        }
        return result;
    }
}
