package com.example.android.emojishop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class listaArticulos extends AppCompatActivity {

    ArrayList<emojiesItems> listaEmojies;
    RecyclerView recyclerEmojies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos);

        creacionRecycler();
    }

    private void creacionRecycler() {

        listaEmojies =new ArrayList<>();
        recyclerEmojies = findViewById(R.id.recyclerview);

        llenarRecycler();

        adapterEmojies adapter = new adapterEmojies(listaEmojies);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = getApplicationContext();
                Toast.makeText(context,getString(R.string.orden) +
                        listaEmojies.get(recyclerEmojies.getChildAdapterPosition(v)).getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        recyclerEmojies.setAdapter(adapter);

        recyclerEmojies.setLayoutManager(new LinearLayoutManager(this));



    }

    private void llenarRecycler() {

        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz2","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz3","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","Es un emojie muy feliz",R.drawable.donut_circle));
        listaEmojies.add(new emojiesItems("Carita Feliz","asdasdsaadaadsasaddsaaasdasdasasdassaassaasdsadasasdasdsaaasadsassda",R.drawable.donut_circle));
    }
}
