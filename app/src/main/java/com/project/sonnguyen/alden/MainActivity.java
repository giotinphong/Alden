package com.project.sonnguyen.alden;


import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.sonnguyen.alden.fragment.ActivitiesFragment;
import com.project.sonnguyen.alden.fragment.GameFragment;
import com.project.sonnguyen.alden.fragment.StudentInforFragment;
import com.project.sonnguyen.alden.fragment.StudentResultFragment;
import com.project.sonnguyen.alden.fragment.StudyContentFragment;
import com.project.sonnguyen.alden.fragment.TabsPagerAdapter;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, GameFragment.OnFragmentInteractionListener
,StudentInforFragment.OnFragmentInteractionListener,ActivitiesFragment.OnFragmentInteractionListener,StudentResultFragment.OnFragmentInteractionListener,
        StudyContentFragment.OnFragmentInteractionListener {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getSupportActionBar();


        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        actionBar.setSelectedNavigationItem(position);
                    }
                });
        TabsPagerAdapter mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        String[] tabsname = new String[]{"Vui học cùng bé","Thông tin cá nhân","Nội dung học","Kết quả học tập","Các hoạt động ngoại khóa"};
        // Adding Tabs
        for (String tab_name : tabsname) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
