package cz.bakaj.model;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class Knapsack {

    private int id;
    private int capacity = 0;
    private List<Item> items;

    public Knapsack(int id, int capacity, List<Item> items) {
        this.id = id;
        this.capacity = capacity;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Item> getItems() {
        return items;
    }
}
