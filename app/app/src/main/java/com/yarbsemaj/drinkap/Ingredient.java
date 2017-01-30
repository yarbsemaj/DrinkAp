package com.yarbsemaj.drinkap;

import android.util.Log;

/**
 * Created by James on 19/03/2016.
 */
public class Ingredient extends Item {

    private String measure;
    public Ingredient(int ID, String name, String deception, String img, String measure) {
        super();
        super.ID=ID;
        //Log.d("Ingrident_ID", new Integer(ID).toString());
        super.name=name;
        super.description=deception;
        super.imgURl=img;
        this.measure=measure;
        System.out.print(super.name);
    }
    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
