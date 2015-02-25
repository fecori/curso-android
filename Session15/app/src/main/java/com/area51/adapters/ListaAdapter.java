package com.area51.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.area51.models.Persona;
import com.area51.session15.R;

import java.util.ArrayList;

/**
 * Created by elder_vasquez on 25/02/15.
 */
public class ListaAdapter extends BaseAdapter {

    Context context;
    ArrayList<Persona> listaPersona;

    public ListaAdapter(Context context, ArrayList<Persona> listaPersona) {
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
        TextView lblNombre, lblApellidos, lblGenero;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellidos = (TextView) convertView.findViewById(R.id.lblApellidos);
            viewHolder.lblGenero = (TextView) convertView.findViewById(R.id.lblGenero);
            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.lblNombre.setText(listaPersona.get(position).getNombre());
        viewHolder.lblApellidos.setText(listaPersona.get(position).getApellidos());
        viewHolder.lblGenero.setText(listaPersona.get(position).getGenero());

        return convertView;
    }
}
