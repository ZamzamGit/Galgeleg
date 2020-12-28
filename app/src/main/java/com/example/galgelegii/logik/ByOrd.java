package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class ByOrd implements Ord {

    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("Paris");
        muligeOrd.add("København");
        muligeOrd.add("Beirut");
        muligeOrd.add("Barcelona");
        muligeOrd.add("Istanbul");
        muligeOrd.add("Berlin");
        muligeOrd.add("Oslo");
        muligeOrd.add("Prag");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}
