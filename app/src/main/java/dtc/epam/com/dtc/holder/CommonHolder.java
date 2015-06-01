package dtc.epam.com.dtc.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class CommonHolder<T> extends RecyclerView.ViewHolder {

    public CommonHolder(View itemView) {
        super(itemView);
        onCreate(itemView);
    }

    abstract void onCreate(View itemView);

    public abstract void onBind(T item, int position);



}
