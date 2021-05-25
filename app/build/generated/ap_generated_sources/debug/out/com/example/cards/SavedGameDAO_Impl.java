package com.example.cards;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class SavedGameDAO_Impl implements SavedGameDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSavedGame;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SavedGameDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSavedGame = new EntityInsertionAdapter<SavedGame>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `SavedGamesDatabase`(`savedGameId`,`playerS`,`turnsS`,`currentCardS`,`p1classS`,`p2classS`,`yourHpS`,`enemyHpS`,`yourManaS`,`enemyManaS`,`dateAndTimeS`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SavedGame value) {
        stmt.bindLong(1, value.savedGameId);
        if (value.playerS == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.playerS);
        }
        if (value.turnsS == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.turnsS);
        }
        if (value.currentCardS == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.currentCardS);
        }
        if (value.p1classS == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.p1classS);
        }
        if (value.p2classS == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.p2classS);
        }
        if (value.yourHpS == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.yourHpS);
        }
        if (value.enemyHpS == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.enemyHpS);
        }
        if (value.yourManaS == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.yourManaS);
        }
        if (value.enemyManaS == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.enemyManaS);
        }
        if (value.dateAndTimeS == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.dateAndTimeS);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM SavedGamesDatabase";
        return _query;
      }
    };
  }

  @Override
  public void insert(SavedGame savedGame) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSavedGame.insert(savedGame);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<SavedGame> getAllSavedGames() {
    final String _sql = "SELECT * FROM SavedGamesDatabase";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSavedGameId = _cursor.getColumnIndexOrThrow("savedGameId");
      final int _cursorIndexOfPlayerS = _cursor.getColumnIndexOrThrow("playerS");
      final int _cursorIndexOfTurnsS = _cursor.getColumnIndexOrThrow("turnsS");
      final int _cursorIndexOfCurrentCardS = _cursor.getColumnIndexOrThrow("currentCardS");
      final int _cursorIndexOfP1classS = _cursor.getColumnIndexOrThrow("p1classS");
      final int _cursorIndexOfP2classS = _cursor.getColumnIndexOrThrow("p2classS");
      final int _cursorIndexOfYourHpS = _cursor.getColumnIndexOrThrow("yourHpS");
      final int _cursorIndexOfEnemyHpS = _cursor.getColumnIndexOrThrow("enemyHpS");
      final int _cursorIndexOfYourManaS = _cursor.getColumnIndexOrThrow("yourManaS");
      final int _cursorIndexOfEnemyManaS = _cursor.getColumnIndexOrThrow("enemyManaS");
      final int _cursorIndexOfDateAndTimeS = _cursor.getColumnIndexOrThrow("dateAndTimeS");
      final List<SavedGame> _result = new ArrayList<SavedGame>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SavedGame _item;
        final String _tmpPlayerS;
        _tmpPlayerS = _cursor.getString(_cursorIndexOfPlayerS);
        final String _tmpTurnsS;
        _tmpTurnsS = _cursor.getString(_cursorIndexOfTurnsS);
        final String _tmpCurrentCardS;
        _tmpCurrentCardS = _cursor.getString(_cursorIndexOfCurrentCardS);
        final String _tmpP1classS;
        _tmpP1classS = _cursor.getString(_cursorIndexOfP1classS);
        final String _tmpP2classS;
        _tmpP2classS = _cursor.getString(_cursorIndexOfP2classS);
        final String _tmpYourHpS;
        _tmpYourHpS = _cursor.getString(_cursorIndexOfYourHpS);
        final String _tmpEnemyHpS;
        _tmpEnemyHpS = _cursor.getString(_cursorIndexOfEnemyHpS);
        final String _tmpYourManaS;
        _tmpYourManaS = _cursor.getString(_cursorIndexOfYourManaS);
        final String _tmpEnemyManaS;
        _tmpEnemyManaS = _cursor.getString(_cursorIndexOfEnemyManaS);
        final String _tmpDateAndTimeS;
        _tmpDateAndTimeS = _cursor.getString(_cursorIndexOfDateAndTimeS);
        _item = new SavedGame(_tmpPlayerS,_tmpTurnsS,_tmpCurrentCardS,_tmpP1classS,_tmpP2classS,_tmpYourHpS,_tmpEnemyHpS,_tmpYourManaS,_tmpEnemyManaS,_tmpDateAndTimeS);
        _item.savedGameId = _cursor.getInt(_cursorIndexOfSavedGameId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
