package com.yarbsemaj.drinkap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class DrinkListBaseAdapter extends BaseAdapter {
    private Context context;
    private Serializable mThumbIds ;
    private ArrayList<Drink> drinkList;
    private String img_url;
    int item_id;

    public DrinkListBaseAdapter(Context context,ArrayList<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    public int getCount() {
        return drinkList.size();
    }

    public Object getItem(int position) {
        return drinkList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each items referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                gridView = new View(context);
                gridView = inflater.inflate(R.layout.drink_layout, null);
                TextView textView = (TextView) gridView.findViewById(R.id.textView1);
                textView.setText(drinkList.get(position).getName());
                Log.d("Base", drinkList.get(position).getName());
                Log.d("Base_Pos",new Integer(position).toString());
                RatingBar rating = (RatingBar)gridView.findViewById(R.id.ratingBar);
                rating.setRating(new Float(drinkList.get(position).getRating()));

                ImageView imageView = (ImageView)gridView.findViewById(R.id.drink_image);
                new DownloadImageTask(imageView).execute("http://drinkap.yarbsemaj.com/app/img/drink/"+drinkList.get(position).getImgURl());


            } else {
                gridView = convertView;
            }


        return gridView;
    }
}