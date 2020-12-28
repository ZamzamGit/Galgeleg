package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class DyrOrd implements Ord {

    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("gorilla");
        muligeOrd.add("hund");
        muligeOrd.add("løve");
        muligeOrd.add("kænguru");
        muligeOrd.add("næsehorn");
        muligeOrd.add("tiger");
        muligeOrd.add("pingvin");
        muligeOrd.add("isbjørn");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
