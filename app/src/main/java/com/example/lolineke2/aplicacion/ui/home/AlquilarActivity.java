package com.example.lolineke2.aplicacion.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.lolineke2.R;
import com.example.lolineke2.aplicacion.ui.FragmentHolder;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.databinding.ActivityAlquilarBinding;

public class AlquilarActivity extends AppCompatActivity implements FragmentHolder {

    private ActivityAlquilarBinding binding;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAlquilarBinding.inflate(getLayoutInflater());
        Intercambio.getInstance().setFragmentHolder(this);

        setContentView(binding.getRoot());
    }

    @Override
    public void changeFragment(Fragment f){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView3,f);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}