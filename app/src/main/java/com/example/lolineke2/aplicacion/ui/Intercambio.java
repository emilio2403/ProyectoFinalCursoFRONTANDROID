package com.example.lolineke2.aplicacion.ui;

import com.example.lolineke2.aplicacion.rest.model.Alquiler;
import com.example.lolineke2.aplicacion.rest.model.Infraestructura;
import com.example.lolineke2.aplicacion.rest.model.Usuario;

import java.util.List;

public class Intercambio {
    private static Intercambio instance;
    private Intercambio(){}

    public static Intercambio getInstance(){
        if(instance==null){
            instance = new Intercambio();
        }
        return instance;
    }

    private FragmentHolder fragmentHolder;
    private String deporteSeleccionado;
    private Usuario usuario;
    private List<Infraestructura> infraestructuras;
    private Alquiler alquiler;

    public FragmentHolder getFragmentHolder() {
        return fragmentHolder;
    }

    public void setFragmentHolder(FragmentHolder fragmentHolder) {
        this.fragmentHolder = fragmentHolder;
    }

    public String getDeporteSeleccionado() {
        return deporteSeleccionado;
    }

    public void setDeporteSeleccionado(String deporteSeleccionado) {
        this.deporteSeleccionado = deporteSeleccionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Infraestructura> getInfraestructuras() {
        return infraestructuras;
    }

    public void setInfraestructuras(List<Infraestructura> infraestructuras) {
        this.infraestructuras = infraestructuras;
    }
  
    public Alquiler getAlquiler() { return alquiler; }


    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
}
