package cz.bakaj.solvers.impl.generic;

import java.util.BitSet;
import java.util.Random;

/**
 * Created by Vojtěch Bakaj.
 */
public class Individual {

    private BitSet value;
    private int fitness = 0;

    public Individual(int n) {
        value = new BitSet(n);
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public BitSet getValue() {
        return value;
    }

    static Individual random(int n) {
        Random random = new Random();
        Individual result = new Individual(n);
        for(int i = 0; i < n; i++) {
            if(random.nextBoolean())
                result.value.set(i);
        }
        return result;
    }
}
