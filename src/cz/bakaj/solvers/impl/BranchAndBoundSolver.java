package cz.bakaj.solvers.impl;

import cz.bakaj.model.Item;
import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class BranchAndBoundSolver implements Solver {

    private int maxCost = 0;

    private int sumCosts(List<Item> items, int to) {
        int sum = 0;
        for (int i = 0; i < to; i++) {
            sum += items.get(i).getCost();
        }
        return sum;
    }

    private int _solve(int remainingCapacity, int n, List<Item> items, int cost) {
        if(maxCost < cost) {
            maxCost = cost;
        }
        if(n == 0 || remainingCapacity == 0 || maxCost >= sumCosts(items, n) + cost) {
            return 0;
        }

        if(items.get(n-1).getWeight() > remainingCapacity) {
            return _solve(remainingCapacity, n-1, items, cost);
        } else {
            Item tmp = items.get(n-1);
            return Math.max(
                    tmp.getCost() + _solve(remainingCapacity - tmp.getWeight(), n-1, items, cost + tmp.getCost()),
                    _solve(remainingCapacity, n-1, items, cost)
            );
        }
    }

    @Override
    public Knapsack solve(Knapsack knapsack) {
        maxCost = 0;
        knapsack.setResult(_solve(knapsack.getCapacity(), knapsack.getItems().size(), knapsack.getItems(), 0));
        return knapsack;
    }
}
