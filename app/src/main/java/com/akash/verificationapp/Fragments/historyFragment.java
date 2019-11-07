package com.akash.verificationapp.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.akash.verificationapp.Activities.MainActivity;
import com.akash.verificationapp.Adapter.MyhistoryRecyclerViewAdapter;
import com.akash.verificationapp.Database.AppDatabase;
import com.akash.verificationapp.Database.Sms;
import com.akash.verificationapp.Model.Contact;
import com.akash.verificationapp.R;

import java.util.ArrayList;


public class historyFragment extends Fragment {

    private ArrayList<Sms> sentList = new ArrayList<>();

    public historyFragment() {

    }

    public static historyFragment newInstance() {
        historyFragment f = new historyFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //init list
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyhistoryRecyclerViewAdapter(sentList));
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        sentList.addAll(MainActivity.database.smsDao().getAll());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
