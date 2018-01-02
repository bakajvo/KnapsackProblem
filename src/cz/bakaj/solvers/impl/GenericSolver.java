package cz.bakaj.solvers.impl;

import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;
import cz.bakaj.solvers.impl.generic.GeneHelper;
import cz.bakaj.solvers.impl.generic.Individual;

import java.util.List;
import java.util.Random;

/**
 * Created by Vojtěch Bakaj.
 */
public class GenericSolver implements Solver {

    private static final int POPULATION = 100;
    private static final int GENERATION = 10000;
    private static final int TOURNAMENT = 5;
    private static final double MUTATION = 0.01;

    private Random random = new Random();
    private List<Individual> individuals;
    private Knapsack knapsack;

    private int fitnessFunction(Individual individual) {
        int result = 0;
        int weightSum = 0;
        for (int i = 0; i < knapsack.getItems().size(); i++) {
            if(individual.getValue().get(i)) {
                result += knapsack.getItems().get(i).getCost();
                weightSum += knapsack.getItems().get(i).getWeight();
            }
        }
        result = weightSum <= knapsack.getCapacity() ? result : 0;
        individual.setFitness(result);
        return result;
    }

    private Individual tournamentSelection(int n) {
        Individual result = individuals.get(random.nextInt(POPULATION));
        for (int i = 0; i < n-1; i++) {
            Individual tmp = individuals.get(random.nextInt(POPULATION));
            if(result.getFitness() < tmp.getFitness())
                result = tmp;
        }
        return result;
    }

    private Individual crossover(Individual a, Individual b) {
        Individual individual = new Individual(knapsack.getItems().size());
        for (int i = 0; i < knapsack.getItems().size(); i++) {
            if(i <= knapsack.getItems().size()/2) {
                individual.getValue().set(i, a.getValue().get(i));
            } else {
                individual.getValue().set(i, b.getValue().get(i));
            }
        }
        fitnessFunction(individual);
        return individual;
    }

    private void mutate(Individual a) {
        for (int i = 0; i < knapsack.getItems().size(); i++) {
            if(Math.abs(random.nextDouble())<=MUTATION)
                a.getValue().flip(i);
        }
        fitnessFunction(a);
    }

    private int nextGeneration() {
        Individual a = tournamentSelection(TOURNAMENT);
        Individual b = tournamentSelection(TOURNAMENT);
        individuals.add(crossover(a, b));
        mutate(a);
        mutate(b);
        Individual max, min;
        max = min = individuals.get(0);
        for(Individual individual: individuals) {
            if(max.getFitness()<individual.getFitness())
                max = individual;
            if(min.getFitness() > individual.getFitness())
                min = individual;
        }
        individuals.remove(min);
        return max.getFitness();
    }

    @Override
    public Knapsack solve(Knapsack knapsack) {
        this.knapsack = knapsack;
        individuals = GeneHelper.createPopulation(POPULATION, knapsack.getItems().size());
        individuals.forEach(this::fitnessFunction);

        for (int i = 0; i <GENERATION ; i++) {
            knapsack.setResult(nextGeneration());
        }
        return knapsack;
    }
}
