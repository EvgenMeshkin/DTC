package dtc.epam.com.dtc.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.adapter.FragmentPagerAdapter;
import dtc.epam.com.dtc.fragment.ScheduleFragment;
import dtc.epam.com.dtc.view.SlidingTabLayout;

/**
 * Created by Yauheni_Meshkin on 5/28/2015.
 */
public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

