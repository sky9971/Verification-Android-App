package com.akash.verificationapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.akash.verificationapp.Adapter.ViewPagerAdapter;
import com.akash.verificationapp.Database.AppDatabase;
import com.akash.verificationapp.R;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public static AppDatabase database;//static variable for accessing database
    public static RequestQueue requestQueue;//static variable for accessing api queue

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Verification App");
        initParameters();
        initViews();
    }

    //method to initialize/bind views with java code
    private void initViews(){
        tab = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());//initialize viewpager adapter
        tab.addTab(tab.newTab().setText("Contacts"));
        tab.addTab(tab.newTab().setText("History"));
        viewPagerAdapter.setCount(2);//use tab count to set page count
        viewPager.setAdapter(viewPagerAdapter);
        tab.setupWithViewPager(viewPager);
    }

    //method to initiate parameters
    private void initParameters(){
        database = AppDatabase.getAppDatabase(this);
        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);

// Start the queue
        requestQueue.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database = null;
        AppDatabase.destroyInstance();
        requestQueue.stop();
    }
}
