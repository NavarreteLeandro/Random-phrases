package com.example.frasesrandom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import android.widget.EditText;

import com.example.frasesrandom.Data.Frase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private AdapterFrases adapterFrases;

    private FrasesViewModel mFrasesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrasesViewModel = new ViewModelProvider(this).get(FrasesViewModel.class);

        mFrasesViewModel.getAllFrases().observe(this, new Observer<List<Frase>>() {

            @Override
            public void onChanged(List<Frase> frases) {
                adapterFrases.setFrases(frases);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        adapterFrases = new AdapterFrases(this);
        recyclerView.setAdapter(adapterFrases);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

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
        Class destinityClass = RandomActivity.class;

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
                    mFrasesViewModel.insert(new Frase(m_Text));
                }
            });

            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
