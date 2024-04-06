package com.example.carpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CarBrandList cbl;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cbl = new CarBrandList(); //on create to get the data the first time

        rg = (RadioGroup) findViewById(R.id.rgBrandModel);

        //Adding the car objects to the list of the carbrandlist object
        cbl.addCarBrand(new CarBrand("Toyota"));
        cbl.addCarBrand(new CarBrand("Nissan"));
        cbl.addCarBrand(new CarBrand("VW"));

        cbl.addCarModel("Yaris", "Toyota");
        cbl.addCarModel("Auris", "Toyota");
        cbl.addCarModel("Rav4", "Toyota");

        cbl.addCarModel("Golf", "VW");
        cbl.addCarModel("Polo", "VW");
    }

    public void carButtonClick (View view) { //View view -> means that the button inside the activity_main.xml can use this function

        rg.removeAllViews(); //removes the previous views (if created)
        Spinner ddl = (Spinner) findViewById(R.id.ddlCarBrands); //Create a spinner attribute called ddl, attach it to ddlcars from the xml
        String selectedBrand = String.valueOf(ddl.getSelectedItem()); // converts the ddlCars item to String and stores it

        ArrayList<String> selectedModels = cbl.getModels(selectedBrand);

        if(selectedModels.size() == 0)
            Toast.makeText(getApplicationContext(), getString(R.string.ToastNoModels), Toast.LENGTH_LONG).show(); //%s is needed before the text inside the strings.xml, after ToastNoModels we could add ,SelectedBrand to show the name
         else {

            //rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
            for(int i=0; i<selectedModels.size();i++){

                RadioButton rb = new RadioButton(this);
                rb.setText(selectedModels.get(i));
                rb.setId(100+i);
                rg.addView(rb);

            }
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton rb = (RadioButton)findViewById(checkedId);
                    Toast.makeText(getApplicationContext(), selectedBrand+" "+rb.getText(), Toast.LENGTH_SHORT).show();
                }
            });
         }
    }
}


