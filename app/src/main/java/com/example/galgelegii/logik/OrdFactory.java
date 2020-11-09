package com.example.galgelegii.logik;

public class OrdFactory {

    private static OrdFactory instance = new OrdFactory();

    private OrdFactory() {
    }

    public static OrdFactory getInstance() {
        return instance;
    }

    public Ord getOrd(String ordType) {
        if (ordType == null) {
            return null;
        }
        if (ordType.equalsIgnoreCase("dr")) {
            return new DrOrd();
        } else if (ordType.equalsIgnoreCase("regneark")) {
            return new RegnearkOrd();
        }
        return null;
    }
}
