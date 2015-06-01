package dtc.epam.com.dtc.adapter;

import android.app.Service;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dtc.epam.com.dtc.holder.CommonHolder;
import dtc.epam.com.dtc.model.Card;
import dtc.epam.com.dtc.model.CardModel;
import dtc.epam.com.dtc.utils.ReflectUtils;

/**
 * Created by Yauheni_Meshkin on 6/1/2015.
 */
public class PlansAdapter  extends RecyclerView.Adapter<CommonHolder> {

    private List<? extends CardModel> mValuesList;


    public PlansAdapter(List<? extends CardModel> valuesList) {
        super();
        mValuesList = valuesList;
    }

    @Override
    public int getItemViewType(int position) {
        return mValuesList.get(position).getType();
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Card.Type type = Card.Type.values()[viewType];
        View view = View.inflate(parent.getContext(), type.getLayout(), null);
        return ReflectUtils.newInstance(type.getHolderClass(), View.class, view);
    }

    @Override
    public void onBindViewHolder(CommonHolder holder, int position) {
        CardModel cardModel = mValuesList.get(position);
        holder.onBind(cardModel.getModel(), position);
    }

    @Override
    public int getItemCount() {
        return mValuesList.size();
    }

}
