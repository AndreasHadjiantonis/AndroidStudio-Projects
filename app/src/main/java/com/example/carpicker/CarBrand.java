//A class with of a CarBrand with an arraylist of its models

package com.example.carpicker;
import java.util.ArrayList;
import java.util.List;
public class CarBrand {

    private String name;

    private ArrayList<String> carModels = new ArrayList<String>();

    public CarBrand(String name) {

        this.name = name;
    }

    public boolean isBrand(String brand) {

        return name.equals(brand);
    }

    public void addModel(String model) {

        carModels.add(model);
    }

    public ArrayList<String> getModels() {

        return carModels;
    }
}