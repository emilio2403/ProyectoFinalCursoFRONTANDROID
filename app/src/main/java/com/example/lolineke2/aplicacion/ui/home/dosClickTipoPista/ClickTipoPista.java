package com.example.lolineke2.aplicacion.ui.home.dosClickTipoPista;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.aplicacion.Home;
import com.example.lolineke2.aplicacion.mapper.InfraestructuraMapper;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.model.Infraestructura;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.aplicacion.ui.home.AlquilarActivity;
import com.example.lolineke2.aplicacion.ui.home.cincoSelecHora.SelecHora;
import com.example.lolineke2.aplicacion.ui.home.cuatroSelecDia.SelecDia;
import com.example.lolineke2.aplicacion.ui.home.tresClickPista.ClickPista;
import com.example.lolineke2.databinding.FragmentClickTipoPistaBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClickTipoPista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClickTipoPista extends Fragment {

    private FragmentClickTipoPistaBinding binding;
    private ArrayAdapter<String> pistasLista;

    public ClickTipoPista() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClickTipoPista.
     */
    // TODO: Rename and change types and number of parameters
    public static ClickTipoPista newInstance(String param1, String param2) {
        ClickTipoPista fragment = new ClickTipoPista();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClickTipoPistaBinding.inflate(inflater,container,false);

        binding.titulo.setText("Nuestras pistas de "+Intercambio.getInstance().getDeporteSeleccionado());

        setListInfo();
        setOnClick();

        return binding.getRoot();
    }

    private void setListInfo(){
        pistasLista = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                InfraestructuraMapper.getInstance().infraestructuraToString(Intercambio.getInstance().getInfraestructuras()));
        binding.pistasLV.setAdapter(pistasLista);
    }

    private void setOnClick(){
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        binding.pistasLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intercambio.getInstance().setInfraestructuras(Collections.singletonList(
                        Intercambio.getInstance().getInfraestructuras().get(i)
                ));

                Intercambio.getInstance().getFragmentHolder().changeFragment(new ClickPista());
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeActivity = new Intent(getActivity(), Home.class);
                startActivity(homeActivity);
                getActivity().finish();
            }
        });
    }
}