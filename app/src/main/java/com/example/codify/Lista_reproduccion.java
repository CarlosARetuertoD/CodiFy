package com.example.codify;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import java.util.HashMap;
import java.util.Map;

public class Lista_reproduccion extends AppCompatActivity {

    ListView list_musica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reproduccion);

        list_musica = findViewById(R.id.list_musica);
        ExtraerJSON("a");

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


                    }
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
                "https://api.spotify.com/v1/albums/0UhRsOyE3SzdM51cjS3LVm/tracks",
                response_listener,response_error_listener)
        {

            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Bearer BQAy0NO45nHvYKpd4MggjeGinUrbVEZts9fo75qyPej6YqKDo55ZS-hDuaS3DAU4FbSjsBMZBUE9SdGcCBC6JS-imq21t5IUaZyamFNJ5UBSP95KrCbraAns7H77TwQq54Y0QNp-HTpPSjpHjYvCozS-GLVF2KTIl8CXjGRKFj2lXK1qFvlS5HpxcsunJZXkEY6QksYpvdQ5zXK5oIwtg61HRNSiwa6Acn4rPzS7omd37W4kA6x53yWhwmRLI-VEYvr1h4Pdf1LFmHYxFxjcfeTI8f070BCa");

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
