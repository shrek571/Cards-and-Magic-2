package com.example.cards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private Integer temp;
    private String tempStr;
    private String curClassString;
    private String nextClassString;
    private Integer player;
    private Integer turns;
    private Card currentCard;

    private ArrayList deckP1active = new ArrayList();
    private ArrayList deckP2active = new ArrayList();
    private ArrayList deckTemp = new ArrayList();
    private ArrayList deckGlobal = new ArrayList();

    private ArrayList deckHumans = new ArrayList();
    private ArrayList deckRobots = new ArrayList();
    private ArrayList deckPlants = new ArrayList();
    private ArrayList deckHigherbeings = new ArrayList();
    private Random random = new Random();
    private ConstraintLayout constraintLayout;

    private TextView textTurns;
    private Integer yourHp;
    private Integer enemyHp;
    private Integer yourMana;
    private Integer enemyMana;
    private TextView textYourHp;
    private TextView textEnemyHp;
    private TextView textYourMana;
    private TextView textEnemyMana;

    private TextView textDebug;

    private String actGot;

    public GameActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        constraintLayout = findViewById(R.id.constrLayout);
        mediaPlayer = MediaPlayer.create(this, R.raw.battle);
        mediaPlayer.start();

        /////////////////////////////////////////////////////////////////////////// HUMANS
        Card damage1_h = new Card(1, 1, 1, 0, 0);
        deckHumans.add(damage1_h);
        deckGlobal.add(damage1_h);

        Card heal1_h = new Card(2, 1, 0, 1, 0);
        deckHumans.add(heal1_h);
        deckGlobal.add(heal1_h);

        Card damage2_h = new Card(3, 3, 5, 0, 0);
        deckHumans.add(damage2_h);
        deckGlobal.add(damage2_h);

        Card heal2_h = new Card(4, 3, 0, 4, 0);
        deckHumans.add(heal2_h);
        deckGlobal.add(heal2_h);

        Card ult1_h = new Card(5, 2, 2, 2, 0);
        deckHumans.add(ult1_h);
        deckGlobal.add(ult1_h);
        ///////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////// ROBOTS
        Card damage1_r = new Card(6, 1, 1, 0, 0);
        deckRobots.add(damage1_r);
        deckGlobal.add(damage1_r);

        Card heal1_r = new Card(7, 1, 0, 1, 0);
        deckRobots.add(heal1_r);
        deckGlobal.add(heal1_r);

        Card drain1_r = new Card(8, 2, 0, 0, 1);
        deckRobots.add(drain1_r);
        deckGlobal.add(drain1_r);

        Card drain2_r = new Card(9, 4, 0, 0, 4);
        deckRobots.add(drain2_r);
        deckGlobal.add(drain2_r);

        Card ult1_r = new Card(10, 3, 1, 1, 1);
        deckRobots.add(ult1_r);
        deckGlobal.add(ult1_r);
        ///////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////// PLANTS
        Card damage1_p = new Card(11, 1, 1, 0, 0);
        deckPlants.add(damage1_p);
        deckGlobal.add(damage1_p);

        Card heal1_p = new Card(12, 1, 0, 1, 0);
        deckPlants.add(heal1_p);
        deckGlobal.add(heal1_p);

        Card damage2_p = new Card(13, 0, 1, 0, 0);
        deckPlants.add(damage2_p);
        deckGlobal.add(damage2_p);

        Card heal2_p = new Card(14, 3, 0, 3, 0);
        deckPlants.add(heal2_p);
        deckGlobal.add(heal2_p);

        Card ult1_p = new Card(15, 5, 1, 5, 1);
        deckPlants.add(ult1_p);
        deckGlobal.add(ult1_p);
        ///////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////// HBs
        Card damage1_hb = new Card(16, 1, 4, 0, 0);
        deckHigherbeings.add(damage1_hb);
        deckGlobal.add(damage1_hb);

        Card heal1_hb = new Card(17, 1, 0, 3, 0);
        deckHigherbeings.add(heal1_hb);
        deckGlobal.add(heal1_hb);

        Card damage2_hb = new Card(18, 3, 15, 0, 1);
        deckHigherbeings.add(damage2_hb);
        deckGlobal.add(damage2_hb);

        Card heal2_hb = new Card(19, 3, 0, 10, 1);
        deckHigherbeings.add(heal2_hb);
        deckGlobal.add(heal2_hb);

        Card ult1_hb = new Card(20, 2, 6, 5, 5);
        deckHigherbeings.add(ult1_hb);
        deckGlobal.add(ult1_hb);
        ///////////////////////////////////////////////////////////////////////////

        actGot = getIntent().getStringExtra("act");

        final String p1class = getIntent().getStringExtra("p1class");
        final String p2class = getIntent().getStringExtra("p2class");
        if (p1class.equals("1"))
            deckP1active = deckHumans;
        else if (p1class.equals("2"))
            deckP1active = deckRobots;
        else if (p1class.equals("3"))
            deckP1active = deckPlants;
        else if (p1class.equals("4"))
            deckP1active = deckHigherbeings;

        if (p2class.equals("1"))
            deckP2active = deckHumans;
        else if (p2class.equals("2"))
            deckP2active = deckRobots;
        else if (p2class.equals("3"))
            deckP2active = deckPlants;
        else if (p2class.equals("4"))
            deckP2active = deckHigherbeings;

        if (actGot.equals("Co")) {
            player = Integer.parseInt(getIntent().getStringExtra("player"));
            turns = Integer.parseInt(getIntent().getStringExtra("turns"));
            yourHp = Integer.parseInt(getIntent().getStringExtra("yourHp"));
            enemyHp = Integer.parseInt(getIntent().getStringExtra("enemyHp"));
            yourMana = Integer.parseInt(getIntent().getStringExtra("yourMana"));
            enemyMana = Integer.parseInt(getIntent().getStringExtra("enemyMana"));

            for (int i = 0; i < deckGlobal.size(); i++) {
                Integer curCardId = Integer.parseInt(getIntent().getStringExtra("currentCard"));
                Card curCard = (Card) deckGlobal.get(i);
                if (curCardId == curCard.id) {
                    currentCard = curCard;
                }
            }
        } else {
            player = 1;
            turns = 4;
            yourHp = 18; //18 (фора)
            enemyHp = 20; //20
            yourMana = 0;
            enemyMana = 0;

            currentCard = (Card) deckP1active.get(random.nextInt(deckP1active.size()));
        }

        textYourHp = findViewById(R.id.textYourHp);
        textEnemyHp = findViewById(R.id.textEnemyHp);
        textYourMana = findViewById(R.id.textYourMana);
        textEnemyMana = findViewById(R.id.textEnemyMana);
        textTurns = findViewById(R.id.textTurns);

        textEnemyHp.setText(enemyHp.toString());
        textYourHp.setText(yourHp.toString());
        textYourMana.setText(yourMana.toString());
        textEnemyMana.setText(enemyMana.toString());
        textTurns.setText(turns.toString());

        textDebug = findViewById(R.id.textDebug);
        curClassString = "";
        nextClassString = "";
        if (p1class.equals("1"))
            curClassString = "Люди";
        else if (p1class.equals("2"))
            curClassString = "Роботы";
        else if (p1class.equals("3"))
            curClassString = "Растения";
        else if (p1class.equals("4"))
            curClassString = "Высшие существа";

        if (p2class.equals("1"))
            nextClassString = "Люди";
        else if (p2class.equals("2"))
            nextClassString = "Роботы";
        else if (p2class.equals("3"))
            nextClassString = "Растения";
        else if (p2class.equals("4"))
            nextClassString = "Высшие существа";

        textDebug.setText("Игра создана" + "\n\n" + currentCard.writeCard() + "\n\nВаш класс:\n" + curClassString);

        Button btnPlayCard = findViewById(R.id.btnPlay);
        Button btnSellCard = findViewById(R.id.btnSellCard);

        btnPlayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yourMana >= currentCard.cost) {
                    enemyHp -= currentCard.dmg;
                    yourHp += currentCard.heal;
                    yourMana -= currentCard.cost;
                    enemyMana -= currentCard.drain;
                    textEnemyHp.setText(enemyHp.toString());
                    textYourHp.setText(yourHp.toString());
                    textYourMana.setText(yourMana.toString());
                    textEnemyMana.setText(enemyMana.toString());

                    currentCard = (Card) deckP1active.get(random.nextInt(deckP1active.size()));
                    textDebug.setText("Карта сыграна\n\n" + currentCard.writeCard() + "\n\nВаш класс:\n" + curClassString);

                    check();
                } else {
                    textDebug.setText("Не достаточно маны\n\n" + currentCard.writeCard() + "\n\nВаш класс:\n" + curClassString);
                }

            }
        });

        btnSellCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yourMana += currentCard.cost;
                if (player == 1) {
                    if (p1class.equals("4"))
                        yourMana -= (currentCard.cost - 1);
                    if (p1class.equals("3"))
                        yourMana += currentCard.cost;
                } else if (player == 2) {
                    if (p2class.equals("4"))
                        yourMana -= (currentCard.cost - 1);
                    if (p2class.equals("3"))
                        yourMana += currentCard.cost;
                }

                textYourMana.setText(yourMana.toString());
                currentCard = (Card) deckP1active.get(random.nextInt(deckP1active.size()));
                textDebug.setText("Карта продана\n\n" + currentCard.writeCard() + "\n\nВаш класс:\n" + curClassString);

                check();
            }
        });

        Button btnSaveAndExit = findViewById(R.id.btnSaveAndExit);
        btnSaveAndExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saveGame = new Intent(GameActivity.this, ContinueActivity.class);

                String playerS = player.toString();
                String turnsS = turns.toString();
                String currentCardS = currentCard.id.toString();
                String p1classS = p1class;
                String p2classS = p2class;
                String yourHpS = yourHp.toString();
                String enemyHpS = enemyHp.toString();
                String yourManaS = yourMana.toString();
                String enemyManaS = enemyMana.toString();
                String dateAndTimeS = DateFormat.getDateTimeInstance().format(new Date());

                saveGame.putExtra("player", playerS);
                saveGame.putExtra("turns", turnsS);
                saveGame.putExtra("currentCard", currentCardS);
                saveGame.putExtra("p1class", p1classS);
                saveGame.putExtra("p2class", p2classS);
                saveGame.putExtra("yourHp", yourHpS);
                saveGame.putExtra("enemyHp", enemyHpS);
                saveGame.putExtra("yourMana", yourManaS);
                saveGame.putExtra("enemyMana", enemyManaS);
                saveGame.putExtra("dateAndTime", dateAndTimeS);

                String act = "G";
                saveGame.putExtra("act", act);

                startActivity(saveGame);

            }
        });
    }

    public void check() {
        if (enemyHp <= 0 && yourHp > 0) {
            Intent toWinActivity = new Intent(GameActivity.this, WinActivity.class);
            String winnerNameText = player.toString();
            toWinActivity.putExtra("winner", winnerNameText);
            startActivity(toWinActivity);
            System.out.println("ИГРОК " + player + " ПОБЕДИЛ");
            finish();
        } else if (enemyHp <= 0) {
            System.out.println("DRAW");
            finish();
        }
        if (turns <= 1) {
            flip();
            turns = 4;
        } else {
            turns--;
        }
        textTurns.setText(turns.toString());
    }

    public void flip() {
        if (player == 1) {
            player = 2;
            constraintLayout.setBackgroundColor(Color.parseColor("#2196F3"));
        } else {
            player = 1;
            constraintLayout.setBackgroundColor(Color.parseColor("#FF4747"));
        }
        temp = yourHp;
        yourHp = enemyHp;
        enemyHp = temp;
        temp = yourMana;
        yourMana = enemyMana;
        enemyMana = temp;

        textEnemyHp.setText(enemyHp.toString());
        textYourHp.setText(yourHp.toString());
        textYourMana.setText(yourMana.toString());
        textEnemyMana.setText(enemyMana.toString());

        deckTemp = deckP1active;
        deckP1active = deckP2active;
        deckP2active = deckTemp;

        tempStr = curClassString;
        curClassString = nextClassString;
        nextClassString = tempStr;

        currentCard = (Card) deckP1active.get(random.nextInt(deckP1active.size()));

        textDebug.setText("Игроки сменились\n\n" + currentCard.writeCard() + "\n\nВаш класс:\n" + curClassString);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}