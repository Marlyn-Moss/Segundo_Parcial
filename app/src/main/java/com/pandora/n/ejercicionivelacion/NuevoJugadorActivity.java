package com.pandora.n.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Principal;

public class NuevoJugadorActivity extends AppCompatActivity {
    private TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);

        txtNombre = findViewById(R.id.txtNombre);
    }

    public void onClick(View view) {
        if (txtNombre.getText().length() != 0){
            Intent retornarDatos = new Intent(this,PrincipalActivity.class);
            retornarDatos.putExtra("Nombre",this.txtNombre.getText().toString());
            setResult(RESULT_OK,retornarDatos);
            finish();
        }else{
            Toast.makeText(this,"Nombre Vacio",Toast.LENGTH_SHORT).show();
        }
    }
}
