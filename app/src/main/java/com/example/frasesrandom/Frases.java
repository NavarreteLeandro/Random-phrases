package com.example.frasesrandom;

import java.util.ArrayList;
import java.util.List;

public class Frases {

    public static List<String> frases = new ArrayList<String>();

    public static String Mixer(List<String> frases) {

        String[] division;

        List<String> primeraParte = new ArrayList<>();
        List<String> segundaParte = new ArrayList<>();

        for (String frase : frases) {
            division = frase.split(",");
            primeraParte.add(division[0]);
            segundaParte.add(division[1]);
        }

        int primerValorAlAzar = (int) (Math.random() * (primeraParte.size()));
        int segundoValorAlAzar = (int) (Math.random() * (segundaParte.size()));

        String fraseRandom = primeraParte.get(primerValorAlAzar) + "," + segundaParte.get(segundoValorAlAzar);

        return fraseRandom;
    }


}
