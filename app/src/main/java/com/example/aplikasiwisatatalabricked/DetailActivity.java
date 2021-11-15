package com.example.aplikasiwisatatalabricked;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_detail);

        TextView namaWisata = findViewById(R.id.nama_wisata);
        TextView kategori = findViewById(R.id.detail_kategori);
        ImageView gambarWisata = findViewById(R.id.gambar_wisata);

        namaWisata.setText(getIntent().getStringExtra("namaWisata"));
        kategori.setText(getIntent().getStringExtra( "kategori"));
        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra("gambarWisata"))
                .into(gambarWisata);
    }
}