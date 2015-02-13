package com.area51.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.area51.models.Imagen;
import com.area51.session09.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elder_vasquez on 2/13/15.
 */
public class GrillaAdapter extends ArrayAdapter<Imagen> {

    protected ImageLoader imageLoader = ImageLoader.getInstance();
    Context context;
    ArrayList<Imagen> listaImagenes;

    public GrillaAdapter(Context context, int resource, ArrayList<Imagen> objects) {
        super(context, resource, objects);
        this.context = context;
        this.listaImagenes = objects;
    }

    static class ViewHolder {
        ImageView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        imageLoader.displayImage(listaImagenes.get(position).getRutaImage(), holder.ivImagen);
        return convertView;
    }
}
