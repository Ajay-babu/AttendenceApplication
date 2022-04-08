package com.ajay.attendenceapplication.FetchDataOnUI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ajay.attendenceapplication.InsertDataInFirebase.InfoStudentClass;
import com.ajay.attendenceapplication.R;
import com.ajay.attendenceapplication.databinding.RecyclerviewLayoutBinding;
import com.ajay.attendenceapplication.tabLyout.Fragment1;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context context;
    private List<InfoStudentClass> studentInfoList = new ArrayList<>();
    private OnItemClickListenerFirebase listenerFirebase;

    public RecyclerViewAdapter(Context context, OnItemClickListenerFirebase listenerFirebase) {
        this.context = context;
        this.listenerFirebase = listenerFirebase;
    }

    public void setStudentInfoList(List<InfoStudentClass> studentInfoList) {
        this.studentInfoList = studentInfoList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerviewLayoutBinding binding = RecyclerviewLayoutBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.text1.setText(studentInfoList.get(position).getJoiningDate());
        holder.binding.text2.setText(studentInfoList.get(position).getFullName());
        holder.binding.text3.setText(String.valueOf(studentInfoList.get(position).getMobileNo()));
        holder.binding.text4.setText(studentInfoList.get(position).getEmail());
        holder.binding.text5.setText(studentInfoList.get(position).getHighestEdu());
        holder.binding.text6.setText(studentInfoList.get(position).getCommuAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listenerFirebase !=null){
                    listenerFirebase.onItemClick(holder.getLayoutPosition(),studentInfoList);

                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return studentInfoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerviewLayoutBinding binding;
        public MyViewHolder(@NonNull RecyclerviewLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
