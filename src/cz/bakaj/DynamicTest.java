package cz.bakaj;

import cz.bakaj.model.Knapsack;
import cz.bakaj.model.Result;
import cz.bakaj.solvers.Solver;
import cz.bakaj.solvers.impl.DynamicSolver;
import cz.bakaj.utils.Measure;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class DynamicTest {
    public static void main(String[] args) {

        String[] instances = {"4", "10", "15", "20", "22", "25", "27", "30", "32", "35", "37", "40"};

        for (String instance : instances) {
            List<Knapsack> knapsacks = Loader.loadProblems("data/in/knap_"+instance+".inst.dat");
            if(knapsacks != null) {
                Solver solver = new DynamicSolver();
                Measure.start();
                knapsacks.forEach(solver::solve);
                System.out.println("CPU Time for instance "+instance+" is " + Measure.stop() + "s.");
            }

            List<Result> results = Loader.loadResults("data/result/knap_"+instance+".sol.dat");
            if(results != null && knapsacks != null) {
                for (int i = 0; i < results.size(); i++) {
                    if(results.get(i).getResult() != knapsacks.get(i).getResult()) {
                        System.out.println("Knapsack with id:" + results.get(i).getId() + " doesn't match!");
                    }
                }
            }
        }
    }
}
