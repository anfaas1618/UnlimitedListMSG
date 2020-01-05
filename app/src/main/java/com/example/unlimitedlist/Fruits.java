package com.example.unlimitedlist;

public class Fruits {

    private    String fruit_name;
 private    String fruit_color;
 private  void Fruis(String fruit_name,String fruit_color)
    {
         this.fruit_name=fruit_name;
         this.fruit_color=fruit_color;
    }
 public    Fruits (String fr,String colo)
    {
        this.fruit_name = fr;
        this.fruit_color = colo;

    }
    public  Fruits(){}

    public String getFruit_name() {
        return fruit_name;
    }

    public void setFruit_name(String fruit_name) {
        this.fruit_name = fruit_name;
    }

    public String getFruit_color() {
        return fruit_color;
    }

    public void setFruit_color(String fruit_color) {
        this.fruit_color = fruit_color;
    }
}
