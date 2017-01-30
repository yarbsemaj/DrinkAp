package com.yarbsemaj.drinkap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkDetails extends AppCompatActivity {


    public static Drink drink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_details);




        ImageView imageView = (ImageView)this.findViewById(R.id.imageView);
        new DownloadImageTask(imageView).execute("http://drinkap.yarbsemaj.com/app/img/drink/" + drink.getImgURl());

        TextView name = (TextView)this.findViewById(R.id.drinkName);
        name.setText(drink.getName());

        TextView desctiption = (TextView)this.findViewById(R.id.description);
        desctiption.setText(drink.getDescription());

        TextView recipy = (TextView)this.findViewById(R.id.recipy);
        recipy.setText(drink.getRecipe());

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new DrinkIngredientBaseAdapter(this, drink.getIngridents()));

        for(int i = 0; i < drink.getIngridents().size(); i++){

            Log.d("forloop", drink.getIngridents().get(i).getIngredient().getName());
        }
    }
}
