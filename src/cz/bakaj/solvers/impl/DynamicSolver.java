package cz.bakaj.solvers.impl;

import cz.bakaj.model.Item;
import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class DynamicSolver implements Solver {

    private static final int INF = Integer.MAX_VALUE;

    @Override
    public Knapsack solve(Knapsack knapsack) {
        List<Item> items = knapsack.getItems();
        int sum = items.stream().mapToInt(Item::getCost).sum();
        int table[][] = new int[items.size()][sum+1];

        for (int i = 0; i<items.size(); i++) {
            for (int c = 1; c<sum+1; c++) {
                int left = INF, right = INF;
                if(i-1 >= 0) {
                    left = table[i-1][c];
                }
                if(c-items.get(i).getCost() >= 0 && i-1 >= 0 && table[i-1][c - items.get(i).getCost()] != INF) {
                    right = table[i-1][c - items.get(i).getCost()] + items.get(i).getWeight();
                } else if(c-items.get(i).getCost() == 0 && i-1 < 0) {
                    right = items.get(i).getWeight();
                }
                table[i][c] = Math.min(left, right);
            }
        }

        for (int s = sum; s>=0; s--) {
            if(knapsack.getCapacity() >= table[items.size()-1][s] && table[items.size()-1][s] != 0) {
                knapsack.setResult(s);
                break;
            }
        }
        return knapsack;
    }
}
