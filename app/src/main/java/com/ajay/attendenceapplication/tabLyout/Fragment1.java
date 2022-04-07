package com.ajay.attendenceapplication.tabLyout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajay.attendenceapplication.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {
private Fragment1Binding binding;
private TextView name1,name2,name3,name4,name5,name6;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       binding=Fragment1Binding.inflate(inflater,container,false);

//
//            binding.idRecyclerView1.setLayoutManager(new LinearLayoutManager());
//
//
//
//            String arr[]={};
//            binding.idRecyclerView1.setAdapter(new RecyclerViewAdapter(arr));

        return binding.getRoot();

    }


}