package com.example.cards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    TextView textViewWin;
    Button btnToMainMenu;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        textViewWin = findViewById(R.id.textViewWin);
        btnToMainMenu = findViewById(R.id.btnToMainMenu);
        constraintLayout = findViewById(R.id.constrLayout);

        String winnerPlayer = getIntent().getStringExtra("winner");
        textViewWin.setText("Player " + winnerPlayer + " wins");
        if (winnerPlayer.equals("1")) {
            constraintLayout.setBackgroundColor(Color.RED);
        } else {
            constraintLayout.setBackgroundColor(Color.BLUE);
        }
        btnToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMenuActivity = new Intent(WinActivity.this, MenuActivity.class);
                startActivity(toMenuActivity);
            }
        });
    }
}