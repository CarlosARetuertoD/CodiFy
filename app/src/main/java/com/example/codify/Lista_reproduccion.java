package com.example.codify;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista_reproduccion extends AppCompatActivity {

    ListView list_musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reproduccion);

        list_musica = findViewById(R.id.list_musica);

        String [] album_luis_fonsi = new String[]{

                "\"Yo No Sé Mañana\" \n(Jorge Luís Piloto, Jorge Villamizar) - 4:19",
                "\"Cómo Volver a Ser Feliz\" \n(Amaury Gutiérrez, Luis Enrique Mejia) - 4:11",
                "\"Sonríe\" \n(Sergio George, Mejia, Fernando Osorio) - 4:14",
                "\"Sombras Nada Más\" \n(Jose Maria Contursi, Francisco Lomuso) - 4:27",
                "\"Parte de Este Juego\" \n(Gianmarco Zignago) - 4:02",
                "\"No Me Des la Espalda\" \n(Gutierrez) - 4:46",
                "\"Autobiografía\" \n(Mejia, Piloto) - 4:34",
                "\"Cambia\" \n(Carlos Varela) - 4:59",
                "\"Inocencia\" \n(Mejia, Osorio) - 4:19",
                "\"Abre Tus Ojos\" \n(Mejia, Osorio ) - 3:47",
                "\"Yo No Sé Mañana\" \n(Piloto, Villamizar) (Pop Version) - 3:51",
        };
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,album_luis_fonsi){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if(position %2 == 1){
                    view.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                }else{
                    view.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                }
                return view;
            }
        };

        list_musica.setAdapter(Adapter);
    }
}
