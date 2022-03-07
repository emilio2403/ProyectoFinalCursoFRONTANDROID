package com.example.lolineke2.loginRegister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolineke2.aplicacion.Home;
import com.example.lolineke2.aplicacion.rest.model.Usuario;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.databinding.FragmentLoginBinding;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {

    private FragmentLoginBinding binding;
    private Api api;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean login;

    public Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater,container,false);

        checkSharedPreferences();
        setOnClick();

        return binding.getRoot();
    }

    private void openActivity(Class clase){
        Intent intent = new Intent(getActivity(),clase);
        startActivity(intent);
    }

    private boolean checkFields(){
        return !binding.etEmailLogin.getText().toString().equalsIgnoreCase("") &&
                !binding.etPasswordLogin.getText().toString().equalsIgnoreCase("");
    }

    private void setOnClick(){
        binding.buttonLoggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        binding.buttonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intercambio.getInstance().getFragmentHolder().changeFragment(new Register());
            }
        });
    }

    private void login(){
        if(checkFields()){
            Call<Usuario> login = api.loginWithoutToken(binding.etEmailLogin.getText().toString(),
                    binding.etPasswordLogin.getText().toString());
            login.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    if(response.isSuccessful()&&response.code()==200){
                        Toast.makeText(getActivity(), ""+response.code(), Toast.LENGTH_SHORT).show();
                        loginSuccessful(response);
                    }else{
                        Toast.makeText(getActivity(), "Usuario y/o password incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    Toast.makeText(getActivity(), "Error en petición", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            Toast.makeText(getActivity(), "Hay campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginSuccessful(Response<Usuario> response){
        Usuario user =response.body();
        Intercambio.getInstance().setUsuario(user);

        putSharedPreferences();

        openActivity(Home.class);
        getActivity().finish();
    }

    private void putSharedPreferences(){
        sharedPreferences = getActivity().getSharedPreferences("login",getActivity().MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("usuario",Intercambio.getInstance().getUsuario().getCorreo());
        editor.putString("pass",Intercambio.getInstance().getUsuario().getPassword());
        editor.putString("token",Intercambio.getInstance().getUsuario().getLogin().getToken().toString());
    }

    private void checkSharedPreferences(){
        sharedPreferences = getActivity().getSharedPreferences("login",getActivity().MODE_PRIVATE);

        if(!sharedPreferences.getString("token","null").equalsIgnoreCase("null")){
            checkToken(sharedPreferences.getString("usuario","null"),
                    sharedPreferences.getString("pass","null"),

                    UUID.fromString(sharedPreferences.getString("token","null")));

            if(login){
                getActivity().finish();
                startActivity(new Intent(getActivity(), Home.class));
            }
        }
    }

    private void checkToken(String usuario, String pass, UUID token){
        Call<Usuario> user = api.loginWithToken(token,usuario,pass);
        user.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful() && response.code()==200){
                    login = true;
                    Intercambio.getInstance().setUsuario(new Usuario());
                }else{
                    login = false;
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                login = false;
            }
        });

    }

}