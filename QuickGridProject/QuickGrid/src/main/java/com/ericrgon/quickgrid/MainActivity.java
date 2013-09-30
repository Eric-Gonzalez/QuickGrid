package com.ericrgon.quickgrid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

    SlidingPaneLayout slidingPaneLayout;
    NavigationFragment navigationFragment;
    QuickGridFragment quickGridFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.slidingPane);

        FragmentManager fragmentManager = getSupportFragmentManager();
        quickGridFragment = (QuickGridFragment) fragmentManager.findFragmentById(R.id.grid);
        navigationFragment = (NavigationFragment) fragmentManager.findFragmentById(R.id.navigation);
        navigationFragment.setCategoryListener(new NavigationFragment.CategoryListener() {
            @Override
            public void onCategoryClicked(int category) {
                quickGridFragment.smoothScrollToCategory(category);
                if(slidingPaneLayout.isOpen()){
                    slidingPaneLayout.closePane();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
