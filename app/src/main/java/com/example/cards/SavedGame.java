package com.example.cards;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SavedGamesDatabase")
public class SavedGame {
    @PrimaryKey(autoGenerate = true)
    int savedGameId;
    String playerS;
    String turnsS;
    String currentCardS;
    String p1classS;
    String p2classS;
    String yourHpS;
    String enemyHpS;
    String yourManaS;
    String enemyManaS;
    String dateAndTimeS;

    public SavedGame(String playerS, String turnsS, String currentCardS, String p1classS, String p2classS, String yourHpS, String enemyHpS, String yourManaS, String enemyManaS, String dateAndTimeS) {
        this.playerS = playerS;
        this.turnsS = turnsS;
        this.currentCardS = currentCardS;
        this.p1classS = p1classS;
        this.p2classS = p2classS;
        this.yourHpS = yourHpS;
        this.enemyHpS = enemyHpS;
        this.yourManaS = yourManaS;
        this.enemyManaS = enemyManaS;
        this.dateAndTimeS = dateAndTimeS;
    }
}
