package com.example.useco_ordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class FabAndSnackBar extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    private Toast mToast;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_and_snack_bar);
        coordinatorLayout = findViewById(R.id.coordinator);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar s = Snackbar.make(coordinatorLayout,
                        "Hey, learning co-ordinator layout is fun",
                        Snackbar.LENGTH_LONG).setAction("Toast", null);
                s.show();
            }
        });

    }


}