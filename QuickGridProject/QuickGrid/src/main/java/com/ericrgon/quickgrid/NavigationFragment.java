package com.ericrgon.quickgrid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NavigationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_layout,container,false);

        //TODO Replace with a view capable of accepting an adapter.
        LinearLayout naviation = (LinearLayout) view.findViewById(R.id.navigation);
        String[] colors = getResources().getStringArray(R.array.color);
        char start = 'A';
        for(int i = 0 ; i < 5 ; i++){
            TextView item = (TextView) inflater.inflate(R.layout.navigation_item,container,false);
            item.setText(String.valueOf((char) (start + i)) + " More Details");
            item.setBackgroundColor(Color.parseColor(colors[i]));
            final int catNumber = i;
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Scroll to the target category.
//                    gridView.smoothScrollToCategory(catNumber);
                }
            });
            naviation.addView(item);
        }

        return view;
    }

}
