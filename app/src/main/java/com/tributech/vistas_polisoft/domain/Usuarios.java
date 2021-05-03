package com.tributech.vistas_polisoft.domain;


import com.google.gson.annotations.SerializedName;

public class Usuarios {

    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("dni")
    private String dni;
    @SerializedName("address")
    private String address;
    @SerializedName("movilphone")
    private String movilphone;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private String email;
    // @SerializedName("password")
    //private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMovilphone() {
        return movilphone;
    }

    public void setMovilphone(String movilphone) {
        this.movilphone = movilphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    public Usuarios() {
    }

    public Usuarios(int id, String username, String lastname, String dni, String address, String movilphone, String phone, String email /*String password*/) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.dni = dni;
        this.address = address;
        this.movilphone = movilphone;
        this.phone = phone;
        this.email = email;
        //this.password = password;
    }
}