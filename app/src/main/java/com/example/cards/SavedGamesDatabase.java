package com.example.cards;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = SavedGame.class, version = 1)
public abstract class SavedGamesDatabase extends RoomDatabase {
    public abstract SavedGameDAO savedGameDAO();

    private static SavedGamesDatabase INSTANCE;

    public static SavedGamesDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SavedGamesDatabase.class, SavedGamesDatabase.class.getName()).build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
