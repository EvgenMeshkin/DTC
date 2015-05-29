package dtc.epam.com.dtc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import dtc.epam.com.dtc.fragment.ScheduleFragment;

/**
 * Created by Yauheni_Meshkin on 5/27/2015.
 */
public class FragmentPagerDestinationAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mTabs;

    public FragmentPagerDestinationAdapter(FragmentManager fm, List<Fragment> mTabs) {
        super(fm);
        this.mTabs = mTabs;
    }

    @Override
    public Fragment getItem(int i) {
        return mTabs.get(i);
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + position;
    }

}
