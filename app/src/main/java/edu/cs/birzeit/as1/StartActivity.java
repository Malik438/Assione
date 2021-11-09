package edu.cs.birzeit.as1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import Model.FoodModel;
import Model.Food;

import com.google.gson.Gson;

import java.util.ArrayList;

import Model.Model;
import Model.Person;

public class StartActivity extends AppCompatActivity {
    TextView textView;
    static  String bmitype ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
      /*  Gson gson = new Gson();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = preferences.getString("data","");
        Person person= gson.fromJson(data,Person.class);
        textView = findViewById(R.id.name);
        textView.setText(person.getName());*/
        runTime();

    }

    public void runTime() {
        final TextView textView = findViewById(R.id.name);
        Model model = new Model();
        final Handler handler = new Handler();
        handler.post(() -> {
            Gson gson = new Gson();
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String data = preferences.getString("data", "");
            Person person = gson.fromJson(data, Person.class);
            bmitype = person.getBmitype() ;

            if (model.BmiResult(person.getBMI()).equals("Underweight")) {
                textView.setText("Hello Mr  " + person.getName() + " you need to be more carfull about your health by increasong your weight while your Bmi  " + person.getBMI() + "and it less than 18.5");

            } else if (model.BmiResult(person.getBMI()).equals("Normalweight")) {
                textView.setText(" Hello Mr " + person.getName() + "  your in safe side while your BMI still " + person.getBMI());


            } else if (model.BmiResult(person.getBMI()).equals("overwight")) {
                textView.setText("Hello Mr " + person.getName() + " your above the avagre of healty bmi you need to  lose some  weight while your bmi  equal :" + person.getBMI());


            } else {
                textView.setText("Hello Mr" + person.getName() + "your in danger zone while your bmi  : " + person.getBMI());
            }

        });
    }

    public void getdietOnClick(View view) {
        FoodModel  food = new FoodModel();
        ArrayList<Food> arr = food.intialfood() ;
        ArrayList<Food> array = new ArrayList<Food>();
        ArrayList<Food> arrr = food.getfoodbybmi(bmitype);
        array = arrr ;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String data = gson.toJson(array);
        editor.putString("data",data);
        editor.apply();
        Intent intent = new Intent(this,LastActivity.class);
        startActivity(intent);


    }
}