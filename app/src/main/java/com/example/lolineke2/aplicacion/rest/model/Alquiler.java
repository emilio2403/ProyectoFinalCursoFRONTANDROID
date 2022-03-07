package com.example.lolineke2.aplicacion.rest.model;

import java.util.UUID;

public class Alquiler {

    private UUID id;
    private int inicio;
    private int fin;
    private double coste;
    private Infraestructura infraestructura;
    private int year;
    private int month;
    private int day;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Infraestructura getInfraestructura() {
        return infraestructura;
    }

    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return infraestructura.getNombre()+" -> "+day+"/"+month+"/"+year+" | "+coste+"€";
    }

    public String getFecha(){
        return day+"/"+month+"/"+year;
    }
}
