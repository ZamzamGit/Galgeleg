package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class MadOrd implements Ord {
    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("Burger");
        muligeOrd.add("Pizza");
        muligeOrd.add("Banankage");
        muligeOrd.add("Spaghetti");
        muligeOrd.add("Laks");
        muligeOrd.add("Chokolade");
        muligeOrd.add("Agurk");
        muligeOrd.add("Ost");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
