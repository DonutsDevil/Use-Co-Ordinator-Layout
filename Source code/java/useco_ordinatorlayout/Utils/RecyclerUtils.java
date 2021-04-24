package com.example.useco_ordinatorlayout.Utils;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/**
 * Utils to set our adapter and Layout manager for our Recycler View
 */
public class RecyclerUtils {
    // Private cause we don't want to make object ofd this class it acts as utils.
    private RecyclerUtils(){}

    public static LinearLayoutManager getLinearLayoutManager(Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        return layoutManager;
    }

    public static RecyclerAdapter getAdapter(Context context){
        ArrayList<String> data;
        data = new ArrayList<>();
        for(int i = 0 ; i < 30 ; i++) {
            data.add("It's Fun, Here Naruto");
        }
        RecyclerAdapter adapter = new RecyclerAdapter(context,data);
        return adapter;
    }
}
