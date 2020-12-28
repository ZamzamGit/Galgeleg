package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class LandeOrd implements Ord {

    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("Danmark");
        muligeOrd.add("Ghana");
        muligeOrd.add("Sverige");
        muligeOrd.add("Frankrig");
        muligeOrd.add("Brasilien");
        muligeOrd.add("Peru");
        muligeOrd.add("Canada");
        muligeOrd.add("Japan");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
