package com.tributech.vistas_polisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import repositories.generica;

public class NuevaReserva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_reserva);
        // llamar al metodo que trae los arrays
        /*
        try {
            generica filtro = new generica();
            filtro.serviciosFiltro();


            List<String> listist = new ArrayList<String>();

            String res = filtro.serviciosFiltro();
            JSONArray jsonArray = new JSONArray(res);

            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    listist.add("" + jsonArray.get(i));
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            Log.e("", "listist.size() : " + listist.size());

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         */
    }
}