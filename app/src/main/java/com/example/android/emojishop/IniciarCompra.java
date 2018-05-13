package com.example.android.emojishop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class IniciarCompra extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    ListView list_comrpas_agregadas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_compra);
        list_comrpas_agregadas = findViewById(R.id.listaAgregados);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayPrueba,
                android.R.layout.simple_list_item_1);

        list_comrpas_agregadas.setAdapter(adaptador);


        list_comrpas_agregadas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }
        });



    }

    public void goArticlesList(View view) {
        Intent intent = new Intent(this, listaArticulos.class);
        startActivity(intent);
    }
}
