package dtc.epam.com.dtc.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.activity.DescriptionActivity;

/**
 * Created by Yauheni_Meshkin on 5/28/2015.
 */
public class RecyclerPassportAdapter extends RecyclerView.Adapter<RecyclerPassportAdapter.ViewHolder> {

    private static final String TAG = "CustomAdapter";
    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iconView;
        private final View iconbackground;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                    Intent intent = new Intent(v.getContext(), DescriptionActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
            iconView = (ImageView) v.findViewById(R.id.icon_image);
            iconbackground = v.findViewById(R.id.icon_bacground);
        }

        public ImageView getImageView() {
            return iconView;
        }

        public View getBackground() {
            return iconbackground;
        }
    }

    public RecyclerPassportAdapter(Context contexts, String[] dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_item_passport, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set." + mDataSet[position]);
        final ImageView imageView = viewHolder.getImageView();
        imageView.setImageBitmap(null);
        final String url = mDataSet[position];
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageView.setTag(url);
        imageLoader.displayImage(url, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap bitmap) {
                Log.d(TAG, "Loader Url*** " + url);
                String tag = (String) view.getTag();
                if (tag.contains(url)) {
                    imageView.setImageBitmap(bitmap);
                }
            }


            @Override
            public void onLoadingCancelled(String url, View view) {

            }

        });
    }


    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}