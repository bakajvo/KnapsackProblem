package cz.bakaj;

import cz.bakaj.model.Knapsack;
import cz.bakaj.utils.Measure;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Measure.start();
        List<Knapsack> knapsacks = Loader.loadProblems("data/knap_40.inst.dat");
        System.out.println(Measure.stop());
    }
}
