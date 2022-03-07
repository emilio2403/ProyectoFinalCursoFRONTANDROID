package com.example.lolineke2.aplicacion.ui.exit;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Exit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Exit extends Fragment {

    public Exit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Exit.
     */
    // TODO: Rename and change types and number of parameters
    public static Exit newInstance(String param1, String param2) {
        Exit fragment = new Exit();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().finish();
        return null;
    }
}