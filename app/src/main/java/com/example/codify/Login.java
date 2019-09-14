package com.example.codify;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String fuente1 = "fuentes/Nikolas.ttf";


        welcome=(TextView) findViewById(R.id.Welcome);

    }
}
