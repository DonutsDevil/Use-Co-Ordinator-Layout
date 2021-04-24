package com.example.useco_ordinatorlayout.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useco_ordinatorlayout.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {
    ArrayList<String> data;
    Context context;
    public RecyclerAdapter(Context context, ArrayList<String> data){
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_layout,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Holder holder, int position) {
        holder.setTextViewText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text);
        }

        private void setTextViewText(String data){
            mTextView.setText(data);
        }
    }
}
