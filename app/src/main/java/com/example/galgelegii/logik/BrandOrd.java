package com.example.galgelegii.logik;

import java.io.IOException;
import java.util.ArrayList;

public class BrandOrd implements Ord{


    @Override
    public void hentOrd(ArrayList<String> muligeOrd) throws IOException {
        muligeOrd.clear();
        muligeOrd.add("Facebook");
        muligeOrd.add("Gucci");
        muligeOrd.add("Microsoft");
        muligeOrd.add("Tesla");
        muligeOrd.add("Volkswagen");
        muligeOrd.add("Sony");
        muligeOrd.add("Apple");
        muligeOrd.add("Nike");
        muligeOrd.add("Adidas");
        System.out.println("muligeOrd = " + muligeOrd);
    }
}

