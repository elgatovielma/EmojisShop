package com.example.android.emojishop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Creando");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "Carga bien");
        RelativeLayout fondo1 = findViewById(R.id.activity1);
        fondo1.setOnTouchListener(this);

    }

    /*Se implenta el metodo onTouch para que al momento que el usuario toque cualquier lado de la pantalla, esta
     * se dirija a la lista con los articulos de compra*/
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = new Intent(this, IniciarCompra.class);
        startActivity(intent);
        return false;
    }
}
