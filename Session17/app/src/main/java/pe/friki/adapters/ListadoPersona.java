package pe.friki.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pe.friki.models.Persona;
import pe.friki.session17.R;
import pe.friki.utils.Constant;

/**
 * Created by ios2015 on 3/2/15.
 */
public class ListadoPersona extends BaseAdapter {

    Context context;
    ArrayList<Persona> listaPersona;

    public ListadoPersona(Context context, ArrayList<Persona> listaPersona) {
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

    static class ViewHolder {
        TextView lblNombre, lblApellidoPaterno, lblApellidoMaterno, lblGenero;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellidoPaterno = (TextView) convertView.findViewById(R.id.lblApellidoPaterno);
            viewHolder.lblApellidoMaterno = (TextView) convertView.findViewById(R.id.lblApellidoMaterno);
            viewHolder.lblGenero = (TextView) convertView.findViewById(R.id.lblGenero);
            convertView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.lblNombre.setText(listaPersona.get(position).getNombre());
        holder.lblApellidoPaterno.setText(listaPersona.get(position).getApellidoPaterno());
        holder.lblApellidoMaterno.setText(listaPersona.get(position).getApellidoMaterno());
        holder.lblGenero.setText(listaPersona.get(position).getGenero());
        
        return convertView;
    }
}
