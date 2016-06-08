package com.geniusvjr.rapiddevelopmentframework.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dream on 16/6/8.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
