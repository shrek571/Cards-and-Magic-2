package com.example.cards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class ContinueActivity extends AppCompatActivity {

    CustomAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        String playerS = getIntent().getStringExtra("player");
        String turnsS = getIntent().getStringExtra("turns");
        String currentCardS = getIntent().getStringExtra("currentCard");
        String p1classS = getIntent().getStringExtra("p1class");
        String p2classS = getIntent().getStringExtra("p2class");
        String yourHpS = getIntent().getStringExtra("yourHp");
        String enemyHpS = getIntent().getStringExtra("enemyHp");
        String yourManaS = getIntent().getStringExtra("yourMana");
        String enemyManaS = getIntent().getStringExtra("enemyMana");
        final String dateAndTimeS = getIntent().getStringExtra("dateAndTime");

        if (playerS == null) {
            final Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    final List<SavedGame> sgList = SavedGamesDatabase.getDatabase(getApplicationContext()).savedGameDAO().getAllSavedGames();
                    SavedGamesDatabase.getDatabase(getApplicationContext()).savedGameDAO().deleteAll();
                    CustomAdapter.gamesList.clear();

                    for (int i = 0; i < sgList.size(); i++) {
                        SavedGame inserted = sgList.get(i);
                        SavedGamesDatabase.getDatabase(getApplicationContext()).savedGameDAO().insert(inserted);
                        CustomAdapter.gamesList.add(inserted);
                    }

                }

            };

            Thread thread1 = new Thread(runnable1);
            thread1.start();

        } else {
            String act = getIntent().getStringExtra("act");
            if (act.equals("G")) {

                final SavedGame savedGame1 = new SavedGame(playerS, turnsS, currentCardS, p1classS, p2classS, yourHpS, enemyHpS, yourManaS, enemyManaS, dateAndTimeS);
                SavedGamesDatabase.getDatabase(getApplicationContext());

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        SavedGamesDatabase.getDatabase(getApplicationContext()).savedGameDAO().insert(savedGame1);
                        CustomAdapter.gamesList.add(savedGame1);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                Toast.makeText(ContinueActivity.this, "Игра сохранена", Toast.LENGTH_SHORT).show();
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();

        recyclerView.setAdapter(adapter);

        Button btnToMenuActivity = findViewById(R.id.btnToMenuActivity);
        btnToMenuActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenuActivity = new Intent(ContinueActivity.this, MenuActivity.class);
                startActivity(toMenuActivity);
            }
        });
    }
}