package com.ericrgon.quickgrid;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;

public class QuickGridView extends GridView{

    public QuickGridView(Context context) {
        super(context);
    }

    public QuickGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuickGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        if(!(adapter instanceof CategoryAdapter)){
            throw new IllegalArgumentException("Can only accept a Category Adapter");
        }

        super.setAdapter(adapter);
    }

    private CategoryAdapter getCategoryAdapter(){
        return (CategoryAdapter) getAdapter();
    }

    public void smoothScrollToCategory(int category){
        /**
         * Scroll to about the middle of the category to fill the view.
         */
        switch (category){
            case 0:
                smoothScrollToPosition(0);
                break;
            default:
                smoothScrollToPosition( (category * CategoryAdapter.ITEM_NUM) + CategoryAdapter.ITEM_NUM );
                break;
        }
    }
}
