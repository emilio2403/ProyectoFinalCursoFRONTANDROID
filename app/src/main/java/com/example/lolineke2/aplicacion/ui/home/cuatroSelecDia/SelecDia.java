package com.example.lolineke2.aplicacion.ui.home.cuatroSelecDia;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.aplicacion.rest.model.Alquiler;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.aplicacion.ui.home.cincoSelecHora.SelecHora;
import com.example.lolineke2.databinding.FragmentSelecDiaBinding;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelecDia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelecDia extends Fragment {

    private FragmentSelecDiaBinding binding;
    private int dia, mes, ano;

    public SelecDia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelecDia.
     */
    // TODO: Rename and change types and number of parameters
    public static SelecDia newInstance(String param1, String param2) {
        SelecDia fragment = new SelecDia();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSelecDiaBinding.inflate(inflater,container,false);

        setOnClick();

        return binding.getRoot();
    }

    private void setOnClick(){

        binding.selecHoraDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intercambio.getInstance().setAlquiler(createAlquiler());
                Intercambio.getInstance().getFragmentHolder().changeFragment(new SelecHora());
            }
        });

        binding.backDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        binding.calendarioDia.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int mounth, int day) {
                dia = day;
                mes = mounth;
                ano = year;
            }
        });
    }

    private Alquiler createAlquiler(){
        Alquiler alquiler = new Alquiler();

        alquiler.setId(UUID.randomUUID());
        alquiler.setInfraestructura(Intercambio.getInstance().getInfraestructuras().get(0));
        //alquiler.setCliente(Intercambio.getInstance().getUsuario());
        alquiler.setYear(ano);
        alquiler.setDay(dia);
        alquiler.setMonth(mes);
        alquiler.setCoste(Intercambio.getInstance().getInfraestructuras().get(0).getCoste());

        return alquiler;
    }
}