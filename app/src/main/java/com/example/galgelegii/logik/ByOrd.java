package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class ByOrd implements Ord {

    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("paris");
        muligeOrd.add("københavn");
        muligeOrd.add("beirut");
        muligeOrd.add("barcelona");
        muligeOrd.add("istanbul");
        muligeOrd.add("berlin");
        muligeOrd.add("oslo");
        muligeOrd.add("prag");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
