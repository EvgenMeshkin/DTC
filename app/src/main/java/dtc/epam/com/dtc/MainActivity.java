package dtc.epam.com.dtc;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import dtc.epam.com.dtc.activity.ScheduleActivity;
import dtc.epam.com.dtc.adapter.MenuAdapter;
import dtc.epam.com.dtc.adapter.RecyclerAdapter;
import dtc.epam.com.dtc.fragment.MainPageFragment;
import dtc.epam.com.dtc.utils.CircleMaskedBitmap;
import dtc.epam.com.dtc.utils.EnumMenuItems;


public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private View mHeaderDrawer;
    private boolean mVisible = false;

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

       /* mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this, DATA);
        mRecyclerView.setAdapter(mAdapter);*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
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
                    MainPageFragment fragmentPage = new MainPageFragment();
                    transactionWiki.replace(R.id.framemain, fragmentPage);
                    mVisible = false;
                    mDrawerLayout.closeDrawer(mDrawerList);
                    break;
                case TV_Schedule:
                    Intent intent = new Intent(this, ScheduleActivity.class);
                    this.startActivity(intent);
                    mVisible = false;
                    mDrawerLayout.closeDrawer(mDrawerList);
                    break;
                case Destination_Passport:
                    mVisible = false;
                    break;
                case Last_Episodes:
                    mVisible = true;
                    break;
                case My_profile:
                    mVisible = true;
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
