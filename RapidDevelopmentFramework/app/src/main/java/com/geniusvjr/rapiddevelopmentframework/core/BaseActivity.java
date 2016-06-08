package com.geniusvjr.rapiddevelopmentframework.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dream on 16/6/8.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpContentView();
        setUpView();
        setUpData();
    }

    protected abstract void setUpData();

    protected abstract void setUpView();

    protected abstract void setUpContentView();

}
