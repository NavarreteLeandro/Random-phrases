package com.example.frasesrandom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText fraseIngresada;

    private Button boton;

    private RecyclerView recyclerView;

    private AdapterFrases adapterFrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boton = (Button) findViewById(R.id.button_id);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterFrases = new AdapterFrases(Frases.frases);
        recyclerView.setAdapter(adapterFrases);

    }

    public void appendText() {

        fraseIngresada = (EditText) findViewById(R.id.plain_text_input);
        Frases.frases.add(fraseIngresada.getText().toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.frase_random, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Class destinityClass = Randrom.class;

        if (id == R.id.action_random_frase) {
            Intent randromActivity = new Intent(this, destinityClass);
            startActivity((randromActivity));
        }

        return super.onOptionsItemSelected(item);
    }
}
