package com.example.codify;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lista_reproduccion extends AppCompatActivity {

    RecyclerView rv_playlist;
    List<ItemPlaylist> list_playlists;
    //HOLI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reproduccion);

        ExtraerJSON("a");
        rv_playlist = findViewById(R.id.rv_musica);
        list_playlists = new ArrayList<>();

    }

    RequestQueue mRequestQueue;
    private void ExtraerJSON(String urlspoty){
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Responsess",response);
                try{
                    JSONArray items = new JSONObject(response).getJSONArray("items");
                    System.out.println("*****Diego estuvo aqui*****"+items.length());
                   for(int i=0;i<items.length();i++){
                       JSONObject json_data = items.getJSONObject(i);
                       JSONArray artista = json_data.getJSONArray("artists");
                       JSONObject nombreartista = artista.getJSONObject(0);
                        list_playlists.add(new ItemPlaylist(json_data.getString("name"),nombreartista.getString("name"),"2"));
                    }
                    PlaylistAdapter adapterRecyclerView = new PlaylistAdapter(getApplicationContext(), list_playlists);
                    rv_playlist.setAdapter(adapterRecyclerView);
                    rv_playlist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener response_error_listener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //TODO
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "https://api.spotify.com/v1/albums/63irJwZoWLRUc1lBKtuxmQ/tracks",
                response_listener,response_error_listener)
        {

            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Bearer BQD6NcZ66USYw1QvyDR5OcK7PQPhrti-4zv5XCua0vQWSjToCvA2Wt9PCh57COAkXGKaiatOGlVd-Sw9MgBJfG12U1U26GiRz7NbMEf6ktmuq2CJXS871BC9avMCUFgWQ5195Bkfc0QpdOHCMcoS2qvJkDJiL82TYBtH_oZgenjapLTl9H43bDUKCYXGGuaYon8PlfYbZiLkIRas30SXt17yZLcYgJrkdbNn3xQMm2LnF20JeFO6M_lgjXL5t_TcVfmD8DlSBtOzcTjel1BWxiARQ91dipxx");

                return params;
            }
        };

        getmRequestQueue().add(stringRequest);
    }
    public  RequestQueue getmRequestQueue(){
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
}
