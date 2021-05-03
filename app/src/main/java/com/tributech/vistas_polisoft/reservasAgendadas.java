package com.tributech.vistas_polisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import repositories.generica;


public class reservasAgendadas extends AppCompatActivity {
    private ListView listview;
    ArrayList<Reservas> reservas ;
    static public ArrayList<Reservas> reservasUsu = new ArrayList<Reservas>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listview = (ListView) findViewById(R.id.lstReservasAgendadas) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_agendadas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        generica reser = new generica();

        ArrayList<String> datosContacto = new ArrayList<>();

        reser.reservasDeUsuario(3) ;
        int algo = reservasUsu.size();
        for (Reservas res : reservasUsu){
            datosContacto.add(res.getFecha() + res.getMedico());
        }
        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datosContacto ));
        //lstReservasAgendadas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reser));

    }
}