package com.yarbsemaj.drinkap;

/**
 * Created by James on 19/03/2016.
 */


public class Item {
    protected int ID;
    protected String name;
    protected String description;
    protected String imgURl;
    public Item(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgURl(String imgURl) {
        this.imgURl = imgURl;
    }

    public void setID(int ID) {

        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgURl() {
        return imgURl;
    }
}
