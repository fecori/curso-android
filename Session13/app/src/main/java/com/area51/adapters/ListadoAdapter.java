package com.area51.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.area51.models.Persona;
import com.area51.session13.R;

import java.util.ArrayList;

/**
 * Created by macbook on 2/23/15.
 */
public class ListadoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Persona> listaPersona;

    public ListadoAdapter(Context context, ArrayList<Persona> listaPersona) {
        this.context = context;
        this.listaPersona = listaPersona;

    }

    @Override
    public int getCount() {
        return listaPersona.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPersona.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaPersona.get(position).getId();
    }

    static class ViewHolder {
        TextView lblNombre, lblApellidoPaterno, lblApellidoMaterno;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombres);
            viewHolder.lblApellidoPaterno = (TextView) convertView.findViewById(R.id.lblApellidoPaterno);
            viewHolder.lblApellidoMaterno = (TextView) convertView.findViewById(R.id.lblApellidoMaterno);
            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (viewHolder) = (ViewHolder) convertView.getTag();
        viewHolder.lblNombre.setText(listaPersona.get(position).getNombre());
        viewHolder.lblApellidoPaterno.setText(listaPersona.get(position).getApellidoPaterno());
        viewHolder.lblApellidoMaterno.setText(listaPersona.get(position).getApellidoMaterno());
        return convertView;
    }

}
