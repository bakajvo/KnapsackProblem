package cz.bakaj.solvers;

import cz.bakaj.model.Knapsack;

/**
 * Created by Vojtěch Bakaj.
 */
public interface Solver {

    Knapsack solve(Knapsack knapsack);
}
