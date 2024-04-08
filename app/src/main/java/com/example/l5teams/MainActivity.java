package com.example.l5teams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView txtGame;

    GameList gList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       gList = new GameList();

        gList.add(new Game("Hearts - PAOK", 1, 2));
        gList.add(new Game("Olympiakos - Cukaricki", 3, 1));
        gList.add(new Game("Antwerp - AEK", 1, 0));
        gList.add(new Game("Braga - Panathinaikos", 2, 1));

        txtGame = findViewById(R.id.txt);
        txtGame.setText(gList.nextGame());

    }

    public void nextMatch (View view){

        txtGame.setText(gList.nextGame());

   }

    public void showResults (View view) {

        Toast.makeText(getApplicationContext(), "The Winner is " + gList.getGame(gList.getGameCounter()).gameWinner(),
                Toast.LENGTH_SHORT).show();
    }
}