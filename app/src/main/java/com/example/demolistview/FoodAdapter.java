package com.example.demolistview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAdapter(Context context, int resource, ArrayList<Food> objects){
        super(context, resource, objects);
        //Store the food that is passed to this adapter
        food = objects;
        //Store Context object as we need use it later
        this.context = context;
    }



    //getView() is the method ListView will call to get view
    //object every time ListView needs a row
    public View getView(int position, View convertView, ViewGroup parent) {

        //Usual way to get LayoutInflater object to "inflate"
        //the XML file into View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

       //"Inflate" the row.xml as layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        //Get the TextView object
        tvFoodName = (TextView) rowView.findViewById(R.id.tvFoodName);

        //Get the Image object
        ivStar = (ImageView) rowView.findViewById(R.id.ivStar);


        //The parameter "position" is the index of row ListView
        //is requesting. We get back the food at same index
        Food currentFood = food.get(position);

        //Set TextView to show food
        tvFoodName.setText(currentFood.getName());

        //Set Image to star or no-star accordingly
        if(currentFood.isStar()) {
            ivStar.setImageResource(R.drawable.star);
        }
        else {
            ivStar.setImageResource(R.drawable.nostar);
        }

        //Return View to ListView
        return rowView;
    }


}
