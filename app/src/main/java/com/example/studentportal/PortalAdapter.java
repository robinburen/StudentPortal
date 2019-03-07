package com.example.studentportal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {

    private List<Portal> mPortals;

    public PortalAdapter(List<Portal> mPortals) {
        this.mPortals = mPortals;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, null);

        // Return a new holder instance
        PortalAdapter.ViewHolder viewHolder = new PortalAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PortalAdapter.ViewHolder viewHolder, int i) {
        final Portal portal = mPortals.get(i);
        viewHolder.textView.setText(portal.getmPortalText());
    }

    @Override
    public int getItemCount() {
        return mPortals.size();
    }
}
