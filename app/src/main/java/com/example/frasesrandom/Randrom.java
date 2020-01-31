package com.example.frasesrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Randrom extends AppCompatActivity {

    private TextView fraseRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randrom);

        fraseRandom = (TextView) findViewById(R.id.frase_aleatoria);
        String fraseAleatoria = Frases.Mixer(Frases.frases);
        fraseRandom.setText(fraseAleatoria);
    }

}
