package cz.bakaj.model;

import java.util.List;

/**
 * Created by Vojtěch Bakaj.
 */
public class Knapsack {

    private int id;
    private int capacity = 0;
    private List<Item> items;
    private int result = 0;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
