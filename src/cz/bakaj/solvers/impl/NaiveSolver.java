package cz.bakaj.solvers.impl;

import cz.bakaj.model.Item;
import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class NaiveSolver implements Solver {

    private int _solve(int weight, int n, List<Item> items) {
        if(n == 0 || weight == 0) {
            return 0;
        }
        if(items.get(n-1).getWeight() > weight) {
            return _solve(weight, n-1, items);
        } else {
            Item tmp = items.get(n-1);
            return Math.max(
                    tmp.getCost() + _solve(weight - tmp.getWeight(), n-1, items),
                    _solve(weight, n-1, items)
            );
        }
    }

    @Override
    public Knapsack solve(Knapsack knapsack) {
        knapsack.setResult(_solve(knapsack.getCapacity(), knapsack.getItems().size(), knapsack.getItems()));
        return knapsack;
    }
}
