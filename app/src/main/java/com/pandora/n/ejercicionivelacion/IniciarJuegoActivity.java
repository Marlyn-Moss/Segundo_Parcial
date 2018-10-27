package com.pandora.n.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IniciarJuegoActivity extends AppCompatActivity {
    private int puntaje;
    private int ganados;
    private int empatados;
    private int perdidos;
    private TextView txtJugador;
    private TextView txtGanados;
    private TextView txtPerdidos;
    private TextView txtEmpatados;
    private TextView txtPuntaje;
    private String[] seleccion;
    private Button btnCPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_juego);
        puntaje=0;
        ganados=0;
        empatados=0;
        perdidos=0;
        seleccion = new String[]{"O","X","[  ]"};
        txtJugador = findViewById(R.id.txtJugador);
        txtGanados = findViewById(R.id.txtGanados);
        txtPerdidos = findViewById(R.id.txtPerdidos);
        txtEmpatados = findViewById(R.id.txtEmpatados);
        txtPuntaje = findViewById(R.id.txtPuntaje);
        btnCPU = findViewById(R.id.btnCpu);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(getIntent().getExtras()!=null){
            String nombre;
            Bundle bund = getIntent().getExtras();
            nombre = bund.getString("Nombre");
            txtJugador.setText(nombre);
        }
    }

    public void onClick(View view){
        int eleccionC = ((int) (Math.random() * 3)) + 1;
        int eleccionJ = 0;
        if(view.getId() == R.id.btnPiedra){
            eleccionJ=1;
        }else if (view.getId() == R.id.btnTijera){
            eleccionJ=2;
        }else if(view.getId() == R.id.btnPapel){
            eleccionJ=3;
        }
        btnCPU.setText(seleccion[eleccionC-1]);

        // 0 = empate ; 1 = Gana Jugador ; 2 = Gana CPU ;
        int juego=0;
        if(eleccionJ==1){
            if(eleccionC==2) juego=1;
            else if(eleccionC==3) juego=2;
            else if(eleccionC==1) juego=0;
        }
        if(eleccionJ==2){
            if(eleccionC==3) juego=1;
            else if(eleccionC==1) juego=2;
            else if(eleccionC==2) juego=0;
        }
        if(eleccionJ==3){
            if(eleccionC==1) juego=1;
            else if(eleccionC==2) juego=2;
            else if(eleccionC==3) juego=0;
        }

        if(juego==0){
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
            empatados++;
        }else if(juego==1){
            puntaje +=6;
            Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
            ganados++;
        }else if(juego==2){
            puntaje -=3;
            Toast.makeText(this, "Perdiste", Toast.LENGTH_SHORT).show();
            perdidos++;
        }
        txtPuntaje.setText("Puntos: "+puntaje);
        txtGanados.setText("Ganados: "+ganados);
        txtPerdidos.setText("Perdidos: "+perdidos);
        txtEmpatados.setText("Empatados: "+empatados);
    }

    public void onClickFinalizar(View view){
        Intent retornarDatos = new Intent(this,PrincipalActivity.class);
        retornarDatos.putExtra("puntaje",puntaje);
        setResult(RESULT_OK,retornarDatos);
        finish();
    }
}
