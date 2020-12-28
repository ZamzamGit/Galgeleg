package com.example.galgelegii.logik;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrdFactory {

    private static OrdFactory instance = new OrdFactory();
    private static final Map<String, Ord> ordKategori = new HashMap<>();

    static {
        ordKategori.put("ord fra dr", new DrOrd());
        ordKategori.put("ord fra regneark", new RegnearkOrd());
        ordKategori.put("lande", new LandeOrd());
        ordKategori.put("brands", new BrandOrd());
        ordKategori.put("mad", new MadOrd());
        ordKategori.put("byer", new ByOrd());
        ordKategori.put("dyr", new DyrOrd());
    }

    private OrdFactory() {
    }

    public static OrdFactory getInstance() {
        return instance;
    }

    public Ord getOrd(String kategori) {
        return ordKategori.get(kategori);
    }
}
