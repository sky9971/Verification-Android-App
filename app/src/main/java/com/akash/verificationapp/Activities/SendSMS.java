package com.akash.verificationapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akash.verificationapp.Database.Sms;
import com.akash.verificationapp.R;

import java.util.Calendar;
import java.util.Random;

public class SendSMS extends AppCompatActivity {

    private String phone;
    private EditText message;
    private String time;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        getSupportActionBar().setTitle("Send OTP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        phone = getIntent().getStringExtra("phone");
        TextView to = findViewById(R.id.textView5);
        to.setText(phone);
        message = findViewById(R.id.editText);
        Random random = new Random();
        int otp = random.nextInt(7);
        String mes = String.format(getString(R.string.smstext),otp);
        message.setText(mes);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make api call here
                InsertEntery();
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

    private void InsertEntery(){
        Sms sms = new Sms();
        if (id == null)id = "abcdsss";
        if (time == null) time = Calendar.getInstance().getTime().toString();
        sms.id = id;
        sms.data_time = time;
        sms.body = message.getEditableText().toString();
        sms.from = "Akash";
        sms.to = phone;
        MainActivity.database.smsDao().insertAll(sms);
        finish();
    }
}
