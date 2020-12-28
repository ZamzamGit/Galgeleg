package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class BrandOrd implements Ord{


    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("facebook");
        muligeOrd.add("gucci");
        muligeOrd.add("microsoft");
        muligeOrd.add("tesla");
        muligeOrd.add("volkswagen");
        muligeOrd.add("sony");
        muligeOrd.add("apple");
        muligeOrd.add("nike");
        muligeOrd.add("adidas");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}

