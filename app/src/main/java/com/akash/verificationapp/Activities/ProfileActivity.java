package com.akash.verificationapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akash.verificationapp.Model.Contact;
import com.akash.verificationapp.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Contact contact = getIntent().getExtras().getParcelable("contact");
        TextView name = findViewById(R.id.textView2);
        String na = contact.getFirstName()+" "+contact.getLastName();
        name.setText(na);
        TextView phone = findViewById(R.id.textView4);
        phone.setText(contact.getPhone());
        Button sms = findViewById(R.id.button);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(ProfileActivity.this,SendSMS.class);
                out.putExtra("phone",contact.getPhone());
                startActivity(out);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

}
