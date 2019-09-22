package comd.example.lenovo.day03zuoye2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.bean.FuliBean;

/**
 * Created by lenovo on 2019/9/20.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
   private ArrayList<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
