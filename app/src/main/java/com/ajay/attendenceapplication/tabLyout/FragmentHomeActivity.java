package com.ajay.attendenceapplication.tabLyout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ajay.attendenceapplication.Adapter.ViewPageAdapter;
import com.ajay.attendenceapplication.InsertDataInFirebase.DataSubmitActivity;
import com.ajay.attendenceapplication.databinding.ActivityFragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragmentHomeActivity extends AppCompatActivity {
private ActivityFragmentHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityFragmentHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ViewPageAdapter adapter=new ViewPageAdapter(this);
        binding.idViewPager2.setAdapter(adapter);
        new TabLayoutMediator(binding.tab1, binding.idViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

//                tab.setText("tab" + (position + 1));

                if (position==0){
                    tab.setText("All student");
                }else if (position==1){
                    tab.setText("Todays Attendence");
                }else {
                    tab.setText("Report");
                }

            }
        }).attach();

        binding.idFloatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FragmentHomeActivity.this, DataSubmitActivity.class);
                startActivity(intent);
            }
        });
    }

}