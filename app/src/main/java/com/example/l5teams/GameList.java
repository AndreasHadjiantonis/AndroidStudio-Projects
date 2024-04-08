package com.example.l5teams;

import java.util.ArrayList;

public class GameList {

    private ArrayList<Game> gl = new ArrayList<>();
    private int gameCounter = 0;
    private boolean firstGame = true;

    public void add(Game g) {

        gl.add(g);
    }
    public String nextGame(){


        int size = gl.size();
        if(gameCounter < size - 1){

            if (gameCounter == 0 && firstGame == true) {
                firstGame = false;
                return gl.get(gameCounter).getMatch();
            }
            gameCounter++;
            return gl.get(gameCounter).getMatch();
        }
        else {
            gameCounter = 0;
            return gl.get(gameCounter).getMatch();
        }
    }

    public Game getGame(int pos){

        return gl.get(pos);
    }

    public int getGameCounter() {
        return gameCounter;
    }
}
