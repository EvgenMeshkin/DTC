package dtc.epam.com.dtc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import dtc.epam.com.dtc.R;

/**
 * Created by Yauheni_Meshkin on 5/22/2015.
 */
public class RecyclerScheduleAdapter extends RecyclerView.Adapter<RecyclerScheduleAdapter.ViewHolder> {

    private static final String TAG = "CustomAdapter";
    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iconView;
        private final View iconbackground;

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
            iconbackground = v.findViewById(R.id.icon_bacground);
        }

        public ImageView getImageView() {
            return iconView;
        }

        public View getBackground() {
            return iconbackground;
        }
    }

    public RecyclerScheduleAdapter(Context contexts, String[] dataSet) {
        mDataSet = dataSet;
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
        final ImageView imageView = viewHolder.getImageView();
        imageView.setImageBitmap(null);
        final View viewBackground = viewHolder.getBackground();
        viewBackground.setBackground(null);
        final String url = mDataSet[position];

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(imageView.getContext()));
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .cacheInMemory()
                .cacheOnDisc()
                .build();

        imageView.setTag(url);
        imageLoader.displayImage(url, imageView, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap bitmap) {
                Log.d(TAG, "Loader Url*** " + url);
                Palette palette = Palette.generate(bitmap);
                Palette.Swatch swatch = palette.getMutedSwatch();
                int rgbColor = swatch.getRgb();

                GradientDrawable gd = new GradientDrawable(
                        GradientDrawable.Orientation.BOTTOM_TOP,
                        new int[]{rgbColor, Color.TRANSPARENT});
                gd.setCornerRadius(0f);
                String tag = (String) view.getTag();
                if (tag.contains(url)) {
                    viewBackground.setBackgroundDrawable(gd);
                    viewBackground.setAlpha(0.6f);
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

