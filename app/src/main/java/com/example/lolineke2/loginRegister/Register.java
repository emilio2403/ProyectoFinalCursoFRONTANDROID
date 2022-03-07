package com.example.lolineke2.loginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.R;
import com.example.lolineke2.aplicacion.Home;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;
import com.example.lolineke2.aplicacion.rest.model.Usuario;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.databinding.FragmentRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register extends Fragment {

    private FragmentRegisterBinding binding;
    private Api api;

    public Register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register.
     */
    // TODO: Rename and change types and number of parameters
    public static Register newInstance(String param1, String param2) {
        Register fragment = new Register();
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

        binding = FragmentRegisterBinding.inflate(inflater,container,false);

        setOnClick();

        return binding.getRoot();
    }

    private void setOnClick(){
        binding.buttonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intercambio.getInstance().getFragmentHolder().changeFragment(new Login());
            }
        });

        binding.buttonOkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.etEmailRegister.getText().toString().equalsIgnoreCase("") ||
                        binding.etPasswordRegister.getText().toString().equalsIgnoreCase("")||
                        binding.etRepeatPasswordRegister.getText().toString().equalsIgnoreCase("")||
                        binding.etUsernameRegister.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Hay campos vacios", Toast.LENGTH_SHORT).show();
                }else{
                    if(binding.etPasswordRegister.getText().toString().equals(binding.etRepeatPasswordRegister.getText().toString())){
                        Usuario user = new Usuario();
                        user.setCorreo(binding.etEmailRegister.getText().toString());
                        user.setNombre(binding.etUsernameRegister.getText().toString());
                        user.setPassword(binding.etPasswordRegister.getText().toString());

                        Call<Usuario> call=api.crearUsuario(user);
                        call.enqueue(new Callback<Usuario>() {
                            @Override
                            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                                Toast.makeText(getActivity(), "Usuario creado con éxito.", Toast.LENGTH_SHORT).show();
                                Intercambio.getInstance().setUsuario(response.body());
                                startActivity(new Intent(getActivity(), Home.class));
                            }

                            @Override
                            public void onFailure(Call<Usuario> call, Throwable t) {
                                Toast.makeText(getActivity(), "Error al crear usuario.", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else{
                        Toast.makeText(getActivity(), "Los campos password y repeat password no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}