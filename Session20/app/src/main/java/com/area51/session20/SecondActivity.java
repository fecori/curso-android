package com.area51.session20;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.area51.utils.InitViews;

/**
 * Created by macbook on 3/16/15.
 */
public class SecondActivity extends ActionBarActivity {

    public View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        root = findViewById(android.R.id.content).getRootView();
        InitViews.whichClass(this);
    }

}
