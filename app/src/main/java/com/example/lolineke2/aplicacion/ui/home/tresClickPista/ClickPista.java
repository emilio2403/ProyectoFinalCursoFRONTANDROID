package com.example.lolineke2.aplicacion.ui.home.tresClickPista;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.aplicacion.rest.model.Infraestructura;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.aplicacion.ui.home.cuatroSelecDia.SelecDia;
import com.example.lolineke2.databinding.FragmentClickPistaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClickPista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClickPista extends Fragment {

    private FragmentClickPistaBinding binding;
    public ClickPista() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClickPista.
     */
    // TODO: Rename and change types and number of parameters
    public static ClickPista newInstance(String param1, String param2) {
        ClickPista fragment = new ClickPista();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClickPistaBinding.inflate(inflater,container,false);

        initFields();
        setOnClick();

        return binding.getRoot();
    }

    private void setOnClick(){
        binding.okClickPista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intercambio.getInstance().getFragmentHolder().changeFragment(new SelecDia());
            }
        });

        binding.backClickPista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void initFields(){
        Infraestructura pista = Intercambio.getInstance().getInfraestructuras().get(0);
        binding.descripcionPista.setText(pista.getDescripcion());
        binding.nombrePista.setText(pista.getNombre());
        binding.precioAlquiler.setText(pista.getCoste()+"/h");
    }
}