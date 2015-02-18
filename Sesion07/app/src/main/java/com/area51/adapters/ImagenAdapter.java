package com.area51.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.area51.fragment.DetalleFragment;
import com.area51.utils.Constant;

/**
 * Created by macbook on 2/18/15.
 */
public class ImagenAdapter extends FragmentStatePagerAdapter {

    public ImagenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        DetalleFragment fragment = new DetalleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return Constant.LISTA_IMAGENES.size();
    }

}
