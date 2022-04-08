package com.ajay.attendenceapplication.InsertDataInFirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.DatePicker;

import com.ajay.attendenceapplication.InsertDataInFirebase.FirebaseDB;
import com.ajay.attendenceapplication.InsertDataInFirebase.InfoStudentClass;
import com.ajay.attendenceapplication.Utility.Utility;
import com.ajay.attendenceapplication.databinding.ActivityDataSubmitBinding;
import com.ajay.attendenceapplication.tabLyout.Fragment1;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class DataSubmitActivity extends AppCompatActivity {
private ActivityDataSubmitBinding binding;
    private FirebaseDB firebaseDB;
    private String imageInBase64;
    private Calendar calendar;
    private int DAYOFMONTH,MONTH,YEAR;
    private String FinalDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataSubmitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO fetching date from calendar
        calendar = Calendar.getInstance();
        DAYOFMONTH = calendar.get(Calendar.DAY_OF_MONTH);
        MONTH = calendar.get(Calendar.MONTH);
        YEAR = calendar.get(Calendar.YEAR);

          firebaseDB=new FirebaseDB();

          //TODO We are creating calendar function

        binding.edt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(DataSubmitActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        month=month+1;
                        String date = dayofmonth+"/"+month+"/"+year;
                        FinalDate = date;
                       binding.edt1.setText(date);

                    }
                }, YEAR,MONTH,DAYOFMONTH);
                datePickerDialog.show();
            }
        });

          //TODO click listener and giving permission for opening camera

      binding.idImage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              if (ContextCompat.checkSelfPermission(DataSubmitActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                  callCamera();
              }else {
                  ActivityCompat.requestPermissions(DataSubmitActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
              }

          }


      });



        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InfoStudentClass infoStudentClass=new InfoStudentClass();
                infoStudentClass.setJoiningDate(FinalDate);
                infoStudentClass.setFullName(binding.edt2.getText().toString());
                infoStudentClass.setMobileNo(binding.edt3.getText().toString());
                infoStudentClass.setEmail(binding.edt4.getText().toString());
                infoStudentClass.setHighestEdu(binding.edt5.getText().toString());
                infoStudentClass.setCommuAddress(binding.edt6.getText().toString());
                infoStudentClass.setImage(imageInBase64);

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

    //TODO inbuilt Function for calling camera using intent

    private void callCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult
                (intent, 101);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //TODO  gaining permission and calling camera

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // TODO: DO UR JOB
                callCamera();
            } else {
                Utility.showLongToast(getApplicationContext(), "Permission Denied!");
            }
        }
    }

    //TODO this is a command for converting image into base64 to bitmap and setting this bitmap into imageview

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageInBase64 = Utility.convertBitmaptoBase64(bitmap);
//            if (isUpdate){
//                binding.profileImage.setImageBitmap(bitmap);
//            }

            binding.idImage.setImageBitmap(bitmap);

        }


    }
}