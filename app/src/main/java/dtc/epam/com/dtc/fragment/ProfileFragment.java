package dtc.epam.com.dtc.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dtc.epam.com.dtc.R;

/**
 * Created by Yauheni_Meshkin on 5/28/2015.
 */
public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View content = inflater.inflate(R.layout.fragment_profile, null);

        ViewGroup memberShipMain = (ViewGroup) content.findViewById(R.id.membership);
        View rowView = View.inflate(getActivity(), R.layout.item_membership, null);
        setContentView("Membership Billing", memberShipMain, rowView);

        ViewGroup plan = (ViewGroup) content.findViewById(R.id.plan);
        View rowViewPlan = View.inflate(getActivity(), R.layout.item_plan, null);
        setContentView("Plan Details and Purchases", plan, rowViewPlan);

        plan = (ViewGroup) content.findViewById(R.id.profile);
        rowViewPlan = View.inflate(getActivity(), R.layout.item_profile, null);
        setContentView("My Profile", plan, rowViewPlan);

        plan = (ViewGroup) content.findViewById(R.id.gifts);
        rowViewPlan = View.inflate(getActivity(), R.layout.item_gifts, null);
        setContentView("Gifts and Offers", plan, rowViewPlan);

        return content;
    }

    private void setContentView (String title, ViewGroup content, final View viewInclude) {
        final ViewGroup memberShip = (ViewGroup) content.findViewById(R.id.btn_show_more);
        memberShip.setTag(true);
        final ViewGroup containerInclude = (ViewGroup) content.findViewById(R.id.container_include);
        final ImageView icon = (ImageView) content.findViewById(R.id.icon);
        icon.setImageResource(R.mipmap.ic_action_navigation_expand_more);
        final TextView textMore = (TextView) content.findViewById(R.id.show_more);
        textMore.setText(title);
        memberShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                containerInclude.removeAllViews();
                boolean clickDown = (boolean) memberShip.getTag();
                if (clickDown) {
                    icon.setImageResource(R.mipmap.ic_action_navigation_expand_less);
                    textMore.setTextColor(Color.GREEN);
                    containerInclude.removeAllViews();
                    containerInclude.addView(viewInclude);
                    memberShip.setTag(false);
                } else {
                    containerInclude.removeAllViews();
                    icon.setImageResource(R.mipmap.ic_action_navigation_expand_more);
                    textMore.setTextColor(Color.WHITE);
                    memberShip.setTag(true);
                }
            }
        });
    }

}
