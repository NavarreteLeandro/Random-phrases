package com.example.frasesrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RandomActivity extends AppCompatActivity {

    private TextView fraseRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randrom);

        fraseRandom = (TextView) findViewById(R.id.frase_aleatoria);
        String fraseAleatoria = FrasesViewModel.Mixer(FrasesViewModel.getAllFrases());
        fraseRandom.setText(fraseAleatoria);
    }

}
