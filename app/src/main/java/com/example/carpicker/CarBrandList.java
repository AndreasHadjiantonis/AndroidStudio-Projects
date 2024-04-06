package com.example.carpicker;

import java.util.ArrayList;

public class CarBrandList {

    private ArrayList<CarBrand> carBrands = new ArrayList<>();
    public void addCarBrand(CarBrand carBrand) {

        carBrands.add(carBrand);

    }

    public void addCarModel(String modelName, String brandName) {

        for(int i = 0; i< carBrands.size(); i++)
            if(carBrands.get(i).isBrand(brandName))
                carBrands.get(i).addModel(modelName);
    }

    public ArrayList<String> getModels(String carBrand) {

        ArrayList<String> models = new ArrayList<>();

        for(int i=0;i<carBrands.size();i++)
            if(carBrands.get(i).isBrand(carBrand))
                return carBrands.get(i).getModels();

        return null;
    }
}
