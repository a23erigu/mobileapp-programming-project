package com.example.project;

public class Dog {

    String name;
    String color;
    String rasgrupp;
    int size;
    int cutenes;
    String picture;

    public Dog (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public String getRasgrupp() {
        return rasgrupp;
    }
    public int getSize() {
        return size;
    }
    public int getCutenes() {
        return cutenes;
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
                ", rasgrupp='" + rasgrupp + '\'' +
                ", size=" + size +
                ", cutenes=" + cutenes +
                ", picture='" + picture + '\'' +
                '}';
    }
}
