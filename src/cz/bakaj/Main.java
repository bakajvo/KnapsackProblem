package cz.bakaj;

import cz.bakaj.model.Knapsack;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Knapsack> knapsacks = Loader.loadProblems("data/knap_4.inst.dat");
    }
}
