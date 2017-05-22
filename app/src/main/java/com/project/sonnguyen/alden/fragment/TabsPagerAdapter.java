package com.project.sonnguyen.alden.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



/**
 * Created by son on 5/19/2017.
 */

public class TabsPagerAdapter extends FragmentStatePagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
              //vui hoc cung be
                return new GameFragment();
            case 1:
               //thong tin ca nhan
                return new StudentInforFragment();
            case 2:
                //noi dung hoc
                return new StudyContentFragment();
            case 3:
                //ket qua hoc tap
                return new StudentResultFragment();
            case 4:
                //cac hoat dong khac
                return new ActivitiesFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }

}