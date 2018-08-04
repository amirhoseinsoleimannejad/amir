package com.example.jalil.tabliout;

import android.app.Fragment;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
public class HitosViewPagerAdapter extends FragmentPagerAdapter {

    public HitosViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position){

        switch (position){
            case 0: return HitosFragment1.newInstance();
            case 1: return HitosFragment2.newInstance();
            default: return HitosFragment1.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "برگه اول";
            case 1: return "برگه دوم";
            default: return "";
        }
    }
}