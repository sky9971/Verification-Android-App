package com.akash.verificationapp.Adapter;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.akash.verificationapp.Fragments.contactFragment;
import com.akash.verificationapp.Fragments.historyFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private int count;

    public void setCount(int count){
        this.count = count;
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){//switch case for selecting fragment
            case 0:
                return contactFragment.newInstance();
            case 1:
                return historyFragment.newInstance();
                default:
                return contactFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Contacts";
            case 1:
                return "History";
            default:
                return "unknown";
        }
    }


}
