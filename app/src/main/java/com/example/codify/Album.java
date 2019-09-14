package com.example.codify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
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
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Album extends AppCompatActivity {

    TextView txalbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ExtraerJSON("https://api.spotify.com/v1/me/albums");
        txalbum = findViewById(R.id.txAlbum);
    }

    RequestQueue mRequestQueue;
    private void ExtraerJSON(String urlspoty) {

        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonresponse) {
                //EN response tenemos todo el JSON para manajarlo
                Log.e("Responsess",jsonresponse);

                try {
                    JSONArray items = new JSONObject(jsonresponse).getJSONArray("items");

                    for(int i=0;i<items.length();i++){
                        JSONObject json_data = items.getJSONObject(i);


                        JSONObject jalbum = json_data.getJSONObject("album");

                        String nombrealbum = jalbum.getString("name");
                        txalbum.setText(nombrealbum);

                       /* //Extraer Imagenes
                        JSONArray imageslist = json_data.getJSONArray("images");
                        JSONObject img_data = imageslist.getJSONObject(0);


                        TextView tx= new TextView(getBaseContext());
                        ImageView img = new ImageView(getBaseContext());
                        //loadImage(img, img_data.getString("url"));

                        //linearLayout.addView(img);
                        tx.setText(json_data.getString("name"));
                        //linearLayout.addView(tx);*/
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
                "https://api.spotify.com/v1/me/albums",
                response_listener,response_error_listener)
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Bearer BQC7U9QjCY8TtVBhNexOqLlW3CIoAPcH2ZoZtj-udCPm5eBUvAgh0BRkf7YM2clm4lcSkfbrPj-JbLusQZGQuyPL7pnnO38qPfpKBAW_nwSN9Wq9bjvjViTZxPfW72uhq2MtuBbeXFCczQPW-B7B1gCNKNi_kU0VWtnu2A-zXPCO");

                return params;
            }
        };
        getRequestQueue().add(stringRequest);
    }


        public RequestQueue getRequestQueue() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(getApplicationContext());
            }
            return mRequestQueue;
        }


    }
