package com.yarbsemaj.drinkap;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by James on 19/03/2016.
 */
public class DrinkList {
    private static String url = "http://drinkap.yarbsemaj.com/app/view/Drink_list.php";
    private JSONArray drinks = null;
    private ArrayList<Drink> drinkList= new ArrayList<Drink>();
    private IngredientList ingredientList;
    public DrinkList(IngredientList ingredientList) {
this.ingredientList=ingredientList;
    }

    public void populate() {
        AsyncTask asyncTask = new PopulateDrinks().execute();
        try {
            asyncTask.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Drink> getDrinkByName(String name){
        ArrayList<Drink> results = new ArrayList<Drink>();
        for(int i =0; i < drinkList.size(); i++){
            if(drinkList.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                results.add(drinkList.get(i));
            }
        }
        return results;
    }

    public ArrayList<Drink> getDrinkList() {
        return drinkList;
    }

    class PopulateDrinks extends AsyncTask<Void, Void, Void> {

        private Context context;


        JSONParser jParser = new JSONParser();
        // url to get all products list


        @Override

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Void doInBackground(Void... args) {
            // getting JSON string from URL
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            JSONObject json = jParser.makeHttpRequest(url, "POST", params);
            try {
                drinks = json.getJSONArray("drink");
                for(int i = 0; i < drinks.length(); i++){
                    ArrayList<DrinkIngredient> ingredientArrayList = new ArrayList<DrinkIngredient>();
                    JSONArray ingredients = null;
                    JSONObject drink;
                    drink = drinks.getJSONObject(i);
                    int ID = Integer.parseInt(drink.getString("Drink_ID"));
                    String name = drink.getString("Drink_Name");
                    String description = drink.getString("Drink_Description");
                    String image = drink.getString("Drink_IMG");
                    String recipe = drink.getString("Drink_Recipe");
                    Double rating = Double.parseDouble(drink.getString("Rating_Mean"));
                    //Log.d("Drink_ID", new Integer(ID).toString());
                    //Log.d("Drink_Name",name);
                    //Log.d("Drink_Description", description);
                    //Log.d("Drink_IMG", image);
                    //Log.d("Drink_Recipe", recipe);
                    List<NameValuePair> drinkIDs = new ArrayList<NameValuePair>();
                    drinkIDs.add(new BasicNameValuePair("Drink_ID", new Integer(ID).toString()));
                    String ingUrl ="http://drinkap.yarbsemaj.com/app/view/DrinkIngredient_list.php";
                    JSONObject ingJson = jParser.makeHttpRequest(ingUrl, "POST", drinkIDs);
                    ingredients = ingJson.getJSONArray("ingredient");
                    for(int j = 0; j < ingredients.length(); j++) {
                        JSONObject ingredient;
                        ingredient = ingredients.getJSONObject(j);
                        int ingredientID = Integer.parseInt(ingredient.getString("Ingredient_ID"));
                        double quanity = Double.parseDouble(ingredient.getString("Quantity"));
                        //Log.d("Ingrident_ID", new Integer(ingredientID).toString());
                        //Log.d("Quanity", new Double(quanity).toString());
                        ingredientArrayList.add(new DrinkIngredient(ingredientID,quanity, ingredientList));
                    }
                    drinkList.add(new Drink(ID,name,description,image,recipe,rating,ingredientArrayList));
                }



                }
             catch (JSONException e) {
                e.printStackTrace();
            }



            return null;
        }
    }
}
