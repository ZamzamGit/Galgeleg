package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class LandeOrd implements Ord {

    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("danmark");
        muligeOrd.add("ghana");
        muligeOrd.add("sverige");
        muligeOrd.add("frankrig");
        muligeOrd.add("brasilien");
        muligeOrd.add("peru");
        muligeOrd.add("canada");
        muligeOrd.add("japan");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
