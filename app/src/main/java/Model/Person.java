package Model;

public class Person {
    private Double height;
    private Double weight;
    private Double BMI;
    private String Name;
    private String gender;
    private String Bmitype;


    public Person(Double height, Double weight, Double BMI, String name, String gender, String Bmitype) {
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        Name = name;
        this.gender = gender;
        this.Bmitype = Bmitype;
    }

    public Person() {

    }

    public String getBmitype() {
        return Bmitype;
    }

    public void setBmitype(String bmitype) {
        Bmitype = bmitype;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
