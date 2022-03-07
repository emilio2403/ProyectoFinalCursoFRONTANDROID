package com.example.lolineke2.aplicacion.ui.reservas.verReservaX;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.lolineke2.aplicacion.Home;
import com.example.lolineke2.aplicacion.rest.Api;
import com.example.lolineke2.aplicacion.rest.ApiConfig;
import com.example.lolineke2.aplicacion.rest.model.Alquiler;
import com.example.lolineke2.aplicacion.rest.model.Usuario;
import com.example.lolineke2.aplicacion.ui.Intercambio;
import com.example.lolineke2.databinding.ActivityVerMiReservaBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerMiReservaActivity extends AppCompatActivity {

    private ActivityVerMiReservaBinding binding;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVerMiReservaBinding.inflate(getLayoutInflater());

        Alquiler alquiler = Intercambio.getInstance().getAlquiler();
        //binding.tvAnombredeReservaInfo.setText(alquiler.getCliente().getNombre());
        binding.tvDescripcionReservaInfo.setText(alquiler.getInfraestructura().getDescripcion());
        binding.tvDiaReservaInfo.setText(alquiler.getFecha());
        binding.tvPistanameReservaInfo.setText(alquiler.getInfraestructura().getNombre());
        binding.tvPrecioReservaInfo.setText(String.valueOf(alquiler.getCoste()));
        binding.tvHoraReservaInfo.setText(alquiler.getInicio()+":00 - "+alquiler.getFin()+":00");

        api = ApiConfig.getClient().create(Api.class);
        setOnClick();

        setContentView(binding.getRoot());
    }

    private void setOnClick(){
        binding.buttonBackReservaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.buttonDeleteReservaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intercambio.getInstance().getUsuario().getAlquileres().remove(getIntent().getIntExtra("i",0));
                Call<Usuario> deleteReserva = api.reservaUsuario(Intercambio.getInstance().getUsuario());
                deleteReserva.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.code()==204){
                            Toast.makeText(VerMiReservaActivity.this, "Reserva eliminada con exito", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(VerMiReservaActivity.this, "Reserva borrada con exito", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(VerMiReservaActivity.this, "Error al conectar con la base de datos, intentelo de nuevo mas tarde", Toast.LENGTH_LONG).show();
                    }
                });



                Intent homeActivity = new Intent(VerMiReservaActivity.this, Home.class);
                startActivity(homeActivity);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent homeActivity = new Intent(VerMiReservaActivity.this, Home.class);
        startActivity(homeActivity);
        finish();
    }
}