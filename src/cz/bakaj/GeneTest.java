package cz.bakaj;

import cz.bakaj.model.Knapsack;
import cz.bakaj.model.Result;
import cz.bakaj.solvers.Solver;
import cz.bakaj.solvers.impl.GenericSolver;
import cz.bakaj.utils.Loader;
import cz.bakaj.utils.Measure;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class GeneTest {

    public static void main(String[] args) {

        String[] instances = {"40"};

        for (String instance : instances) {
            List<Knapsack> knapsacks = Loader.loadProblems("data/in/knap_"+instance+".inst.dat");
            if(knapsacks != null) {
                Solver solver = new GenericSolver();
                knapsacks.forEach(solver::solve);
            }

            List<Result> results = Loader.loadResults("data/result/knap_"+instance+".sol.dat");
            if(results != null && knapsacks != null) {
                for (int i = 0; i < results.size(); i++) {
                    System.out.println(Measure.relativeError(results.get(i).getResult(), knapsacks.get(i).getResult()));
                }
            }
        }
    }
}
