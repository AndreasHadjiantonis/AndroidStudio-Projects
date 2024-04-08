package com.example.l5teams;

public class Game {

    private String match;
    private int t1;
    private int t2;
    public Game(String match, int t1, int t2) {
        this.match = match;
        this.t1 = t1;
        this.t2 = t2;
    }

    public String getMatch() {
        return match;
    }

    public String gameWinner () {

        String[] separate = match.split("-");

        if(t1 > t2)
            return separate[0];
        else if(t2 > t1)
            return separate[1];

        return "TIE";
    }


}
