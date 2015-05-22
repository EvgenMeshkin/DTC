package dtc.epam.com.dtc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import dtc.epam.com.dtc.adapter.RecyclerAdapter;


public class MainActivity extends ActionBarActivity {

    public static final String[] DATA = {"http://kstc45.com/images/middle.jpg",
            "http://www.ketnet.be/sites/default/files/imagecache/zones_oneblock/image/article/pieterKonijnThumb.jpg",
            "http://www.disneyfan.nl/images/A-Kind-of-Magic.jpg",
            "http://images.bwwstatic.com/tvshowlogos/E1460F0F-CB93-C2B6-06EB3F6DCEEA9DF5.jpg",
            "http://www.televizier.nl/Uploads/Cache/programs/9/b/2/150301021240.9b2af309035c7064a74870fbba525af482c09a79.shrinkcentercrop.625x264.jpg",
            "http://assets.www.npo.nl/uploads/media_item/media_item/75/17/ali_b_op_volle_toeren_carousel_missed-1418379515.jpg",
            "http://1.bp.blogspot.com/_mWVTuH-K-n0/TSXwG02_wSI/AAAAAAAAADE/ogGrhtcgouE/s1600/Strike+Back+%2528BBCGermany+06.01.11%2529.jpg",
            "http://www.ridetech.com/info/wp-content/uploads/2012/09/cast-of-fast-n-loud-3.jpg",
            "http://images.poms.omroep.nl/image/s564/c564x315/551503.png"};
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this, DATA);
        mRecyclerView.setAdapter(mAdapter);
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
}
