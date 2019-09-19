package com.example.codify;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaylistHolder extends RecyclerView.ViewHolder {
    TextView nombrecancion, nombreartista;
    PlaylistAdapter adapter;

    public PlaylistHolder(@NonNull View itemView, final PlaylistAdapter adapter) {
        super(itemView);
        this.adapter = adapter;
        nombrecancion = itemView.findViewById(R.id.txt_nombrecancion);
        nombreartista = itemView.findViewById(R.id.txt_artistacancion);

    }
}
