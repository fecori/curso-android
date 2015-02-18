package com.area51.sesion07;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.area51.adapters.ImagenAdapter;

/**
 * Created by macbook on 2/18/15.
 */
public class ImagenActivity extends FragmentActivity {

    ViewPager viewpager;
    ImagenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        int id_imagen = bundle.getInt("KEY");
        adapter = new ImagenAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(id_imagen);
    }
}
