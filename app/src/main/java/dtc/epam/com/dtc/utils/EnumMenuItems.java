package dtc.epam.com.dtc.utils;


import dtc.epam.com.dtc.R;

/**
 * Created by User on 02.02.2015.
 */
public enum EnumMenuItems {

    Watch_Life(R.string.home, R.mipmap.ic_action_hardware_tv),
    TV_Schedule(R.string.random, R.mipmap.ic_action_av_web),
    Destination_Passport(R.string.nearby, R.mipmap.ic_action_device_dvr),
    Last_Episodes(R.string.favourites, R.mipmap.ic_action_maps_local_movies),
    My_profile(R.string.watchlist, R.mipmap.ic_action_social_person_outline);

    private int mTitle;
    private int mIcon;

    EnumMenuItems(int title, int image) {
        mTitle = title;
        mIcon = image;
    }

    public int getTitle() {
        return mTitle;
    }

    public int getIcon() {
        return mIcon;
    }
}