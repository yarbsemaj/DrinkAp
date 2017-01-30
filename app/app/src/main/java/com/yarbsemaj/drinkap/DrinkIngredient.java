package com.yarbsemaj.drinkap;

import android.util.Log;

/**
 * Created by James on 19/03/2016.
 */
public class DrinkIngredient {

    private Ingredient ingredient;
    private double quanity;
    public DrinkIngredient(int ID, double quanity, IngredientList ingredientList) {
        ingredient = ingredientList.getIngredientById(ID);
        this.quanity=quanity;
        Log.d("Ingredient_Name",  ingredient.getName());
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuanity() {
        return quanity;
    }

    public void setQuanity(double quanity) {
        this.quanity = quanity;
    }
}
