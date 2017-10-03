package cz.bakaj;

import cz.bakaj.model.Knapsack;
import cz.bakaj.solvers.Solver;
import cz.bakaj.solvers.impl.NaiveSolver;
import cz.bakaj.utils.Measure;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Knapsack> knapsacks = Loader.loadProblems("data/in/knap_4.inst.dat");
        if(knapsacks != null) {
            Solver solver = new NaiveSolver();
            Measure.start();
            knapsacks.forEach(solver::solve);
            System.out.println("CPU Time:"+Measure.stop());
        }

    }
}
