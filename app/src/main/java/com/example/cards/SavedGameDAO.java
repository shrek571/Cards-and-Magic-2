package com.example.cards;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SavedGameDAO {

    @Insert
    void insert(SavedGame savedGame);

    @Query("SELECT * FROM SavedGamesDatabase")
    List<SavedGame> getAllSavedGames();

    @Query("DELETE FROM SavedGamesDatabase")
    void deleteAll();
}
