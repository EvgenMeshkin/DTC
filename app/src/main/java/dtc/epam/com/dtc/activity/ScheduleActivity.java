package dtc.epam.com.dtc.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;
import java.util.List;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.adapter.FragmentPagerAdapter;
import dtc.epam.com.dtc.adapter.RecyclerAdapter;
import dtc.epam.com.dtc.fragment.ScheduleFragment;
import dtc.epam.com.dtc.utils.Constant;

/**
 * Created by Yauheni_Meshkin on 5/26/2015.
 */
public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    private ViewPager mViewPager;
    private FragmentTabHost mTabHost;
    private TabWidget mTabWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

       /* mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this, Constant.DATA);
        mRecyclerView.setAdapter(mAdapter);*/
        mTabWidget = (TabWidget) findViewById(android.R.id.tabs);
        mTabWidget.setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

        mTabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setStripEnabled(false);
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("11 FEB"),
                ScheduleFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("12 FEB"),
                ScheduleFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("13 FEB"),
                ScheduleFragment.class, null);

       /* List<Fragment> mTabs = new ArrayList<>();
        mTabs.add(new ScheduleFragment());
        mTabs.add(new ScheduleFragment());
        mTabs.add(new ScheduleFragment());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()));*/
//        setContentView(mViewPager);
    }



}
