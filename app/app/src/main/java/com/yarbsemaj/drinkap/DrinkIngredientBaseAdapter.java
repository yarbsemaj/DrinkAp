package com.yarbsemaj.drinkap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class DrinkIngredientBaseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DrinkIngredient> drinkList;


    public DrinkIngredientBaseAdapter(Context context, ArrayList<DrinkIngredient> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    public int getCount() {
        Log.d("count", String.valueOf(drinkList.size()));
        return drinkList.size();

    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each items referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                gridView = inflater.inflate(R.layout.drink_ingredients_layout, null);
                TextView textView = (TextView) gridView.findViewById(R.id.drinkIngredientName);
                textView.setText(drinkList.get(position).getIngredient().getName());
                TextView amount = (TextView)gridView.findViewById(R.id.amount);
                amount.setText(String.valueOf(drinkList.get(position).getQuanity())+ " "+ drinkList.get(position).getIngredient().getMeasure());
                Log.d("Drink_list_quanity", drinkList.get(position).getIngredient().getName());
                Log.d("Drink_list_quanity", String.valueOf(position));
                ImageView imageView = (ImageView)gridView.findViewById(R.id.drink_image);
                new DownloadImageTask(imageView).execute("http://drinkap.yarbsemaj.com/app/img/ing/"+drinkList.get(position).getIngredient().getImgURl());


            } else {
                gridView = convertView;
            }


        return gridView;
    }
}