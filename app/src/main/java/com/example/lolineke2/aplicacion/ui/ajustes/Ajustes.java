package com.example.lolineke2.aplicacion.ui.ajustes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.databinding.FragmentAjustesBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ajustes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ajustes extends Fragment {

    private FragmentAjustesBinding binding;

    public Ajustes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ajustes.
     */
    // TODO: Rename and change types and number of parameters
    public static Ajustes newInstance(String param1, String param2) {
        Ajustes fragment = new Ajustes();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAjustesBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}