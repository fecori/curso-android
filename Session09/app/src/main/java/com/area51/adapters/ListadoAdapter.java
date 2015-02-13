package com.area51.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.area51.models.Persona;
import com.area51.session09.R;
import com.area51.utils.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by elder_vasquez on 2/11/15.
 */
public class ListadoAdapter extends BaseAdapter {

    protected ImageLoader imageLoader = ImageLoader.getInstance();
    Context context;
    ArrayList<Persona> listaPersona;

    public ListadoAdapter(Context context, ArrayList<Persona> listaPersona) {
        this.context = context;
        this.listaPersona = listaPersona;
    }

    @Override
    public int getCount() {
        return Constant.LISTA_PERSONA.size();
    }

    @Override
    public Object getItem(int position) {
        return Constant.LISTA_PERSONA.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Constant.LISTA_PERSONA.get(position).getId();
    }

    static class ViewHolder{
        TextView lblNombre, lblApellidoPaterno, lblApellidoMaterno, lblSexo;
        ImageView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellidoPaterno = (TextView) convertView.findViewById(R.id.lblApellidoPaterno);
            viewHolder.lblApellidoMaterno = (TextView) convertView.findViewById(R.id.lblApellidoMaterno);
            viewHolder.lblSexo = (TextView) convertView.findViewById(R.id.lblSexo);
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);

        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.lblNombre.setText(listaPersona.get(position).getNombre());
        holder.lblApellidoPaterno.setText(listaPersona.get(position).getApellidoPaterno());
        holder.lblApellidoMaterno.setText(listaPersona.get(position).getApellidoMaterno());
        holder.lblSexo.setText(listaPersona.get(position).getSexo());
        imageLoader.displayImage(listaPersona.get(position).getRutaImagen(), holder.ivImagen);

        return convertView;
    }
}
