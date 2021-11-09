package Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import edu.cs.birzeit.as1.R;

public class FoodlistAdaptar  extends ArrayAdapter<Food> {

    private static final  String  TAG  = "FoodlistAdapter" ;
    private Context contextfood;
    int Resource;

    public FoodlistAdaptar(Context context, int resource, ArrayList<Food> objects) {
        super(context, resource, objects);
        this.contextfood = context;
        this.Resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String day  = getItem(position).getDay();
        String type  = getItem(position).getType();
        String  foodname = getItem(position).getFoodName();
        String quantity  = getItem(position).getQuantity();
        String bmi  = getItem(position).getBmi();
        String gender  = getItem(position).getGender();
        LayoutInflater inflater  = LayoutInflater.from(contextfood);

        convertView = inflater.inflate(Resource,parent,false);
        TextView tv1 = (TextView)   convertView.findViewById(R.id.textview1);
        TextView tv2 = (TextView)   convertView.findViewById(R.id.textview2);
        TextView tv3 = (TextView)   convertView.findViewById(R.id.textview3);
        TextView tv4 = (TextView)   convertView.findViewById(R.id.textview4);
        TextView tv5 = (TextView)   convertView.findViewById(R.id.textview5);
        TextView tv6 = (TextView)   convertView.findViewById(R.id.textview6);
        tv1.setText(day);
        tv2.setText(type);
        tv3.setText(foodname);
        tv4.setText(quantity);
        tv5.setText(bmi);
        tv6.setText(gender);

        return  convertView;
    }
}
