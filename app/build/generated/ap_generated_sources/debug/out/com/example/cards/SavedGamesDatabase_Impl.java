package com.example.cards;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class SavedGamesDatabase_Impl extends SavedGamesDatabase {
  private volatile SavedGameDAO _savedGameDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SavedGamesDatabase` (`savedGameId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playerS` TEXT, `turnsS` TEXT, `currentCardS` TEXT, `p1classS` TEXT, `p2classS` TEXT, `yourHpS` TEXT, `enemyHpS` TEXT, `yourManaS` TEXT, `enemyManaS` TEXT, `dateAndTimeS` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b5e77c0ad904f81b28537cfb2cc9af59\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `SavedGamesDatabase`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSavedGamesDatabase = new HashMap<String, TableInfo.Column>(11);
        _columnsSavedGamesDatabase.put("savedGameId", new TableInfo.Column("savedGameId", "INTEGER", true, 1));
        _columnsSavedGamesDatabase.put("playerS", new TableInfo.Column("playerS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("turnsS", new TableInfo.Column("turnsS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("currentCardS", new TableInfo.Column("currentCardS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("p1classS", new TableInfo.Column("p1classS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("p2classS", new TableInfo.Column("p2classS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("yourHpS", new TableInfo.Column("yourHpS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("enemyHpS", new TableInfo.Column("enemyHpS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("yourManaS", new TableInfo.Column("yourManaS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("enemyManaS", new TableInfo.Column("enemyManaS", "TEXT", false, 0));
        _columnsSavedGamesDatabase.put("dateAndTimeS", new TableInfo.Column("dateAndTimeS", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSavedGamesDatabase = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSavedGamesDatabase = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSavedGamesDatabase = new TableInfo("SavedGamesDatabase", _columnsSavedGamesDatabase, _foreignKeysSavedGamesDatabase, _indicesSavedGamesDatabase);
        final TableInfo _existingSavedGamesDatabase = TableInfo.read(_db, "SavedGamesDatabase");
        if (! _infoSavedGamesDatabase.equals(_existingSavedGamesDatabase)) {
          throw new IllegalStateException("Migration didn't properly handle SavedGamesDatabase(com.example.cards.SavedGame).\n"
                  + " Expected:\n" + _infoSavedGamesDatabase + "\n"
                  + " Found:\n" + _existingSavedGamesDatabase);
        }
      }
    }, "b5e77c0ad904f81b28537cfb2cc9af59", "938cdc8b1f08d56265632ca848ba5c63");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "SavedGamesDatabase");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `SavedGamesDatabase`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public SavedGameDAO savedGameDAO() {
    if (_savedGameDAO != null) {
      return _savedGameDAO;
    } else {
      synchronized(this) {
        if(_savedGameDAO == null) {
          _savedGameDAO = new SavedGameDAO_Impl(this);
        }
        return _savedGameDAO;
      }
    }
  }
}
