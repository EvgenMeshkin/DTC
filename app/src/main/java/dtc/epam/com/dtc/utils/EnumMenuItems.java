package dtc.epam.com.dtc.utils;


import dtc.epam.com.dtc.R;

/**
 * Created by User on 02.02.2015.
 */
public enum EnumMenuItems {

    Home(R.string.home, R.drawable.ic_title),
    Random(R.string.random, R.drawable.ic_title),
    Nearby(R.string.nearby, R.drawable.ic_title),
    Favourites(R.string.favourites, R.drawable.ic_title),
    Watchlist(R.string.watchlist, R.drawable.ic_title),
    Log_in(R.string.log_in, R.drawable.ic_title);

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