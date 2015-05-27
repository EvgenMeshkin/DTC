package dtc.epam.com.dtc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dtc.epam.com.dtc.R;

/**
 * Created by Yauheni_Meshkin on 5/27/2015.
 */
public class MainSubFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View content = inflater.inflate(R.layout.fragment_main_sub, null);

        return content;
    }

}
