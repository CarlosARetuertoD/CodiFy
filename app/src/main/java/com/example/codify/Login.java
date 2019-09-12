package com.example.codify;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private TextView welcome;
    private Typeface Nikolas ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String fuente1 = "fuentes/Nikolas.ttf";
        this.Nikolas = Typeface.createFromAsset(getAssets(),fuente1);

        welcome=(TextView) findViewById(R.id.Welcome);
        welcome.setTypeface(Nikolas);
    }
}
