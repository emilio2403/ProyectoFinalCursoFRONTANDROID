package com.example.lolineke2.aplicacion.ui.home.seisReservaPreview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.aplicacion.Home;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;
import com.example.lolineke2.aplicacion.rest.model.Alquiler;
import com.example.lolineke2.aplicacion.rest.model.Usuario;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.databinding.FragmentReservaPreviewBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReservaPreview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReservaPreview extends Fragment {

    private FragmentReservaPreviewBinding binding;
    private Api api;

    public ReservaPreview() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReservaPreview.
     */
    // TODO: Rename and change types and number of parameters
    public static ReservaPreview newInstance(String param1, String param2) {
        ReservaPreview fragment = new ReservaPreview();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = ApiConfig.getClient().create(Api.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentReservaPreviewBinding.inflate(inflater,container,false);
        Intercambio.getInstance().getUsuario().getAlquileres().add(
                Intercambio.getInstance().getAlquiler()
        );
        setTexts();
        setOnClick();

        return binding.getRoot();
    }

    private void setOnClick(){
        binding.aceptarPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Usuario> usuarioCall = api.reservaUsuario(Intercambio.getInstance().getUsuario());
                usuarioCall.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Toast.makeText(getActivity(), "Reserva creada con exito", Toast.LENGTH_SHORT).show();
                        Intent homeActivity = new Intent(getActivity(), Home.class);
                        startActivity(homeActivity);
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getActivity(),"Fallo al crear la reserva",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        binding.backPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void setTexts(){
        Alquiler alquiler = Intercambio.getInstance().getAlquiler();
        binding.tituloPreview.setText(alquiler.getInfraestructura().getNombre());
        binding.costePreview.setText(String.valueOf(alquiler.getCoste()));
        //binding.aNombreDePreview.setText(alquiler.getCliente().getNombre());
        binding.diaReservaPreview.setText(alquiler.getFecha());
        binding.horaReservaApi.setText(alquiler.getInicio()+":00");
    }
}