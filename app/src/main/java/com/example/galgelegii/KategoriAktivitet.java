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

        ArrayList<String> city = new ArrayList<>();

        city.add("Byer");
        city.add("Lande");
        city.add("Brands");
        city.add("Mad");
        city.add("Dyr");
        city.add("Ord fra DR");
        city.add("Ord fra Regneark");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, city);
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
}