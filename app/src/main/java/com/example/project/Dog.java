package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Dog {

    String name;
    @SerializedName("company")
    String origin;
    @SerializedName("location")
    String color;
    @SerializedName("category")
    String racialGroup;
    int size;
    @SerializedName("cost")
    int cuteness;
    @SerializedName("auxdata")
    String picture;

    public Dog (String name, String racialGroup){
        this.name = name;
        this.racialGroup = racialGroup;
    }

    public String getName() {
        return name;
    }
    public String getOrigin() {
        return origin;
    }
    public String getColor() {
        return color;
    }
    public String getRacialGroup() {
        return racialGroup;
    }
    public int getSize() {
        return size;
    }
    public int getCuteness() {
        return cuteness;
    }
    public String getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", racialGroup='" + racialGroup + '\'' +
                ", origin='" + origin + '\'' +
                ", size=" + size +
                ", cuteness=" + cuteness +
                ", picture='" + picture + '\'' +
                '}';
    }
}
