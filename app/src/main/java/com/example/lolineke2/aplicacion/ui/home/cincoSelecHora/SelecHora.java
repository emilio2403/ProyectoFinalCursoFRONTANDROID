package com.example.lolineke2.aplicacion.ui.home.cincoSelecHora;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.aplicacion.ui.home.seisReservaPreview.ReservaPreview;
import com.example.lolineke2.databinding.FragmentSelecHoraBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelecHora#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelecHora extends Fragment {

    private FragmentSelecHoraBinding binding;
    private ArrayAdapter<Integer> horasLista;
    private Api api;
    private List<Integer> horas;

    public SelecHora() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment selecHora.
     */
    // TODO: Rename and change types and number of parameters
    public static SelecHora newInstance(String param1, String param2) {
        SelecHora fragment = new SelecHora();
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

        binding = FragmentSelecHoraBinding.inflate(inflater,container,false);

        getHorasLibres();
        setOnClick();

        return binding.getRoot();
    }

    private void setOnClick(){
        binding.horasLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intercambio.getInstance().getAlquiler().setInicio(horas.get(i));
                Intercambio.getInstance().getAlquiler().setFin(horas.get(i)+1);
                Intercambio.getInstance().getFragmentHolder().changeFragment(new ReservaPreview());

                Toast.makeText(getActivity(), ""+Intercambio.getInstance().getAlquiler().getInicio(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.backHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void getHorasLibres(){
        Call<List<Integer>> horasCall = api.getHorasLibres(Intercambio.getInstance().getInfraestructuras().get(0).getId(),
                Intercambio.getInstance().getAlquiler().getYear(),
                Intercambio.getInstance().getAlquiler().getMonth(),
                Intercambio.getInstance().getAlquiler().getDay());

        horasCall.enqueue(new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                Log.i("info","valores"+response.body());
                horas= response.body();
                horasLista = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_list_item_1,horas);
                binding.horasLista.setAdapter(horasLista);
            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}