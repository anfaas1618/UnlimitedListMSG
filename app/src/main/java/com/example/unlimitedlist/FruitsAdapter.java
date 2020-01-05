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
import java.util.List;

public class FruitsAdapter extends  ArrayAdapter<Fruits>{
    Activity context;
    List<Fruits> fruitsList;
    public FruitsAdapter(Activity context,List<Fruits> fruits)
    {super(context,R.layout.fruit_listview,fruits);
        this.context=context;
        this.fruitsList=fruits;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View myView=inflater.inflate(R.layout.fruit_listview,null,true);
        TextView name=myView.findViewById(R.id.name);
        TextView color=myView.findViewById(R.id.color);
        Fruits fruits=getItem(position);
        name.setText(fruits.getFruit_name());
        color.setText(fruits.getFruit_color());
        return  myView;
    }
}
