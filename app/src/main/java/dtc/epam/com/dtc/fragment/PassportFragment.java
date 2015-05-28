package dtc.epam.com.dtc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.adapter.RecyclerAdapter;
import dtc.epam.com.dtc.adapter.RecyclerPassportAdapter;
import dtc.epam.com.dtc.utils.Constant;

/**
 * Created by Yauheni_Meshkin on 5/28/2015.
 */
public class PassportFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private RecyclerPassportAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View content = inflater.inflate(R.layout.fragment_passport, null);
        mRecyclerView = (RecyclerView) content.findViewById(R.id.recyclerView);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        // specify an adapter (see also next example)
        mAdapter = new RecyclerPassportAdapter(getActivity(), Constant.DATA);
        mRecyclerView.setAdapter(mAdapter);
        return content;
    }
}

