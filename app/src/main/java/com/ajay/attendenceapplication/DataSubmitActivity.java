package com.ajay.attendenceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ajay.attendenceapplication.InsertDataInFirebase.FirebaseDB;
import com.ajay.attendenceapplication.InsertDataInFirebase.InfoStudentClass;
import com.ajay.attendenceapplication.databinding.ActivityDataSubmitBinding;
import com.ajay.attendenceapplication.tabLyout.Fragment1;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

public class DataSubmitActivity extends AppCompatActivity {
private ActivityDataSubmitBinding binding;
    private FirebaseDB firebaseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataSubmitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InfoStudentClass infoStudentClass=new InfoStudentClass();
                infoStudentClass.setJoiningDate(binding.edt1.getText().toString());
//                infoStudentClass.setFullName(binding.edt2.getText().toString());
//                infoStudentClass.setMobileNo(binding.edt3.getText().toString());
//                infoStudentClass.setEmail(binding.edt4.getText().toString());
//                infoStudentClass.setHighestEdu(binding.edt5.getText().toString());
//                infoStudentClass.setCommuAddress(binding.edt6.getText().toString());

                firebaseDB.add(infoStudentClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {



                    }
                });


            }
        });

    }
}