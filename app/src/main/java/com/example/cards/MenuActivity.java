package com.example.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnCreateGame = findViewById(R.id.btnCreateGame);
        btnCreateGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toCreategameActivity = new Intent(MenuActivity.this, CreategameActivity.class);
                startActivity(toCreategameActivity);
            }
        });
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTitleActivity = new Intent(MenuActivity.this, TitleActivity.class);
                startActivity(toTitleActivity);
            }
        });
        Button btnReadRules = findViewById(R.id.btnReadRules);
        btnReadRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRulesActivity = new Intent(MenuActivity.this, RulesActivity.class);
                startActivity(toRulesActivity);
            }
        });
        Button btnContinueGame = findViewById(R.id.btnContinueGame);
        btnContinueGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toContinueActivity = new Intent(MenuActivity.this, ContinueActivity.class);
                String act = "M";
                toContinueActivity.putExtra("act", act);
                startActivity(toContinueActivity);
            }
        });
        Button btnDelGames = findViewById(R.id.btnDelGames);
        btnDelGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        SavedGamesDatabase.getDatabase(getApplicationContext()).savedGameDAO().deleteAll();
                        CustomAdapter.gamesList.clear();
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();

                Toast.makeText(MenuActivity.this, "Все игры удалены", Toast.LENGTH_SHORT).show();
            }
        });
    }
}