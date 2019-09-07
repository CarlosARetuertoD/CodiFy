package com.example.codify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class Album extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        LinearLayout layout=findViewById(R.id.layout);
        ImageView img= new ImageView(getBaseContext());
        ImageView img1= new ImageView(getBaseContext());
        ImageView img2= new ImageView(getBaseContext());


        loadImage(img, "https://images.genius.com/dc2572caf975df705384d4cb73fcd632.1000x1000x1.jpg");
        loadImage(img1,"https://img.europapress.es/fotoweb/fotonoticia_20160128125559_800.jpg");
        loadImage(img2,"https://periodicoabcrm.blob.core.windows.net/images/2019/05/09/cropw0h0frff.jpg");

        layout.addView(img);
        layout.addView(img1);
        layout.addView(img2);



        LinearLayout layout2=findViewById(R.id.layout2);
        ImageView img_2= new ImageView(getBaseContext());
        ImageView img1_2= new ImageView(getBaseContext());
        ImageView img2_2= new ImageView(getBaseContext());


        loadImage(img_2, "https://images.genius.com/dc2572caf975df705384d4cb73fcd632.1000x1000x1.jpg");
        loadImage(img1_2,"https://img.europapress.es/fotoweb/fotonoticia_20160128125559_800.jpg");
        loadImage(img2_2,"https://periodicoabcrm.blob.core.windows.net/images/2019/05/09/cropw0h0frff.jpg");

        layout.addView(img_2);
        layout.addView(img1_2);
        layout.addView(img2_2);

    }
    private void loadImage(final ImageView imageView,final  String ImageUrl) {
        Picasso
                .with(getBaseContext())
                .load(ImageUrl)
                .resize(100,100)
                .into(imageView);

    }
}
