package com.giulietta.trabajopractico2lab3.ui.login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.giulietta.trabajopractico2lab3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public MainActivityViewModel mv;
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.Login(binding.etMail.getText().toString(), binding.etPassword.getText().toString());
                binding.etMail.setText("");
                binding.etPassword.setText("");
            }
        });
        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.Registrar();
            }
        });
    }
}