package com.project.sonnguyen.alden;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.FirebaseDatabase;
import com.project.sonnguyen.alden.fragment.ActivitiesFragment;
import com.project.sonnguyen.alden.fragment.GameFragment;
import com.project.sonnguyen.alden.fragment.StudentInforFragment;
import com.project.sonnguyen.alden.fragment.StudentResultFragment;
import com.project.sonnguyen.alden.fragment.StudyContentFragment;
import com.project.sonnguyen.alden.fragment.TabsPagerAdapter;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, GameFragment.OnFragmentInteractionListener
,StudentInforFragment.OnFragmentInteractionListener,ActivitiesFragment.OnFragmentInteractionListener,StudentResultFragment.OnFragmentInteractionListener,
        StudyContentFragment.OnFragmentInteractionListener {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final ActionBar actionBar = getSupportActionBar();
        //admin sdk for firebase
//        FileInputStream serviceAccount = null;
//        try {
//            AssetManager am = getApplicationContext().getAssets();
////            AssetFileDescriptor fileDescriptor = am.openFd("file:///android_asset/alden-dfe14bcc3adc.json");
////            FileDescriptor fileDescriptors = fileDescriptor.getFileDescriptor();
//            Uri uri = Uri.parse("/app/src/main/assetsAlden-dfe14bcc3adc.json");
//            File file = new File(uri.getPath());
//            serviceAccount = new FileInputStream(file);
//            //serviceAccount = fileDescriptor.createInputStream();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        FirebaseOptions options = null;
//        try {
//            options = new FirebaseOptions.Builder()
//                    .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
//                    .setDatabaseUrl("https://alden-f72d4.firebaseio.com")
//                    .build();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        FirebaseApp.initializeApp(options);

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
