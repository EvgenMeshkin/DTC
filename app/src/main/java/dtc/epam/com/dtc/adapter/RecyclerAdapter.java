package dtc.epam.com.dtc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dtc.epam.com.dtc.R;

/**
 * Created by Yauheni_Meshkin on 5/22/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    private final Context mContext;

    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iconView;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            iconView = (ImageView) v.findViewById(R.id.icon_image);
        }

        public ImageView getImageView() {
            return iconView;
        }
    }

    public RecyclerAdapter(Context contexts, String[] dataSet) {
        mDataSet = dataSet;
        mContext = contexts;
    }

     @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_item_recycler, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set." + mDataSet[position]);

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        ImageView imageView = viewHolder.getImageView();
        Picasso.with(mContext).load(mDataSet[position]).into(imageView);
//        viewHolder.getImageView().setImageResource(R.drawable.ic_title);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}

