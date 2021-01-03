package com.example.galgelegii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class KategoriAktivitet extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_aktivitet);

        listView = findViewById(R.id.kategoriList);

        ArrayList<String> kategorier = new ArrayList<>();
        kategorier.add("Byer");
        kategorier.add("Lande");
        kategorier.add("Brands");
        kategorier.add("Mad");
        kategorier.add("Dyr");
        kategorier.add("Ord fra DR");
        kategorier.add("Ord fra Regneark");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, kategorier);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String kategori = adapterView.getItemAtPosition(i).toString();
        Intent spil = new Intent(this, GameActivity.class);
        spil.putExtra("kategori", kategori);
        startActivity(spil);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}