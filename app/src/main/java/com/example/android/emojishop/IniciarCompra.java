package com.example.android.emojishop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class IniciarCompra extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG2 = IniciarCompra.class.getSimpleName();
    private static final String LOG_TAG3 = IniciarCompra.class.getSimpleName();
    private static final String LOG_TAG4 = IniciarCompra.class.getSimpleName();
    private static final String LOG_TAG5 = IniciarCompra.class.getSimpleName();
    ListView listViewComprasAgregadas;
    ArrayList<String> listaCompras;
    ArrayList<String> recover;
    ArrayAdapter adaptador;
    ArrayAdapter  adaptadorRecover;
    int count=1;
    int recovercount=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_compra);
        listViewComprasAgregadas = findViewById(R.id.listview);
        listaCompras = new ArrayList<>();
        recover = new ArrayList<>();


        if(savedInstanceState!=null){
            recover = savedInstanceState.getStringArrayList("Mewtwo");
            recovercount=savedInstanceState.getInt("Mew");
            adaptadorRecover = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recover);
            listViewComprasAgregadas.setAdapter(adaptadorRecover);
            listaCompras=recover;
            count = recovercount;
            Log.d(LOG_TAG3, "true123");
            Log.d( LOG_TAG5, "asd");

        }

    }

    /*Se crea el metodo para crear la lista de los articulos, esta no puede exceder un total de 10 articulos*/
    public void goArticlesList(View view) {
        if (count<=10){
            Intent intent = new Intent(this, listaArticulos.class);
            startActivityForResult(intent,TEXT_REQUEST);
        }
        else{
            Toast.makeText(getApplicationContext(),"No puede agregar mas",Toast.LENGTH_SHORT).show();
        }
    }
    /*Metodo utilizado para traer el articulo de la lista a la lista de compras*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {

                adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaCompras);
                String reply = data.getStringExtra(listaArticulos.EXTRA_REPLY);
                
                Log.d( LOG_TAG2, "Creando"+ reply);

                listaCompras.add(reply);
                listViewComprasAgregadas.setAdapter(adaptador);
                count++;

            }
        }
    }
    /*Metodo utilizado para guardar lo que se tiene en la pantalla y que este contenido no se pierda si se rota la misma*/
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList("Mewtwo",listaCompras);
        outState.putInt("Mew", count);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( LOG_TAG4, "STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( LOG_TAG4, "DESTROY");
    }
}
