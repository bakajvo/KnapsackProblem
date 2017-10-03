package cz.bakaj.model;

/**
 * Created by Vojtěch Bakaj.
 */
public class Result {

    private int id;
    private int result;

    public Result(int id, int result) {
        this.id = id;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public int getResult() {
        return result;
    }
}
