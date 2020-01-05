package com.example.unlimitedlist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.util.List;

public class FruitsAdapter extends  ArrayAdapter<Fruits>{
    Activity context;
    List <Fruits> fruitsList;
    public  FruitsAdapter(Activity context,List<Fruits> fruitsList)
    {   super(context,R.layout.fruit_listview,fruitsList);
        this.context=context;
         this.fruitsList=fruitsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View myview = inflater.inflate(R.layout.fruit_listview, null, true);
        TextView  name = myview.findViewById(R.id.name);
        TextView  color = myview.findViewById(R.id.color);
        Fruits fruits=getItem(position);
        name.setText(fruits.getFruit_name());
        color.setText(fruits.getFruit_color());
        return  myview;
    }
}
