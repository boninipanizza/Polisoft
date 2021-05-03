package com.tributech.vistas_polisoft;

public class Reservas {
    private String id;
    //private String atencion;
    private String numturnos;
    //private int user_id;
    private String medico;
    private String fecha;
    private String policlinica;

    public Reservas(String id, String numturnos, String medico, String fecha, String policlinica) {
        this.id = id;
        this.numturnos = numturnos;
        this.medico = medico;
        this.fecha = fecha;
        this.policlinica = policlinica;
    }

    public Reservas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumturnos() {
        return numturnos;
    }

    public void setNumturnos(String numturnos) {
        this.numturnos = numturnos;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPoliclinica() {
        return policlinica;
    }

    public void setPoliclinica(String policlinica) {
        this.policlinica = policlinica;
    }
}
