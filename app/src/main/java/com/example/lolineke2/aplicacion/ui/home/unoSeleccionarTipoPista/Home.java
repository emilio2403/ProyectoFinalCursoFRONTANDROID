package com.example.lolineke2.aplicacion.ui.home.unoSeleccionarTipoPista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.R;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;
import com.example.lolineke2.aplicacion.rest.model.Infraestructura;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.aplicacion.ui.home.AlquilarActivity;
import com.example.lolineke2.aplicacion.ui.home.dosClickTipoPista.ClickTipoPista;
import com.example.lolineke2.databinding.FragmentHomeBinding;
import com.example.lolineke2.databinding.FragmentMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    private FragmentMainBinding binding;
    private Api api;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api= ApiConfig.getClient().create(Api.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater,container,false);

        binding.listaHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            String[] deportes = getResources().getStringArray(R.array.deportes);
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intercambio.getInstance().setDeporteSeleccionado(deportes[i].toUpperCase());

                setInfraestructuras();
            }
        });
        return binding.getRoot();
    }

    private void setInfraestructuras(){
        Call<List<Infraestructura>> reservas = api.getInfraestructurasByTipo(Intercambio.getInstance().getDeporteSeleccionado());

        reservas.enqueue(new Callback<List<Infraestructura>>() {
            @Override
            public void onResponse(Call<List<Infraestructura>> call, Response<List<Infraestructura>> response) {
                if(response.isSuccessful() && response.code()==200){
                    Intercambio.getInstance().setInfraestructuras(response.body());
                    Intent clickTipoPista = new Intent(getActivity(),AlquilarActivity.class);
                    startActivity(clickTipoPista);
                    getActivity().finish();
                }else{
                    Toast.makeText(getActivity(), "Error al encontrar el tipo de instalacion", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Infraestructura>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error al conectar con la base de datos, pruebe en otro momento", Toast.LENGTH_SHORT).show();
            }
        });

    }
}