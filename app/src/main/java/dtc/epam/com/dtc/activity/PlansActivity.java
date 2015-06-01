package dtc.epam.com.dtc.activity;

import android.content.ContentValues;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.RatingBar;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.adapter.PlansAdapter;
import dtc.epam.com.dtc.model.Card;
import dtc.epam.com.dtc.model.CardModel;

/**
 * Created by Yauheni_Meshkin on 6/1/2015.
 */
public class PlansActivity extends AppCompatActivity {

    private List<CardModel> mCardList = new CopyOnWriteArrayList<>();
    private PlansAdapter mPlansAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        Toolbar toolbar = (Toolbar) findViewById(R.id.awesome_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mCardList.add(new CardModel(Card.Type.ULTIMATE, "true"));
        mCardList.add(new CardModel(Card.Type.PLATINUM, "true"));
        mCardList.add(new CardModel(Card.Type.GOLD, "true"));

        mPlansAdapter = new PlansAdapter(mCardList);
        mRecyclerView.setAdapter(mPlansAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

