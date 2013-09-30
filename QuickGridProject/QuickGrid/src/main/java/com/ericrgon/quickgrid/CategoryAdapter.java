package com.ericrgon.quickgrid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends ArrayAdapter<String> {

    public static final int CATEGORIES_NUM = 5;
    public static final int ITEM_NUM = 51;

    private LayoutInflater inflater;
    private List<Integer> colors;

    public CategoryAdapter(Context context) {
        super(context, 0);

        inflater = LayoutInflater.from(context);

        colors = new ArrayList<Integer>();
        for(String color : context.getResources().getStringArray(R.array.color)){
            colors.add(Color.parseColor(color));
        }

        //Number of categories.
        for(int i = 0 ; i < CATEGORIES_NUM ; i++){
            //Number of items in each category
            for(int j = 0 ; j < ITEM_NUM ; j++){
                add("Item: " + i + ":" + j);
            }
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItem = inflater.inflate(R.layout.grid_item,parent,false);
        gridItem.setBackgroundColor(colors.get((int) ((position + .5) / ITEM_NUM) % 5));

        TextView text = (TextView) gridItem.findViewById(R.id.text);
        text.setText(getItem(position));
        return gridItem;
    }

    public int getCategorySize(){
        return CATEGORIES_NUM;
    }
}
