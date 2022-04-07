package com.ajay.attendenceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ajay.attendenceapplication.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private ActivityMainBinding binding;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

     binding.btnRegister.setOnClickListener(this);
     binding.btnLogin.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_register:
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContener,new RegisterFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

//            startActivity(new Intent(MainActivity.this,RegisterFragment.class));
             break;

            case R.id.btn_login:
                FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.mainContener,new LoginFragment());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();

//                startActivity(new Intent(MainActivity.this,LoginFragment.class));
                break;

        }
    }
}