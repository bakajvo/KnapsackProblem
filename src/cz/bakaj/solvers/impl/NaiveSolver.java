package cz.bakaj.solvers.impl;

import cz.bakaj.model.Item;
import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class NaiveSolver implements Solver {

    private int _solve(int remainingCapacity, int n, List<Item> items) {
        if(n == 0) {
            return 0;
        }
        Item tmp = items.get(n-1);
        int cost = 0;
        if(remainingCapacity - tmp.getWeight() >= 0)
            cost = tmp.getCost();
        return Math.max(
                cost + _solve(remainingCapacity - tmp.getWeight(), n-1, items),
                _solve(remainingCapacity, n-1, items)
        );

    }

    @Override
    public Knapsack solve(Knapsack knapsack) {
        knapsack.setResult(_solve(knapsack.getCapacity(), knapsack.getItems().size(), knapsack.getItems()));
        return knapsack;
    }
}
