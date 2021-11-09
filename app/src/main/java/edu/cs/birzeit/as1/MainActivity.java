package edu.cs.birzeit.as1;

import static android.content.SharedPreferences.*;
import static Model.Model.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import Model.Person;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.io.Serializable;

import Model.Model;

public class MainActivity extends AppCompatActivity {
    public  Spinner spinner ;
    public EditText editname ;
    public  EditText editheight ;
    public  EditText editwight ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.Gender);
        editname = findViewById(R.id.name);
        editheight = findViewById(R.id.height);
        editwight  = findViewById(R.id.weghit);
        papulatespinner();
    }

    public void viewstartactivityOnClik(View view) {
        Model model = new Model();
        Double height  = Double.parseDouble(editheight.getText().toString()) ;
        Double weight = Double.parseDouble(editwight.getText().toString()) ;
        Person person = new Person() ;
        person.setName(editname.getText().toString());
        person.setHeight(height);
        person.setWeight(weight);
        person.setGender(spinner.getSelectedItem().toString());
        person.setBMI(model.CalculateBmi(height,weight));
        person.setBmitype(model.BmiResult(model.CalculateBmi(height,weight)));
       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
       Editor editor = preferences.edit();
       Gson gson = new Gson();
       String data = gson.toJson(person);
       editor.putString("data",data);
       editor.apply();
        Intent intent = new Intent(this,StartActivity.class);

        startActivity(intent);
    }
    public  void  papulatespinner(){
        Model model = new Model();
        String [] genders = model.getGenders();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,genders);
        spinner.setAdapter(adapter);
    }
}