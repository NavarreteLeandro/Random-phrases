package com.example.frasesrandom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.frasesrandom.Data.Frase;
import com.example.frasesrandom.Data.FraseRepository;

import java.util.ArrayList;
import java.util.List;

public class FrasesViewModel extends AndroidViewModel {

    private FraseRepository mRepository;

    private static LiveData<List<Frase>> frases;

    public FrasesViewModel(@NonNull Application application) {
        super(application);
        mRepository = new FraseRepository(application);
        frases = mRepository.getAllFrases();
    }

    public static LiveData<List<Frase>> getAllFrases() {
        return frases;
    }

    public void insert(Frase frase){
        mRepository.insert(frase);
    }

    public static String Mixer(LiveData<List<Frase>> frases) {

        String[] division;

        List<String> primeraParte = new ArrayList<>();
        List<String> segundaParte = new ArrayList<>();



        for (Frase frase : frases.getValue()) {
            division = frase.getFrase().split(",");
            primeraParte.add(division[0]);
            segundaParte.add(division[1]);
        }

        int primerValorAlAzar = (int) (Math.random() * (primeraParte.size()));
        int segundoValorAlAzar = (int) (Math.random() * (segundaParte.size()));

        String fraseRandom = primeraParte.get(primerValorAlAzar) + "," + segundaParte.get(segundoValorAlAzar);

        return fraseRandom;
    }

}
