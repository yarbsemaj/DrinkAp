package com.yarbsemaj.drinkap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class DrinkListGUI extends AppCompatActivity {
    GridView gridView;
    IngredientList ingredientList;
    DrinkList drinkList;
    TextView textView;
    Context context;

    public DrinkListGUI(){
        ingredientList =new IngredientList();
        ingredientList.populate();
        drinkList = new DrinkList(ingredientList);
        drinkList.populate();
        context=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_list);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("!st");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName("2nd");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("3rd")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        return true;
                    }
                })
                .build();
       // getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //result.withActionBarDrawerToggle(true);
        //result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
        gridView = (GridView) findViewById(R.id.listView1);
        gridView.setAdapter(new DrinkListBaseAdapter(this, drinkList.getDrinkList()));
        textView = (TextView)findViewById(R.id.editText);

        textView.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0){
                    gridView.setAdapter(new DrinkListBaseAdapter(context, drinkList.getDrinkByName(s.toString())));
                }

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Drink tapedDrink= (Drink) (gridView.getItemAtPosition(position));
                DrinkDetails.drink=tapedDrink;
                Intent intent = new Intent(DrinkListGUI.this, DrinkDetails.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drink_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
