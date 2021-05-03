package com.tributech.vistas_polisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import repositories.generica;

public class registro_usuario extends AppCompatActivity  {

    private Button button;
    private EditText nomtext, apetext, cedtext, dirtext, movtext, teltext, cortext, passtext, pass2text;
    private String nom, ape, ced, dir, mov, tel, cor, pass, pass2;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        button = findViewById(R.id.btnaplicar);
        nomtext = findViewById(R.id.nombre);
        apetext = findViewById(R.id.apellido);
        cedtext = findViewById(R.id.cedula);
        dirtext = findViewById(R.id.direccion);
        movtext = findViewById(R.id.tmovil);
        teltext = findViewById(R.id.telefono);
        cortext = findViewById(R.id.correo);
        passtext = findViewById(R.id.pass1);
        pass2text = findViewById(R.id.pass2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nom = nomtext.getText().toString();
                ape = apetext.getText().toString();
                ced = cedtext.getText().toString();
                dir = dirtext.getText().toString();
                mov = movtext.getText().toString();
                tel = teltext.getText().toString();
                cor = cortext.getText().toString();
                pass = passtext.getText().toString();
                pass2 = pass2text.getText().toString();

                generica userLogin = new generica();
                userLogin.registro(nom, ape, ced, dir, mov, tel, cor, pass, pass2);

                Toast.makeText(registro_usuario.this, generica.msg, Toast.LENGTH_SHORT).show();

                onClickmain();

            }
        });
    }

    public void onClickmain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 0);
    }

}