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

import com.akash.verificationapp.Adapter.MycontactRecyclerViewAdapter;
import com.akash.verificationapp.Model.Contact;
import com.akash.verificationapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class contactFragment extends Fragment {


    public contactFragment() {

    }

    public static contactFragment newInstance() {
        contactFragment f = new contactFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            JSONArray contacts = new JSONArray();
            JSONObject c1 = new JSONObject();
            c1.put("first","Akash");
            c1.put("last","Sheokand");
            c1.put("phone","+919971678309");
            contacts.put(c1);
            JSONObject c2 = new JSONObject();
            c2.put("first","Abhishek");
            c2.put("last","Aggarwal");
            c2.put("phone","+919810153260");
            contacts.put(c2);

            for (int i=0;i<contacts.length();i++){
                Contact c = new Contact(contacts.getJSONObject(i));
                contact.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Contact> contact = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MycontactRecyclerViewAdapter(contact,getActivity()));
        }
        return view;
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
