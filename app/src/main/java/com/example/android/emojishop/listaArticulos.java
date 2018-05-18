package com.example.android.emojishop;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
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
    MediaPlayer zeldaSound;
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos);
        zeldaSound = MediaPlayer.create(this,R.raw.heartcontainer);

        creacionRecycler();
    }
    /*Se crea el metodo creacionRecycler para poder crear el recycler en conjunto con el adaptador que va a manejar las vistas */
    private void creacionRecycler() {

        listaEmojies =new ArrayList<>();
        recyclerEmojies = findViewById(R.id.recyclerview);

        llenarRecycler();



        adapterEmojies adapter = new adapterEmojies(listaEmojies);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = getApplicationContext();
                String emogieseleccionado =  listaEmojies.get(recyclerEmojies.getChildAdapterPosition(v)).getNombre();

                Toast.makeText(context,getString(R.string.orden) + emogieseleccionado, Toast.LENGTH_SHORT).show();
                zeldaSound.start();

                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, emogieseleccionado);
                setResult(RESULT_OK, replyIntent);
                finish();


            }
        });

        recyclerEmojies.setAdapter(adapter);

        recyclerEmojies.setLayoutManager(new LinearLayoutManager(this));



    }
    /*Se crea el metodo llenarRecycler para hacer la lista de los articulos de compra */
    private void llenarRecycler() {

        listaEmojies.add(new emojiesItems(getString(R.string.braces),getString(R.string.descripcion_braces),R.drawable.braces));
        listaEmojies.add(new emojiesItems(getString(R.string.carcajada),getString(R.string.descripcion_carcajada),R.drawable.carcajada2));
        listaEmojies.add(new emojiesItems(getString(R.string.cool),getString(R.string.descripcion_cool),R.drawable.cool2));
        listaEmojies.add(new emojiesItems(getString(R.string.enamorado),getString(R.string.descripcion_enamorado),R.drawable.ena));
        listaEmojies.add(new emojiesItems(getString(R.string.gato),getString(R.string.descripcion_gato),R.drawable.gato2));
        listaEmojies.add(new emojiesItems(getString(R.string.helado),getString(R.string.descripcion_helado),R.drawable.helado2));
        listaEmojies.add(new emojiesItems(getString(R.string.cara_duda),getString(R.string.descripcion_cara_duda),R.drawable.duda2));
        listaEmojies.add(new emojiesItems(getString(R.string.angel),getString(R.string.descripcion_angel),R.drawable.angel));
        listaEmojies.add(new emojiesItems(getString(R.string.frustrado),getString(R.string.descripcion_frustrado),R.drawable.frustrado));
        listaEmojies.add(new emojiesItems(getString(R.string.muerto),getString(R.string.descripcion_muerto),R.drawable.muerto));
        listaEmojies.add(new emojiesItems(getString(R.string.lengua_afuera),getString(R.string.descripcion_lengua_afuera),R.drawable.lengua));
        listaEmojies.add(new emojiesItems(getString(R.string.ruborizado),getString(R.string.descripcion_ruborizado),R.drawable.ruborizado));
        listaEmojies.add(new emojiesItems(getString(R.string.lengua_afuera1),getString(R.string.descripcion_lengua_afuera2),R.drawable.lengua2));
        listaEmojies.add(new emojiesItems(getString(R.string.sonrisa),getString(R.string.descripcion_sonrisa),R.drawable.sonrisa));
        listaEmojies.add(new emojiesItems(getString(R.string.abrazo),getString(R.string.descripcion_abrazo),R.drawable.abrazo));
        listaEmojies.add(new emojiesItems(getString(R.string.asustado),getString(R.string.descripcion_asustado),R.drawable.asustado));
        listaEmojies.add(new emojiesItems(getString(R.string.dormilon),getString(R.string.descripcion_dormilon),R.drawable.dormilon));
        listaEmojies.add(new emojiesItems(getString(R.string.nerd),getString(R.string.descripcion_nerd),R.drawable.nerd));
        listaEmojies.add(new emojiesItems(getString(R.string.dientes),getString(R.string.descripcion_dientes),R.drawable.dientes));
        listaEmojies.add(new emojiesItems(getString(R.string.furioso),getString(R.string.descripcion_furioso),R.drawable.furioso));
        listaEmojies.add(new emojiesItems(getString(R.string.sorprendido),getString(R.string.descripcion_sorprendido),R.drawable.sorprendio));
    }
}
