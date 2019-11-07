package com.akash.verificationapp.Adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akash.verificationapp.Activities.ProfileActivity;
import com.akash.verificationapp.Model.Contact;
import com.akash.verificationapp.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MycontactRecyclerViewAdapter extends RecyclerView.Adapter<MycontactRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Contact> mValues;
    private Context context;

    public MycontactRecyclerViewAdapter(ArrayList<Contact> items,Context ctx) {
        mValues = items;
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        try {
            //holder.mItem = mValues.get(position);
            String name = mValues.get(position).getFirstName()+" "+mValues.get(position).getLastName();
            holder.mIdView.setText(name);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent out = new Intent(context, ProfileActivity.class);
                    out.putExtra("contact",mValues.get(position));
                    context.startActivity(out);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
         final View mView;
         final TextView mIdView;
         final ImageView imageView;

         ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            imageView =  view.findViewById(R.id.contact_image);
        }
    }
}
