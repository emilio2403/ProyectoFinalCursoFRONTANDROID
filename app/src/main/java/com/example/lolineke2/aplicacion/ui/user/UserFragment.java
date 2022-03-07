package com.example.lolineke2.aplicacion.ui.user;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.MainActivity;
import com.example.lolineke2.R;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.databinding.FragmentUserBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    private FragmentUserBinding binding;
    private MediaPlayer mediaPlayer;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(getActivity(),R.raw.mercadona_mercadona_cancion);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentUserBinding.inflate(inflater,container,false);

        mediaPlayer.start();

        binding.buttonDarseDeBajaUprofile.setBackgroundColor(Color.RED);
        binding.tvEmailUprofile.setText(Intercambio.getInstance().getUsuario().getCorreo());
        binding.tvInfouserUprofile.setText("Usuario con "+Intercambio.getInstance().getUsuario().getAlquileres().size()+" alquileres a su nombre");
        binding.tvUsernameUprofile.setText(Intercambio.getInstance().getUsuario().getNombre());

        setOnClick();

        return binding.getRoot();
    }

    private void setOnClick(){
        binding.buttonDarseDeBajaUprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });
    }

    private void alertDialog() {
        Dialog dialog = null;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Desea borrar la cuenta?")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                deleteAccount();
                            }
                        })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {}
                        });
        AlertDialog alert = builder.create();

        dialog = alert;
        dialog.show();
    }

    private void deleteAccount(){
        Toast.makeText(getActivity(), "No gracias, te queremos demasiado como cliente para esta despedida tan tragica", Toast.LENGTH_LONG).show();
    }


}