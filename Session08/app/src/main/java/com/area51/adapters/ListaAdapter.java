package com.area51.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.area51.session08.R;
import com.area51.utils.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by elder_vasquez on 2/9/15.
 */
public class ListaAdapter extends BaseAdapter {

    protected ImageLoader imageLoader = ImageLoader.getInstance();
    Context context;
    String genero, imgProfile;

    public ListaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Constant.listaPersona.size();
    }

    @Override
    public Object getItem(int position) {
        return Constant.listaPersona.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Constant.listaPersona.get(position).getId();
    }

    static class ViewHolder {
        TextView lblTexts;
        ImageView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.data_itms, parent, false);
            ViewHolder viewHolder = new ViewHolder();

            viewHolder.lblTexts = (TextView) convertView.findViewById(R.id.lblTexts);
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);

            convertView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();

        if (Constant.listaPersona.get(position).getSexo() == 0) {
            genero = "Masculino";
            imgProfile = "http://www.juegos.es/blog/wp-content/uploads/2009/04/totoro.gif";
        } else {
            genero = "Femenino";
            imgProfile = "http://studioghiblimovies.com/wp-content/uploads/2015/01/Baby_Cat_Bus_by_phowks.jpg";
        }

        holder.lblTexts.setText(
                Constant.listaPersona.get(position).getNombres() + "\n" +
                        Constant.listaPersona.get(position).getApellido_paterno() + "\n" +
                        Constant.listaPersona.get(position).getApellido_materno() + "\n" +
                        genero
        );

        imageLoader.displayImage(imgProfile, holder.ivImagen);

        return convertView;
    }
}
