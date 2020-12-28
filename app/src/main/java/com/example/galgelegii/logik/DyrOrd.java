package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class DyrOrd implements Ord {

    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("Gorilla");
        muligeOrd.add("Hund");
        muligeOrd.add("Løve");
        muligeOrd.add("Kænguru");
        muligeOrd.add("Næsehorn");
        muligeOrd.add("Tiger");
        muligeOrd.add("Pingvin");
        muligeOrd.add("Isbjørn");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
