package com.example.lolineke2.aplicacion.mapper;

import com.example.lolineke2.aplicacion.rest.model.Alquiler;

import java.util.ArrayList;
import java.util.List;

public class AlquilerMapper {

    private static AlquilerMapper mapper;
    private AlquilerMapper(){}

    public static AlquilerMapper getInstance(){
        if(mapper==null){
            mapper = new AlquilerMapper();
        }
        return mapper;
    }

    public List<String> alquileresToString(List<Alquiler> lista){
        List<String> ret = new ArrayList<>();
        for(Alquiler a:lista){
            ret.add(a.toString());
        }

        return ret;
    }
}
