package dtc.epam.com.dtc.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.adapter.MenuAdapter;
import dtc.epam.com.dtc.adapter.RecyclerScheduleAdapter;
import dtc.epam.com.dtc.fragment.DestinationFragment;
import dtc.epam.com.dtc.fragment.PassportFragment;
import dtc.epam.com.dtc.fragment.ProfileFragment;
import dtc.epam.com.dtc.utils.CircleMaskedBitmap;
import dtc.epam.com.dtc.utils.EnumMenuItems;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private View mHeaderDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800) // width, height
                .diskCacheExtraOptions(480, 800, null)
                .threadPoolSize(5)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .build();
        ImageLoader.getInstance().init(config);
        Toolbar toolbar = (Toolbar) findViewById(R.id.awesome_toolbar);
        setSupportActionBar(toolbar);
        mTitle = getTitle();
        mHeaderDrawer = View.inflate(this, R.layout.view_header_start, null);
        ImageView header = (ImageView) mHeaderDrawer.findViewById(R.id.icon);
        header.setImageResource(R.drawable.image_background);
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.john_smith);
        icon = CircleMaskedBitmap.getCircleMaskedBitmapUsingShader(icon, 100);
        ImageView iconProfil = (ImageView) mHeaderDrawer.findViewById(R.id.icon_profile);
        iconProfil.setImageBitmap(icon);
        mDrawerTitle = "Menu";
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.addHeaderView(mHeaderDrawer);
        mDrawerList.setHeaderDividersEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        displayView(1);
        final MenuAdapter menuAdapter = new MenuAdapter(this, EnumMenuItems.values());
        mDrawerList.setAdapter(menuAdapter);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                menuAdapter.notifyDataSetChanged();
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(
                AdapterView<?> parent, View view, int position, long id
        ) {
            displayView(position);
        }
    }

    private void displayView(int position) {
        if (position <= EnumMenuItems.values().length) {
            String name = getResources().getString(EnumMenuItems.values()[position - 1].getTitle());
            FragmentTransaction transactionWiki = getSupportFragmentManager().beginTransaction();
            EnumMenuItems item = EnumMenuItems.values()[position - 1];
            switch (item) {
                case Watch_Life:
                    DestinationFragment fragmentPage = new DestinationFragment();
                    transactionWiki.replace(R.id.framemain, fragmentPage);
                    mDrawerLayout.closeDrawer(mDrawerList);
                    break;
                case TV_Schedule:
                    Intent intent = new Intent(this, ScheduleActivity.class);
                    this.startActivity(intent);
                    mDrawerLayout.closeDrawer(mDrawerList);
                    break;
                case Destination_Passport:
                    PassportFragment fragmentPassport = new PassportFragment();
                    transactionWiki.replace(R.id.framemain, fragmentPassport);
                    break;
                case Last_Episodes:
                    break;
                case My_profile:
                    ProfileFragment fragmentProfile = new ProfileFragment();
                    transactionWiki.replace(R.id.framemain, fragmentProfile);
                    break;

                default:
                    mDrawerLayout.closeDrawer(mDrawerList);
                    return;
            }
            transactionWiki.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transactionWiki.commit();
            mTitle = name;
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
