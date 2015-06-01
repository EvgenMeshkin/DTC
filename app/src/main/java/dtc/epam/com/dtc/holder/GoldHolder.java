package dtc.epam.com.dtc.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dtc.epam.com.dtc.R;

/**
 * Created by Yauheni_Meshkin on 6/1/2015.
 */
public class GoldHolder extends CommonHolder<String> {
    private ViewGroup mSelect;
    private ViewGroup mSelectSet;

    public GoldHolder(View itemView) {
        super(itemView);
    }

    @Override
    void onCreate(final View itemView) {
        mSelect = (ViewGroup) itemView.findViewById(R.id.layout_select);
        mSelect.setTag(true);
        mSelectSet = (ViewGroup) itemView.findViewById(R.id.layout_set);
        final ImageView icon = (ImageView) mSelect.findViewById(R.id.date);
        icon.setImageResource(R.mipmap.ic_action_navigation_expand_more_bl);
        mSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectSet.removeAllViews();
                boolean clickDown = (boolean) mSelect.getTag();
                if (clickDown) {
                    icon.setImageResource(R.mipmap.ic_action_navigation_expand_less_bl);
                    mSelectSet.removeAllViews();
                    mSelectSet.addView(View.inflate(itemView.getContext(), R.layout.item_plan_select, null));
                    mSelect.setTag(false);
                } else {
                    mSelectSet.removeAllViews();
                    icon.setImageResource(R.mipmap.ic_action_navigation_expand_more_bl);
                    mSelect.setTag(true);
                }
            }
        });
    }

    @Override
    public void onBind(String item, int position) {

    }
}
