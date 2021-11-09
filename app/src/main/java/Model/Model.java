package Model;

import java.util.ArrayList;

public class Model {
    Person person = new Person() ;

    public   Double  CalculateBmi(Double height , Double weight){
         return   weight/Math.pow(height/100,2) ;

    }
    public   String BmiResult(Double BMI){
        if(BMI < 18.5){
            return "Underweight";
        }else if(BMI >=18.5 && BMI<=24.9){
            return "Normalweight";
        }else if(BMI >=25 && BMI<=29.9){
            return "overwight";
        }else{
            return "obese";
        }
    }
    public  String [] getGenders(){
        String [] gender = new String[]{"Female","male"};
        return  gender ;
    }


}
