package com.example.lolineke2.aplicacion.ui.about;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.R;
import com.example.lolineke2.databinding.FragmentAboutBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link About#newInstance} factory method to
 * create an instance of this fragment.
 */
public class About extends Fragment {

    private FragmentAboutBinding binding;

    public About() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment About.
     */
    // TODO: Rename and change types and number of parameters
    public static About newInstance(String param1, String param2) {
        About fragment = new About();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAboutBinding.inflate(inflater,container,false);

        binding.aboutText.setText("Eneko Rebollo Hernandez -> github.com/enekor\n" +
                "Saul Mellado Herrera -> github.com/saulmella12\n" +
                "Dylan Hurtado Lopez -> github.com/DyLaNHurtado\n" +
                "Daniel Rodriguez Muñoz -> github.com/idliketobealoli\n" +
                "Emilio Lopez Novillo -> github.com/emilio2403");

        return binding.getRoot();
    }
}