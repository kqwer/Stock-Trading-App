package com.example.stocktrade;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements OnStockRefreshListener {

    NseFragment orderedFragment;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        orderedFragment = new NseFragment();
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new BseFragment(), "BSE");
        adapter.AddFragment(orderedFragment, "NSE");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setText("BSE");
        tabLayout.getTabAt(1).setText("NSE");

    }

    public TabLayout getTabLayout() {

        return tabLayout;
    }

    @Override
    public void onRefresh() {

        //orderedFragment.storeData();

    }



}