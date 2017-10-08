package cz.bakaj.model;

/**
 * Created by Vojtěch Bakaj.
 */
public class Item {
    private int cost;
    private int weight;

    public Item(int cost, int weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public Double getRatio() {
        return cost/(double)weight;
    }
}
