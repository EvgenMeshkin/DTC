package dtc.epam.com.dtc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import dtc.epam.com.dtc.fragment.ScheduleFragment;

/**
 * Created by Yauheni_Meshkin on 5/26/2015.
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mTabs;
    private static final int NUM_PAGES = 5;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabs = mTabs;
    }

    @Override
    public Fragment getItem(int i) {
        return new ScheduleFragment();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab: " + position;
    }
    // END_INCLUDE (pageradapter_getpagetitle)

}


