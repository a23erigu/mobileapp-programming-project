package com.example.project;

public class Dog {

    String name;
    String color;
    String racialGroup;
    int size;
    int cuteness;
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
                ", racial group='" + racialGroup + '\'' +
                ", size=" + size +
                ", cuteness=" + cuteness +
                ", picture='" + picture + '\'' +
                '}';
    }
}
