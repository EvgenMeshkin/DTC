package dtc.epam.com.dtc.fragment;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.adapter.FragmentPagerAdapter;
import dtc.epam.com.dtc.adapter.FragmentPagerMainAdapter;
import dtc.epam.com.dtc.adapter.RecyclerAdapter;
import dtc.epam.com.dtc.adapter.RecyclerMainPageAdapter;
import dtc.epam.com.dtc.utils.Constant;

/**
 * Created by Yauheni_Meshkin on 5/26/2015.
 */
public class MainPageFragment extends Fragment {

    private ViewPager mViewPager;
    private ArrayList<Fragment> mTabs;
    public static final int BIG_CIRCLE_SIZE = 25;
    public static final int SMALL_CIRCLE_SIZE = 15;
    private TextView mTitle;
    private TextView mDescription;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerMainPageAdapter mAdapter;
    private TextView mDescFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View content = inflater.inflate(R.layout.fragment_main_page, null);

        mTabs = new ArrayList<>();
        mTabs.add(new MainSubFragment());
        mTabs.add(new MainSubFragment());
        mTabs.add(new MainSubFragment());
        final ViewGroup includeConteiner = (ViewGroup) content.findViewById(R.id.container);
        mViewPager = (ViewPager) content.findViewById(R.id.viewpagersub);
        mViewPager.setAdapter(new FragmentPagerMainAdapter(getFragmentManager(), mTabs));
        mTitle = (TextView) content.findViewById(R.id.titleText);
        mDescription = (TextView) content.findViewById(R.id.descriptionText);
        mDescFragment = (TextView) content.findViewById(R.id.description);
        mDescFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transactionWiki = getFragmentManager().beginTransaction();
                DescriptionFragment fragmentPage = new DescriptionFragment();
                transactionWiki.replace(R.id.framemainpage, fragmentPage);
                transactionWiki.commit();
                mDescFragment.setVisibility(View.GONE);
            }
        });
        includeConteiner.removeAllViews();
        includeConteiner.addView(getViewCircle(0, BIG_CIRCLE_SIZE, SMALL_CIRCLE_SIZE));

        mRecyclerView = (RecyclerView) content.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerMainPageAdapter(getActivity(), Constant.MAIN_DATA);
        mRecyclerView.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                includeConteiner.removeAllViews();
                includeConteiner.addView(getViewCircle(position, BIG_CIRCLE_SIZE, SMALL_CIRCLE_SIZE));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return content;
    }

    public LinearLayout getViewCircle(int position, int sizeBig, int sizeSmall) {
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(6, 6, 6, 6);
        params.gravity = Gravity.CENTER;
        for (int i = 0; i < mTabs.size(); i++) {
            if (i == position) {
                layout.addView(addCircle(sizeBig, Color.WHITE), params);
            } else {
                layout.addView(addCircle(sizeSmall, Color.GRAY), params);
            }
        }
        mTitle.setText("Elementary");
        mDescription.setText("SEASON " + (position+1) + " EPISODE " + (position + 2));
        return layout;
    }

    public ImageView addCircle(int size, int color) {
        ShapeDrawable biggerCircle = new ShapeDrawable(new OvalShape());
        biggerCircle.setIntrinsicHeight(size);
        biggerCircle.setIntrinsicWidth(size);
        biggerCircle.setBounds(new Rect(0, 0, size, size));
        biggerCircle.getPaint().setColor(color);
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundDrawable(biggerCircle);
        return imageView;
    }

}

