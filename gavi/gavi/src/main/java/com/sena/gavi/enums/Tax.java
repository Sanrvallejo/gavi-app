package com.sena.gavi.enums;

public enum Tax {
    IVA19(0.19),
    IVA5(0.05),
    NOT_IVA(1.0);

    private final double rate;

    Tax(Double rate) {
        this.rate = rate;
    }
}
