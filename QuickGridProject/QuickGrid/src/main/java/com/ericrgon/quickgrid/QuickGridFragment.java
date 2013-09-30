package com.ericrgon.quickgrid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuickGridFragment extends Fragment{

    private QuickGridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.quick_grid,container,false);

        gridView = (QuickGridView) view.findViewById(R.id.grid);
        final CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity());
        gridView.setAdapter(categoryAdapter);

        return view;
    }

    public void smoothScrollToCategory(int category){
        gridView.smoothScrollToCategory(category);
    }

}
