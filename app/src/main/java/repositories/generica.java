package repositories;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.tributech.vistas_polisoft.Reservas;
import com.tributech.vistas_polisoft.cliente.ClienteHttp;
import com.tributech.vistas_polisoft.domain.Usuarios;
import com.tributech.vistas_polisoft.reservasAgendadas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Iterator;

import okhttp3.OkHttpClient;
import okhttp3.Request;


    public class generica extends AppCompatActivity {
        private ClienteHttp client;
        public static String msg = "";

        public void login(String dni, String pass) {
            String url_login = "appiniciarsesion";
            Request req = client.loginApi(url_login, dni, pass);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    //Toast.makeText(UsuarioRepository.this, "error", Toast.LENGTH_LONG).show();
                    msg = e.toString();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());

                        int id  = Integer.parseInt(objeto.getString("id"));
                        String nom = objeto.getString("username");
                        String ape = objeto.getString("lastname");
                        String dni = objeto.getString("dni");
                        String addr = objeto.getString("address");
                        String movil = objeto.getString("movilphone");
                        String tel = objeto.getString("phone");
                        String email = objeto.getString("email");

                        Usuarios user = new Usuarios(id, nom, ape, dni, addr, movil, tel, email);


                        msg = user.getUsername() + " celular: "+user.getMovilphone();
                    } catch (JSONException e) {
                        //e.printStackTrace();
                        msg =  e.getMessage();
                    }
                }
            });
        }

        public void registro(String nom, String ap, String dni, String addr, String movil,
                             String tel, String email, String pass, String confpass){
            String url_registro = "appregistro";
            Request req = client.registroApi(url_registro, nom, ap, dni, addr, movil, tel, email, pass, confpass);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());

                        msg = objeto.getString("mensaje");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public void serviciosFiltro(){
            String url_registro = "appfiltroServicios";
            Request req = client.filtros(url_registro);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());
                        JSONArray array = new JSONArray(objeto.getString("json"));
                        msg = "";
                        for(int i = 0; i < array.length(); i++){
                            JSONObject dataObject = new JSONObject(array.getString(i));
                            if(dataObject.keys().next().equals("esp")){
                                msg = msg + dataObject.getString("esp");
                            }
                        }
                    } catch (JSONException e) {
                        msg = e.getMessage();
                    }
                }
            });
        }
/* oringinal
        public void serviciosFiltro(){
            String url_registro = "appfiltroServicios";
            Request req = client.filtros(url_registro);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());
                        JSONArray array = new JSONArray(objeto.getString("json"));
                        msg = "";
                        for(int i = 0; i < array.length(); i++){
                            JSONObject dataObject = new JSONObject(array.getString(i));
                            if(dataObject.keys().next().equals("esp")){
                                msg = msg + dataObject.getString("esp");
                            }
                        }
                    } catch (JSONException e) {
                        msg = e.getMessage();
                    }
                }
            });
        }
*/
        public void FiltroResult(String nomProf, String nomPoli, String nomEpec){
            String url_registro = "appResultServicios";
            Request req = client.resultadoServ(url_registro, nomProf, nomPoli, nomEpec);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());
                        JSONArray array = new JSONArray(objeto.getString("json"));
                        msg = "";
                        for(int i = 0; i < array.length(); i++){
                            JSONObject dataObject = new JSONObject(array.getString(i));
                            //if(dataObject.keys().next().equals("polic")){
                            msg = msg + dataObject.getString("polic");
                            //}
                        }
                    } catch (JSONException e) {
                        msg = e.getMessage();
                    }
                }
            });
        }

        public void reserva_atencion(int idUsuario, int idServicio){
            String url_registro = "appReservas";
            Request req = client.reservar(url_registro, idUsuario, idServicio);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());

                        msg = objeto.getString("msg");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public void reservasDeUsuario(int user_id){
            String url_registro = "appReservasUsuario";
            Request req = client.reservasUser(url_registro, user_id);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());
                        JSONArray array = new JSONArray(objeto.getString("json"));
                        msg = "";
                        for(int i = 0; i < array.length(); i++){

                            JSONObject dataObject = new JSONObject(array.getString(i));
                            //if(dataObject.keys().next().equals("polic")){
                            Reservas reservaUsu = new Reservas(dataObject.getString("doc"), dataObject.getString("fec"),dataObject.getString("id"),dataObject.getString("numturnos"),dataObject.getString("poli"));
                            reservasAgendadas.reservasUsu.add(reservaUsu);
                            msg = msg+dataObject.getString("doc");
                            //}
                        }
                    } catch (JSONException e) {
                        msg = e.getMessage();
                    }
                }
            });
        }


        public void cancelarReservaUser(int reserv_id){
            String url_registro = "appCancelReserva";
            Request req = client.cancelarReserva(url_registro, reserv_id);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());
                        msg = objeto.getString("msg");
                    } catch (JSONException e) {
                        msg = e.getMessage();
                    }
                }
            });
        }

        public void editDataUser(Usuarios user){
            String url_registro = "appeditar";
            Request req = client.editarUserApi(url_registro, user);
            OkHttpClient okhttp = new OkHttpClient();
            okhttp.newCall(req).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    Toast.makeText(generica.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    try {
                        JSONObject objeto = new JSONObject(response.body().string());

                        msg = objeto.getString("msg");

                    } catch (JSONException e) {
                        msg = e.getMessage();
                    }
                }
            });
        }
    }

