package com.tributech.vistas_polisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mayuda:
                //Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                //startActivity(launchIntent);
            //    Intent intent = new Intent(Intent.ACTION_SEND);
             //   intent.setType("text/plain");
              //  intent.setPackage("com.whatsapp");
              //  intent.putExtra(Intent.EXTRA_TEXT, "hola sasuke uchia.");
                try{
                    AbrirWhatsApp();
                    //startActivity(intent);
                }catch (ActivityNotFoundException ex){
                    Toast.makeText(Home.this, "La aplicación Whastapp no se encuentra instalada en el dispositivo.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.meditarPerfil:
                Intent intent = new Intent(this, Usuarios.class);
                startActivityForResult(intent,0);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClickAgenda(View v) {
        Intent intent = new Intent(this, reservasAgendadas.class);
        startActivityForResult(intent, 0);
    }

    public void onClickNueva(View v) {
        Intent intent = new Intent(this, NuevaReserva.class);
        startActivityForResult(intent, 0);
    }

    public void onClickPanico(View v) {
        Intent intent = new Intent(this, Mapa.class);
        startActivityForResult(intent, 0);
    }

    private void AbrirWhatsApp()
    {
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("521" + "099539335")+"@s.whatsapp.net");
        startActivity(_intencion);
    }
}