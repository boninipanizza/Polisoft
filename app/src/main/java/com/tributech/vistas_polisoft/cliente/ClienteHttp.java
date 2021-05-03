package com.tributech.vistas_polisoft.cliente;

import com.tributech.vistas_polisoft.domain.Usuarios;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ClienteHttp {

    private static String ip = "http://192.168.0.139:5000/";

    public static Request loginApi(String url, String dni, String pass) {
        RequestBody body = new FormBody.Builder().add("dni_init", dni).add("pass_init", pass).build();
        Request req = new Request.Builder().url(ip + url).post(body).build();
        return req;
    }

    public static Request registroApi(String url, String nom, String ap, String dni, String addr, String movil,
                                      String tel, String email, String pass, String confpass) {
        RequestBody body = new FormBody.Builder().add("name", nom)
                .add("lastname", ap)
                .add("cedula", dni)
                .add("direc", addr)
                .add("telm", movil)
                .add("tel", tel)
                .add("correo", email)
                .add("pass", pass)
                .add("confpass", confpass).build();
        Request req = new Request.Builder().url(ip + url).post(body).build();
        return req;
    }

    public static Request filtros(String url) {
        //RequestBody body = new FormBody.Builder().build();

        Request req = new Request.Builder().url(ip + url).build();
        return req;
    }

    public static Request reservar(String url, int usu_id, int serv_id) {
        String usuario_id = String.valueOf(usu_id);
        String servicio_id = String.valueOf(serv_id);

        RequestBody body = new FormBody.Builder().add("id_usuario", usuario_id)
                .add("id_servicio", servicio_id).build();
        Request req = new Request.Builder().url(ip + url).post(body).build();
        return req;
    }

    public static Request resultadoServ(String url, String nomProf, String nomPoli, String nomEpec) {


        RequestBody body = new FormBody.Builder().add("polic", nomPoli)
                .add("medico", nomProf)
                .add("espec", nomEpec).build();
        Request req = new Request.Builder().url(ip + url).post(body).build();
        return req;
    }

    public static Request reservasUser(String url, int id_usuario) {

        String usuario_id = String.valueOf(id_usuario);
        RequestBody body = new FormBody.Builder().add("id_usuario", usuario_id).build();
        Request req = new Request.Builder().url(ip + url).post(body).build();
        return req;
    }

    public static Request cancelarReserva(String url, int idReserva) {

        String res_id = String.valueOf(idReserva);
        RequestBody body = new FormBody.Builder().add("reserva_id", res_id).build();
        Request req = new Request.Builder().url(ip + url).post(body).build();
        return req;
    }

    public static Request editarUserApi(String url, Usuarios user) {
        String id_usuario = String.valueOf(user.getId());
        RequestBody body = new FormBody.Builder().add("id", id_usuario)
                .add("modname", user.getUsername())
                .add("modlastname", user.getLastname())
                .add("moddni", user.getDni())
                .add("modadd", user.getAddress())
                .add("modmovil", user.getMovilphone())
                .add("modtel", user.getPhone())
                .add("modemail", user.getEmail()).build();

        Request req = new Request.Builder().url(ip + url).post(body).build();
        return req;
    }
}