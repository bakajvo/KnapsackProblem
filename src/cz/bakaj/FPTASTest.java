package cz.bakaj;

import cz.bakaj.model.Knapsack;
import cz.bakaj.model.Result;
import cz.bakaj.solvers.Solver;
import cz.bakaj.solvers.impl.FPTASAlgorithm;
import cz.bakaj.utils.Loader;
import cz.bakaj.utils.Measure;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class FPTASTest {
    public static void main(String[] args) {

        String[] instances = {"4"};

        for (String instance : instances) {
            List<Knapsack> knapsacks = Loader.loadProblems("data/in/knap_"+instance+".inst.dat");
            if(knapsacks != null) {
                Solver solver = new FPTASAlgorithm();
                Measure.start();
                knapsacks.forEach(solver::solve);
                System.out.println("CPU Time for instance "+instance+" is " + Measure.stop() + "s.");
            }

            List<Result> results = Loader.loadResults("data/result/knap_"+instance+".sol.dat");
            if(results != null && knapsacks != null) {
                for (int i = 0; i < results.size(); i++) {
                    System.out.println("Knapsack with id:" + results.get(i).getId() + " Result:" + results.get(i).getResult() + " FPTAS:"+knapsacks.get(i).getResult());
                }
            }
        }
    }
}
