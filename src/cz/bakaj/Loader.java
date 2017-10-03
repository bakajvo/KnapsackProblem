package cz.bakaj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Vojtěch Bakaj.
 */
public class Loader {

    public Loader(String filename) {
        try {
            FileReader reader = new FileReader(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("");
            e.printStackTrace();
        }
    }
}
