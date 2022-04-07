package com.ajay.attendenceapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ajay.attendenceapplication.tabLyout.Fragment1;
import com.ajay.attendenceapplication.tabLyout.Fragment2;
import com.ajay.attendenceapplication.tabLyout.Fragment3;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Fragment1();

            case 1:
                return new Fragment2();

            default:
                return new Fragment3();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
