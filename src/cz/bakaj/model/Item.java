package cz.bakaj.model;

/**
 * Created by Vojtěch Bakaj.
 */
public class Item {
    private boolean added;
    private int cost;
    private int weight;

    public Item(int cost, int weight) {
        this.added = false;
        this.cost = cost;
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }
}
