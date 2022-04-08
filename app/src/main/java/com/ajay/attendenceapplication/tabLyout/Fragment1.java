package com.ajay.attendenceapplication.tabLyout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajay.attendenceapplication.FetchDataOnUI.OnItemClickListenerFirebase;
import com.ajay.attendenceapplication.FetchDataOnUI.RecyclerViewAdapter;
import com.ajay.attendenceapplication.InsertDataInFirebase.FirebaseDB;
import com.ajay.attendenceapplication.InsertDataInFirebase.InfoStudentClass;
import com.ajay.attendenceapplication.Utility.Utility;
import com.ajay.attendenceapplication.databinding.Fragment1Binding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
private Fragment1Binding binding;
private FirebaseDB firebaseDb;
private List<InfoStudentClass> studentInfoList = new ArrayList<>();
RecyclerViewAdapter recyclerViewAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       binding=Fragment1Binding.inflate(inflater,container,false);



        firebaseDb = new FirebaseDB();
        recyclerViewAdapter=new RecyclerViewAdapter(getContext(), new OnItemClickListenerFirebase() {
            @Override
            public void onItemClick(int position, List<InfoStudentClass> studentInfo) {






            }
        });

        binding.idRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.idRecyclerView1.setAdapter(recyclerViewAdapter);

//        firebaseDb.get().addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    InfoStudentClass studentInfo = dataSnapshot.getValue(InfoStudentClass.class);
//                    //TODO: Here setKey is the setter method and getKey is the method of firebase to get Key
//                    studentInfo.setKey(dataSnapshot.getKey());
//                    studentInfoList.add(studentInfo);
//                    recyclerViewAdapter.setStudentInfoList(studentInfoList);
//                    recyclerViewAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//
//            }
//        });


        fetchdata();


        return binding.getRoot();

    }
    public void fetchdata(){
        firebaseDb.get().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    InfoStudentClass studentInfo = dataSnapshot.getValue(InfoStudentClass.class);
                    //TODO: Here setKey is the setter method and getKey is the method of firebase to get Key
                    studentInfo.setKey(dataSnapshot.getKey());
                    studentInfoList.add(studentInfo);
                    recyclerViewAdapter.setStudentInfoList(studentInfoList);
                    recyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();



    }
}