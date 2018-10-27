package com.pandora.n.ejercicionivelacion;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {
    public String Jugador;
    public static ArrayList<Puntaje> puntajes;
    private boolean valido = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Jugador = null;
        puntajes = new ArrayList<Puntaje>();
        puntajes.add(new Puntaje("-----",0));
        puntajes.add(new Puntaje("-----",0));
        puntajes.add(new Puntaje("-----",0));
    }

    public void onClickNuevo(View view){
        Intent nuevo = new Intent(this,NuevoJugadorActivity.class);
        startActivityForResult(nuevo,1);
    }

    public void onClickJugar(View view){
        if(valido){
            Intent juego = new Intent(this,IniciarJuegoActivity.class);
            juego.putExtra("Nombre",Jugador);
            startActivityForResult(juego,2);
        }else {
            Toast.makeText(this,"Agrege un Jugador",Toast.LENGTH_LONG).show();
        }
    }

    public void onClicPuntajes(View view){
        if(valido){
            Intent puntaje = new Intent(this,PuntajesActivity.class);
            startActivity(puntaje);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Jugador = data.getStringExtra("Nombre");
                Toast.makeText(this,"Jugador Guardado",Toast.LENGTH_LONG).show();
                valido=true;
            }
        }
        if (requestCode == 2){
            if (resultCode == RESULT_OK) {
                int pun = data.getIntExtra("puntaje",0);
                if(puntajes.get(2).puntaje<pun){
                    puntajes.set(2, new Puntaje(Jugador,pun));
                    if (puntajes.get(1).puntaje<pun){
                        Puntaje aux = puntajes.get(1);
                        puntajes.set(1,new Puntaje(Jugador,pun));
                        puntajes.set(2,aux);
                        if(puntajes.get(0).puntaje<pun){
                            Puntaje aux2 = puntajes.get(0);
                            puntajes.set(0,new Puntaje(Jugador,pun));
                            puntajes.set(1,aux2);
                        }
                    }
                }
            }
        }
    }
}
