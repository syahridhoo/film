package com.example.android.populartvapp.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TVSeriesRoomDatabase_Impl extends TVSeriesRoomDatabase {
  private volatile TVSeriesDao _tVSeriesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `api_table` (`rank` INTEGER PRIMARY KEY AUTOINCREMENT, `variety` TEXT, `first_air_date` TEXT, `overview` TEXT, `original_language` TEXT, `genre_ids` TEXT, `poster_path` TEXT, `origin_country` TEXT, `backdrop_path` TEXT, `originalName` TEXT, `populatity` REAL, `vote_average` REAL, `name` TEXT, `id` INTEGER, `vote_count` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c18b6278ab8face6eeef6a541c054645')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `api_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
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
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsApiTable = new HashMap<String, TableInfo.Column>(15);
        _columnsApiTable.put("rank", new TableInfo.Column("rank", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("variety", new TableInfo.Column("variety", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("first_air_date", new TableInfo.Column("first_air_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("original_language", new TableInfo.Column("original_language", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("genre_ids", new TableInfo.Column("genre_ids", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("poster_path", new TableInfo.Column("poster_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("origin_country", new TableInfo.Column("origin_country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("backdrop_path", new TableInfo.Column("backdrop_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("originalName", new TableInfo.Column("originalName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("populatity", new TableInfo.Column("populatity", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("vote_average", new TableInfo.Column("vote_average", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("id", new TableInfo.Column("id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApiTable.put("vote_count", new TableInfo.Column("vote_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysApiTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesApiTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoApiTable = new TableInfo("api_table", _columnsApiTable, _foreignKeysApiTable, _indicesApiTable);
        final TableInfo _existingApiTable = TableInfo.read(_db, "api_table");
        if (! _infoApiTable.equals(_existingApiTable)) {
          return new RoomOpenHelper.ValidationResult(false, "api_table(com.example.android.populartvapp.model.ResultsItem).\n"
                  + " Expected:\n" + _infoApiTable + "\n"
                  + " Found:\n" + _existingApiTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c18b6278ab8face6eeef6a541c054645", "ff23a801954e490cd0d50f07c3d6c57f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "api_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `api_table`");
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
  public TVSeriesDao tvSeriesDao() {
    if (_tVSeriesDao != null) {
      return _tVSeriesDao;
    } else {
      synchronized(this) {
        if(_tVSeriesDao == null) {
          _tVSeriesDao = new TVSeriesDao_Impl(this);
        }
        return _tVSeriesDao;
      }
    }
  }
}
