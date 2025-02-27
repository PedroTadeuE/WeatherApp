package com.pedro.weatherforecast;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pedro.weatherforecast.databinding.SplashScreenBinding;

public class MainActivity extends AppCompatActivity {

    private SplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //binding
        binding = SplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //handler que manda comando pra UiThread para fazer a transição da tela com delay para enviar o codigo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //transição de activity
                Intent intent = new Intent(MainActivity.this,TelaPrincipalActivity.class);
                startActivity(intent);
                //fechando a atual
                finish();
            }
            //delay da splash
        },3000);

    }

}