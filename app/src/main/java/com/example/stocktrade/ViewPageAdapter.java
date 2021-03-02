package com.example.stocktrade;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragment1=new ArrayList<>();
    private  final List<String> title=new ArrayList<>();

    public ViewPageAdapter(@NonNull FragmentManager fm) {

        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragment1.get(position);
    }

    @Override
    public int getCount() {

        return title.size();
    }
    public void AddFragment(Fragment fragment, String titles){
        fragment1.add(fragment);
        title.add(titles);
    }

}
