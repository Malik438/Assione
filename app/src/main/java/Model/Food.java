package Model;

import java.util.ArrayList;

public class Food {
    String day ;
    String type ;
    String foodName ;
    String quantity ;
    String Bmi ;
    String gender ;
    ArrayList<Food> foods = new ArrayList<>();

    public Food(String day, String type, String foodName, String quantity, String bmi, String gender) {
        this.day = day;
        this.type = type;
        this.foodName = foodName;
        this.quantity = quantity;
        Bmi = bmi;
        this.gender = gender;
    }

    public Food() {


    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public Food(String day, String type, String foodName, String quantity) {
        this.day = day;
        this.type = type;
        this.foodName = foodName;
        this.quantity = quantity;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBmi() {
        return Bmi;
    }

    public void setBmi(String bmi) {
        Bmi = bmi;
    }
}
