package com.geniusvjr.rapiddevelopmentframework;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geniusvjr.rapiddevelopmentframework.core.BaseListActivity;
import com.geniusvjr.rapiddevelopmentframework.core.BaseViewHolder;

import java.util.ArrayList;


public class SampleListActivity extends BaseListActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ArrayList<String> mDataList = new ArrayList<>();

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_sample_list);
    }

    @Override
    protected int getDataCount() {
        return mDataList.size();
    }


    @Override
    protected void setUpView() {
        super.setUpView();
    }

    @Override
    protected void setUpData() {
        super.setUpData();
        setRefreshing();
    }



    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sample_list_item, parent, false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onRefresh() {
        mDataList.clear();
        for (int i = 0; i < 50; i++) {
            mDataList.add("sample list item " + i);
        }
        adapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }


    class SampleViewHolder extends BaseViewHolder {

        TextView mSampleListItemLabel;

        public SampleViewHolder(View itemView) {
            super(itemView);
            mSampleListItemLabel = (TextView) itemView.findViewById(R.id.mSampleListItemLabel);
        }

        @Override
        public void onBind(int position) {
            mSampleListItemLabel.setText(mDataList.get(position));
        }
    }
}
