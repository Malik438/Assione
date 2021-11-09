package edu.cs.birzeit.as1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Model.Model;
import Model.Food;
import Model.Person;
import Model.FoodlistAdaptar;

public class LastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Person person = new Person();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        run();

    }
    public void run() {
        final  ListView  listview = findViewById(R.id.listview);
        Model model = new Model();
        final Handler handler = new Handler();
        handler.post(() -> {
            Gson gson = new Gson();
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String data = preferences.getString("data", "");
            Type type = new TypeToken<ArrayList<Food>>(){}.getType() ;
            ArrayList<Food> food = gson.fromJson(data,type);
            FoodlistAdaptar adaptar = new FoodlistAdaptar(this, R.layout.arrayadapterlayout,food);
            listview.setAdapter(adaptar);


        });


    }
}