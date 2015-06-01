package dtc.epam.com.dtc.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import dtc.epam.com.dtc.R;

/**
 * Created by Yauheni_Meshkin on 5/29/2015.
 */
public class OfferDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.awesome_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
        ratingBar.setRating(4);

        Button btnPlace = (Button) findViewById(R.id.btn_place);
        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfferDetailsActivity.this, PlansActivity.class);
                OfferDetailsActivity.this.startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
