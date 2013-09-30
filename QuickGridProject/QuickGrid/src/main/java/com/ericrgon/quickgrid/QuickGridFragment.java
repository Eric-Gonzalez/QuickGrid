package com.ericrgon.quickgrid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class QuickGridFragment extends Fragment{

    private LinearLayout naviation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.quick_grid,container,false);

        final QuickGridView gridView = (QuickGridView) view.findViewById(R.id.grid);
        final CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity());
        gridView.setAdapter(categoryAdapter);

        return view;
    }

}
