package com.example.useco_ordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.useco_ordinatorlayout.Utils.RecyclerAdapter;
import com.example.useco_ordinatorlayout.Utils.RecyclerUtils;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FabFollowWidget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_follow_widget);
        findViewById(R.id.fab_snackBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"This is me",Snackbar.LENGTH_LONG).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(RecyclerUtils.getLinearLayoutManager(this));
        recyclerView.setAdapter(RecyclerUtils.getAdapter(this));
        recyclerView.setHasFixedSize(true);
    }
}