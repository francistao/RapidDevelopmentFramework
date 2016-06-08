package com.geniusvjr.rapiddevelopmentframework.core;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geniusvjr.rapiddevelopmentframework.R;

import java.util.ArrayList;


public abstract class BaseListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected RecyclerView mRecyclerView;
    protected BaseListAdapter adapter;


    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_base_list);
    }

    @Override
    protected void setUpView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    protected void setUpData() {
        mRecyclerView.setLayoutManager(getLayoutManager());
        adapter = new BaseListAdapter();
        mRecyclerView.setAdapter(adapter);
    }

    protected void setRefreshing(){
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }

    protected RecyclerView.LayoutManager getLayoutManager(){
        return new LinearLayoutManager(getApplicationContext());
    };


    public class BaseListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return getViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            holder.onBind(position);
        }

        @Override
        public int getItemCount() {
            return getDataCount();
        }
    }


    protected abstract int getDataCount();


    protected abstract BaseViewHolder getViewHolder(ViewGroup parent, int viewType);
}
