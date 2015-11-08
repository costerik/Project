package com.example.ingerikahumada.etnoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Change the icon
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.logo);
        ab.setTitle("");
        //

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Traductor(), "TRADUCTOR");
        adapter.addFrag(new Traductor(), "HISTORIAL");
        adapter.addFrag(new Traductor(), "COMPARTIR");
        //adapter.addFrag(new DummyFragment(getResources().getColor(R.color.colorPrimary)), "DOG");
        //adapter.addFrag(new DummyFragment(getResources().getColor(R.color.colorPrimaryDark)), "MOUSE");
        viewPager.setAdapter(adapter);
    }
}
