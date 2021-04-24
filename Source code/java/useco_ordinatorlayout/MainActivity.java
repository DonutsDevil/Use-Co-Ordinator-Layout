package com.example.useco_ordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * fab_snackBar leads us to the first stage click i.e where we set snack bar and fab actions
         * button2 leads us to the second stage click i.e anchoring our fab with Recycler view
         * button3 Leads us to the third stage click i.e collapsing toolbar (AppbarLayout, Collapsing toolbar and toolbar)
         * button Leads us to final stage i.e we add custom behaviour for a fab clicks depending on SnackBar
         */
        findViewById(R.id.fab_snackBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FabAndSnackBar.class));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FabFollowWidget.class));
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CollapsingToolbar.class));
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CustomBehaviour.class));
            }
        });
    }
}