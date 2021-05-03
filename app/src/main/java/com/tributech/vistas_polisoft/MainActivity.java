package com.tributech.vistas_polisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import repositories.generica;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText cedtext, passtext;
    private String ced, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //super.onCreate(savedInstanceState);
        //    setContentView(R.layout.activity_registro_usuario);
            button = findViewById(R.id.btnaplicar);
            cedtext = findViewById(R.id.editTextCedula);
            passtext = findViewById(R.id.editTextPassword);

            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ced = cedtext.getText().toString();
                pass = passtext.getText().toString();

                generica userLogin = new generica();
                userLogin.login(ced, pass);

                Toast.makeText(MainActivity.this, generica.msg, Toast.LENGTH_SHORT).show();
                onClicklogin();
            }
        });

    }




    public void onClickregistro(View v) {
        Intent intent = new Intent(this, registro_usuario.class);
        startActivityForResult(intent, 0);
    }

    public void onClicklogin() {
        Intent intent = new Intent(this, Home.class);
        startActivityForResult(intent, 0);
    }

}