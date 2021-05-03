package com.tributech.vistas_polisoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Mapa extends AppCompatActivity {

    TextView tvMensaje;
    private static final long MIN_TIME = 10000;

    /*Atributos de SMS*/

    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
    private Button btnEnviar;

    /*Teléfono y Texto de SMS*/
    private String NumeroTelefono = "+59899441801";
    private String TextoAlerta = "Raul García ha activado el botón de pánico.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btnEnviar = findViewById(R.id.btnEnviarPanico);


        if (checkPermission(Manifest.permission.SEND_SMS)){
            //btnEnviar.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        tvMensaje = findViewById((R.id.tvMensaje));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},1000);
        } else {
            iniciarLocalizacion();
        }

    }

    private void iniciarLocalizacion(){
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE) ;
        Localizacion local = new Localizacion();
        local.setMainActivity(this ,tvMensaje);
        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(!gpsEnabled){
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},1000);
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,MIN_TIME,0,local);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME,0,local);

        tvMensaje.setText("Localizacion agregada");
    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    public void onSend(View v){
        String phoneNumer = NumeroTelefono;
        String smsMessage = TextoAlerta;

        if (phoneNumer == null || smsMessage == null || phoneNumer.length()==0 || smsMessage.length()==0){
            return;
        }

        if (checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumer,null,smsMessage,null,null);
            Toast.makeText(this,"Mensaje Enviado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Permiso denegado", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRequestPermissionResult(int requestCode, String[] permissions, int[]grantResults){
        if(requestCode == 1000){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                iniciarLocalizacion();
                return;
            }
        }
    }
}