package com.example.frasesrandom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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

    private RecyclerView recyclerView;

    private AdapterFrases adapterFrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        addFrasesPredeterminadas();
        adapterFrases = new AdapterFrases(Frases.frases);
        recyclerView.setAdapter(adapterFrases);

    }

    public void addFrasesPredeterminadas() {
        Frases.frases.add("El que se fue a Sevilla, perdió su silla.");
        Frases.frases.add("Cocodrilo que se duerme, es cartera.");
        Frases.frases.add("A buen entendedor, pocas palabras.");
        Frases.frases.add("Al que madruga, Dios lo ayuda");
        Frases.frases.add("Billetera, mata galan");
        Frases.frases.add("Mas vale pajaro en mano, que 100 volando");
        Frases.frases.add("Con paciencia y saliva, el elefante se cojio a la hormiga");
        Frases.frases.add("Somos pocos, nos conocemos muchos");
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

        if (id == R.id.action_add_phrase) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Agregue un frase con una coma de separación");

            // Set up the input
            final EditText input = new EditText(this);
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            // Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String m_Text = input.getText().toString();
                    Frases.frases.add(m_Text);
                }
            });

            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
