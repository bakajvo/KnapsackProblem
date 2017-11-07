package cz.bakaj.solvers.impl;

import cz.bakaj.model.Item;
import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;

import java.util.OptionalInt;

/**
 * Created by Vojtěch Bakaj.
 */
public class FPTASAlgorithm extends DynamicSolver implements Solver{

    private static final double EPS = 0.1;

    @Override
    public Knapsack solve(Knapsack knapsack) {
        OptionalInt c = knapsack.getItems().stream().mapToInt(Item::getCost).max();
        if(c.isPresent()) {
            int C = c.getAsInt();
            double K = (EPS*C)/knapsack.getItems().size();
            for (Item item : knapsack.getItems()) {
                item.setCost((int)(item.getCost()/K));
            }
            Knapsack result = super.solve(knapsack);
            result.setResult((int)(result.getResult()*K));
            return result;
        }
        return null;
    }
}
