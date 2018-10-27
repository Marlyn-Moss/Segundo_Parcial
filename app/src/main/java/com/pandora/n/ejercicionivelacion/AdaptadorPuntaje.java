package com.pandora.n.ejercicionivelacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPuntaje extends BaseAdapter {
    private Context cntxt;
    private ArrayList<Puntaje> ListaD;
    private int Plantilla;

    public AdaptadorPuntaje(Context context, int Layout, ArrayList<Puntaje> Lista){
        this.cntxt = context;
        this.Plantilla = Layout;
        this.ListaD = Lista;
    }

    @Override
    public int getCount() {
        return this.ListaD.size();
    }

    @Override
    public Object getItem(int i) {
        return this.ListaD.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater adminLayout = (LayoutInflater) this.cntxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = adminLayout.inflate(this.Plantilla, null);
            Puntaje p = this.ListaD.get(i);

            TextView puntaje = view.findViewById(R.id.txtPuntaje);

            puntaje.setText(p.getString());
        }
        return view;
    }
}
