package com.example.lolineke2.aplicacion.mapper;

import com.example.lolineke2.aplicacion.rest.model.Infraestructura;

import java.util.ArrayList;
import java.util.List;

public class InfraestructuraMapper {

    private static InfraestructuraMapper instance;
    private InfraestructuraMapper(){}

    public static InfraestructuraMapper getInstance(){
        if(instance==null){
            instance = new InfraestructuraMapper();
        }
        return instance;
    }

    public List<String> infraestructuraToString(List<Infraestructura> lista){
        List<String> ret = new ArrayList<>();

        for(Infraestructura i:lista){
            ret.add(i.toString());
        }

        return ret;
    }
}
