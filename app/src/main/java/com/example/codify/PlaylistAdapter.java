package com.example.codify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistHolder> {
    List<ItemPlaylist> data;
    LayoutInflater inflater;
    Context c;

    public PlaylistAdapter(Context c,List<ItemPlaylist> data) {
        this.data = data;
        inflater = LayoutInflater.from(c);
        this.c = c;
    }

    @NonNull
    @Override
    public PlaylistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.item_album,parent,false);
        return new PlaylistHolder(v,this);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistHolder holder, int position) {
        holder.nombrecancion.setText(data.get(position).getNombrecancion());
        holder.nombreartista.setText(data.get(position).getNombreartista());
    }

    @Override
    public int getItemCount() {
        return  data.size();
    }
}
