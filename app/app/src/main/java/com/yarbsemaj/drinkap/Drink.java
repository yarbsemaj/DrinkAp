package com.yarbsemaj.drinkap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by James on 19/03/2016.
 */
public class Drink extends Item implements Serializable {
    private String recipe;
    private Double rating;
    private ArrayList<DrinkIngredient> ingridents;
    public Drink(int ID, String name, String deception, String img, String recipe, Double rating, ArrayList<DrinkIngredient> ingredients){
        super();
        super.ID=ID;
        super.name=name;
        super.description=deception;
        super.imgURl=img;
        this.recipe =recipe;
        this.rating = rating;
        this.ingridents = ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public ArrayList<DrinkIngredient> getIngridents() {
        return ingridents;
    }

    public void addIngridents(DrinkIngredient ingridient)
    {
        ingridents.add(ingridient);
    }
}
