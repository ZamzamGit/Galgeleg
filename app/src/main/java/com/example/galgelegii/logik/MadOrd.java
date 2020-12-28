package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class MadOrd implements Ord {
    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("burger");
        muligeOrd.add("pizza");
        muligeOrd.add("banankage");
        muligeOrd.add("spaghetti");
        muligeOrd.add("laks");
        muligeOrd.add("chokolade");
        muligeOrd.add("agurk");
        muligeOrd.add("ost");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
