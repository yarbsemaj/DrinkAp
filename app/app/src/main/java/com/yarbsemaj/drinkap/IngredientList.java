package com.yarbsemaj.drinkap;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
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
public class IngredientList {
    private static String url = "http://drinkap.yarbsemaj.com/app/view/Ingridient_list.php";
    private JSONArray ingridients = null;
    private ArrayList<Ingredient> ingredientArrayList;
    public IngredientList() {
        ingredientArrayList=new ArrayList<Ingredient>();
    }

    public Ingredient getIngredientById(int id){
        for(int i = 0; i < ingredientArrayList.size(); i++){
            //Log.d("i",new Integer(i).toString());
            if(ingredientArrayList.get(i).getID()== id) return ingredientArrayList.get(i) ;
        }
        return null;
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
                ingridients = json.getJSONArray("ingridient");
                for(int i = 0; i < ingridients.length(); i++){
                    JSONObject ingridient;
                    ingridient = ingridients.getJSONObject(i);
                    int ID = Integer.parseInt(ingridient.getString("Ingredient_ID"));
                    String name = ingridient.getString("Ingredient_Name");
                    String description = ingridient.getString("Ingredient_Description");
                    String image = ingridient.getString("Ingredient_IMG");
                    String measure = ingridient.getString("Ingredient_Measure");
                    Ingredient newIngredient =  new Ingredient(ID, name, description, image, measure);
                    ingredientArrayList.add(newIngredient);

                }
                System.out.print(ingridients.length());
            } catch (JSONException e) {
                e.printStackTrace();
            }



            return null;
        }
    }
}
