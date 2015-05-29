package dtc.epam.com.dtc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import dtc.epam.com.dtc.R;

/**
 * Created by Yauheni_Meshkin on 5/27/2015.
 */
public class RecyclerDestinationAdapter extends RecyclerView.Adapter<RecyclerDestinationAdapter.ViewHolder> {

    private static final String TAG = "CustomAdapter";
    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView time;
        private final TextView content;
        private final TextView describe;
        private final TextView state;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            time = (TextView) v.findViewById(R.id.time);
            content = (TextView) v.findViewById(R.id.content);
            describe = (TextView) v.findViewById(R.id.describe);
            state = (TextView) v.findViewById(R.id.state);
        }

        public TextView getTime() {
            return time;
        }

        public TextView getContent() {
            return content;
        }

        public TextView getDescribe() {
            return describe;
        }

        public TextView getState() {
            return state;
        }
    }

    public RecyclerDestinationAdapter(Context context, String[] dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_item_destination, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set." + mDataSet[position]);
        final TextView time = viewHolder.getTime();
        final TextView describe = viewHolder.getDescribe();
        final TextView content = viewHolder.getContent();
        final TextView state = viewHolder.getState();
        time.setText((1 + position) + ":00 AM");
        content.setText(mDataSet[position]);
        describe.setText("SEASON " + (position + 1) + " EPISODE " + (position + 2));
        state.setText("WATCH");
    }


    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
