package com.example.lolineke2.aplicacion.ui.reservas;

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
import com.example.lolineke2.aplicacion.mapper.AlquilerMapper;
import com.example.lolineke2.aplicacion.mapper.InfraestructuraMapper;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;
import com.example.lolineke2.aplicacion.rest.model.Alquiler;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.aplicacion.ui.reservas.verReservaX.VerMiReservaActivity;
import com.example.lolineke2.databinding.FragmentReservasBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reservas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reservas extends Fragment {

    private FragmentReservasBinding binding;
    List<Alquiler> alquileres;
    private ArrayAdapter<String> alquileresLista;

    public Reservas() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reservas.
     */
    // TODO: Rename and change types and number of parameters
    public static Reservas newInstance(String param1, String param2) {
        Reservas fragment = new Reservas();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentReservasBinding.inflate(inflater,container,false);

        setListInfo();
        setOnClick();

        return binding.getRoot();
    }

    private void setListInfo(){
        alquileres = Intercambio.getInstance().getUsuario().getAlquileres();
        alquileresLista = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                AlquilerMapper.getInstance().alquileresToString(alquileres));
        binding.rvMisReservas.setAdapter(alquileresLista);
    }

    private void setOnClick(){
        binding.buttonBackMisReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        binding.rvMisReservas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intercambio.getInstance().setAlquiler(alquileres.get(i));
                Intent verLaReservaSeleccionada = new Intent(getActivity(),VerMiReservaActivity.class);
                verLaReservaSeleccionada.putExtra("i",i);
                startActivity(verLaReservaSeleccionada);
                getActivity().finish();
            }
        });
    }
}