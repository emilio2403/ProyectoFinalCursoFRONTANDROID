package com.example.lolineke2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.lolineke2.aplicacion.Home;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;
import com.example.lolineke2.aplicacion.rest.model.Usuario;
import com.example.lolineke2.aplicacion.ui.FragmentHolder;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements FragmentHolder {

    private FragmentTransaction transaction;
    private SharedPreferences sharedPreferences;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intercambio.getInstance().setFragmentHolder(this);
        api= ApiConfig.getClient().create(Api.class);
    }

    @Override
    public void changeFragment(Fragment f) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerLR,f);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}