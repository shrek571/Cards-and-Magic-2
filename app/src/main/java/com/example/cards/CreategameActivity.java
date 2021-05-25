package com.example.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CreategameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creategame);

        final Integer[] p1class = new Integer[1];
        final Integer[] p2class = new Integer[1];

        final TextView textViewP1Info = findViewById(R.id.textViewP1Info);
        final TextView textViewP2Info = findViewById(R.id.textViewP2Info);

        RadioButton humansP1 = findViewById(R.id.humansP1);
        RadioButton robotsP1 = findViewById(R.id.robotsP1);
        RadioButton plantsP1 = findViewById(R.id.plantsP1);
        RadioButton higherbeingsP1 = findViewById(R.id.higherbeingsP1);

        RadioButton humansP2 = findViewById(R.id.humansP2);
        RadioButton robotsP2 = findViewById(R.id.robotsP2);
        RadioButton plantsP2 = findViewById(R.id.plantsP2);
        RadioButton higherbeingsP2 = findViewById(R.id.higherbeingsP2);

        humansP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP1Info.setText("Основной класс игры.\nЛюди сбалансированны и довольно слабы, зато просты в освоении");
                p1class[0] = 1;
            }
        });
        robotsP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP1Info.setText("Побеждайте, используя хитрость.\nТехнологии роботов позволят оставить ваших соперников без энергии.");
                p1class[0] = 2;
            }
        });
        plantsP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP1Info.setText("Используйте множество заклинаний для победы, получая вдвое больше маны.\nВы также можете регенерировать лучше, чего не скажешь об уроне");
                p1class[0] = 3;
            }
        });
        higherbeingsP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP1Info.setText("Получите невероятную силу от сверхсуществ, сметая врагов на своём пути.\nНо с большой силой приходит большая ответственность - у вас не хватает маны для такой силы");
                p1class[0] = 4;
            }
        });
//----------------------------------------------------------------------------------------------------------
        humansP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP2Info.setText("Основной класс игры.\nЛюди сбалансированны и довольно слабы, зато просты в освоении");
                p2class[0] = 1;
            }
        });
        robotsP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP2Info.setText("Побеждайте, используя хитрость.\nТехнологии роботов позволят оставить ваших соперников без энергии.");
                p2class[0] = 2;
            }
        });
        plantsP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP2Info.setText("Используйте множество заклинаний для победы, получая вдвое больше маны.\nВы также можете регенерировать лучше, чего не скажешь об уроне");
                p2class[0] = 3;
            }
        });
        higherbeingsP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewP2Info.setText("Получите невероятную силу от сверхсуществ, сметая врагов на своём пути.\nНо с большой силой приходит большая ответственность - у вас не хватает маны для такой силы");
                p2class[0] = 4;
            }
        });

        Button btnStartGame = findViewById(R.id.btnStartGame);
        Button btnToMenuActivity = findViewById(R.id.btnToMenuActivity);

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (p1class[0] != null && p2class[0] != null) {
                    Intent toGameActivity = new Intent(CreategameActivity.this, GameActivity.class);
                    toGameActivity.putExtra("p1class", p1class[0].toString());
                    toGameActivity.putExtra("p2class", p2class[0].toString());
                    String act = "Cr";
                    toGameActivity.putExtra("act", act);
                    startActivity(toGameActivity);
                } else {
                    Toast.makeText(CreategameActivity.this, "Выберите оба класса для начала", Toast.LENGTH_SHORT);
                }
            }
        });

        btnToMenuActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenuActivity = new Intent(CreategameActivity.this, MenuActivity.class);
                startActivity(toMenuActivity);
            }
        });
    }
}