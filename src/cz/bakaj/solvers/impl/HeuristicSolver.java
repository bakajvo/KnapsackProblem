package cz.bakaj.solvers.impl;

import cz.bakaj.model.Item;
import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class HeuristicSolver implements Solver {

    @Override
    public Knapsack solve(Knapsack knapsack) {
        List<Item> temp = knapsack.getItems();
        temp.sort(Comparator.comparing(Item::getRatio));
        int max = 0;
        for (int i = temp.size()-1; i>= 0; i--) {
            int t = i;
            int cur = 0;
            int capacity = knapsack.getCapacity();
            while (t>=0) {
                if (capacity - temp.get(t).getWeight() >= 0) {
                    capacity -= temp.get(t).getWeight();
                    cur += temp.get(t).getCost();
                }
                t--;
            }
            if (cur > max) {
                max = cur;
            }
        }
        knapsack.setResult(max);
        return knapsack;
    }
}
