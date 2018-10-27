package com.pandora.n.ejercicionivelacion;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PuntajesActivity extends AppCompatActivity {
    private ArrayList<Puntaje> lista;
    private AdaptadorPuntaje adaptador;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);

        listView = findViewById(R.id.lista);
        lista = PrincipalActivity.puntajes;
        adaptador = new AdaptadorPuntaje(this,R.layout.item_puntaje,lista);
        listView.setAdapter(adaptador);
     }
}
