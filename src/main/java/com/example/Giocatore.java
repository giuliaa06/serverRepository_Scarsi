package com.example;

public class Giocatore {
    private String name;
    private int tentativi;

    private Giocatore(String n, int t) {
        this.name = n;
        this.tentativi = t;
    }

    public String getName() {
        return name;
    }

    public int getTentativi() {
        return tentativi;
    }

}
