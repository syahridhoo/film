package com.example.android.populartvapp.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.android.populartvapp.model.ResultsItem;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TVSeriesDao_Impl implements TVSeriesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ResultsItem> __insertionAdapterOfResultsItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPopular;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTopRated;

  public TVSeriesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfResultsItem = new EntityInsertionAdapter<ResultsItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `api_table` (`rank`,`variety`,`first_air_date`,`overview`,`original_language`,`genre_ids`,`poster_path`,`origin_country`,`backdrop_path`,`originalName`,`populatity`,`vote_average`,`name`,`id`,`vote_count`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ResultsItem value) {
        if (value.getRank() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getRank());
        }
        if (value.getVariety() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getVariety());
        }
        if (value.getFirstAirDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFirstAirDate());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getOriginalLanguage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOriginalLanguage());
        }
        final String _tmp;
        _tmp = Converters.fromArrayListInt(value.getGenreIds());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        if (value.getPosterPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPosterPath());
        }
        final String _tmp_1;
        _tmp_1 = Converters.fromArrayListString(value.getOriginCountry());
        if (_tmp_1 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_1);
        }
        if (value.getBackdropPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBackdropPath());
        }
        if (value.getOriginalName() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getOriginalName());
        }
        if (value.getPopularity() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getPopularity());
        }
        if (value.getVoteAverage() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.getVoteAverage());
        }
        if (value.getName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getName());
        }
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getId());
        }
        if (value.getVoteCount() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getVoteCount());
        }
      }
    };
    this.__preparedStmtOfDeleteAllPopular = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM api_table WHERE variety = 'popular'";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllTopRated = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM api_table WHERE variety = 'top_rated'";
        return _query;
      }
    };
  }

  @Override
  public void insertData(final ResultsItem data) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResultsItem.insert(data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllPopular() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPopular.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllPopular.release(_stmt);
    }
  }

  @Override
  public void deleteAllTopRated() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllTopRated.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllTopRated.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ResultsItem>> getAllDataPopular() {
    final String _sql = "SELECT * from api_table WHERE variety = 'popular' ORDER BY rank ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"api_table"}, false, new Callable<List<ResultsItem>>() {
      @Override
      public List<ResultsItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfVariety = CursorUtil.getColumnIndexOrThrow(_cursor, "variety");
          final int _cursorIndexOfFirstAirDate = CursorUtil.getColumnIndexOrThrow(_cursor, "first_air_date");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
          final int _cursorIndexOfGenreIds = CursorUtil.getColumnIndexOrThrow(_cursor, "genre_ids");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfOriginCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "origin_country");
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
          final int _cursorIndexOfOriginalName = CursorUtil.getColumnIndexOrThrow(_cursor, "originalName");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "populatity");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
          final List<ResultsItem> _result = new ArrayList<ResultsItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ResultsItem _item;
            _item = new ResultsItem();
            final Integer _tmpRank;
            if (_cursor.isNull(_cursorIndexOfRank)) {
              _tmpRank = null;
            } else {
              _tmpRank = _cursor.getInt(_cursorIndexOfRank);
            }
            _item.setRank(_tmpRank);
            final String _tmpVariety;
            _tmpVariety = _cursor.getString(_cursorIndexOfVariety);
            _item.setVariety(_tmpVariety);
            final String _tmpFirstAirDate;
            _tmpFirstAirDate = _cursor.getString(_cursorIndexOfFirstAirDate);
            _item.setFirstAirDate(_tmpFirstAirDate);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            _item.setOverview(_tmpOverview);
            final String _tmpOriginalLanguage;
            _tmpOriginalLanguage = _cursor.getString(_cursorIndexOfOriginalLanguage);
            _item.setOriginalLanguage(_tmpOriginalLanguage);
            final ArrayList<Integer> _tmpGenreIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfGenreIds);
            _tmpGenreIds = Converters.fromInteger(_tmp);
            _item.setGenreIds(_tmpGenreIds);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            _item.setPosterPath(_tmpPosterPath);
            final ArrayList<String> _tmpOriginCountry;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfOriginCountry);
            _tmpOriginCountry = Converters.fromString(_tmp_1);
            _item.setOriginCountry(_tmpOriginCountry);
            final String _tmpBackdropPath;
            _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
            _item.setBackdropPath(_tmpBackdropPath);
            final String _tmpOriginalName;
            _tmpOriginalName = _cursor.getString(_cursorIndexOfOriginalName);
            _item.setOriginalName(_tmpOriginalName);
            final Double _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            }
            _item.setPopularity(_tmpPopularity);
            final Double _tmpVoteAverage;
            if (_cursor.isNull(_cursorIndexOfVoteAverage)) {
              _tmpVoteAverage = null;
            } else {
              _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            }
            _item.setVoteAverage(_tmpVoteAverage);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpVoteCount;
            if (_cursor.isNull(_cursorIndexOfVoteCount)) {
              _tmpVoteCount = null;
            } else {
              _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
            }
            _item.setVoteCount(_tmpVoteCount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<ResultsItem>> getAllDataTopRated() {
    final String _sql = "SELECT * from api_table WHERE variety = 'top_rated' ORDER BY rank ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"api_table"}, false, new Callable<List<ResultsItem>>() {
      @Override
      public List<ResultsItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfVariety = CursorUtil.getColumnIndexOrThrow(_cursor, "variety");
          final int _cursorIndexOfFirstAirDate = CursorUtil.getColumnIndexOrThrow(_cursor, "first_air_date");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
          final int _cursorIndexOfGenreIds = CursorUtil.getColumnIndexOrThrow(_cursor, "genre_ids");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfOriginCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "origin_country");
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
          final int _cursorIndexOfOriginalName = CursorUtil.getColumnIndexOrThrow(_cursor, "originalName");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "populatity");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
          final List<ResultsItem> _result = new ArrayList<ResultsItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ResultsItem _item;
            _item = new ResultsItem();
            final Integer _tmpRank;
            if (_cursor.isNull(_cursorIndexOfRank)) {
              _tmpRank = null;
            } else {
              _tmpRank = _cursor.getInt(_cursorIndexOfRank);
            }
            _item.setRank(_tmpRank);
            final String _tmpVariety;
            _tmpVariety = _cursor.getString(_cursorIndexOfVariety);
            _item.setVariety(_tmpVariety);
            final String _tmpFirstAirDate;
            _tmpFirstAirDate = _cursor.getString(_cursorIndexOfFirstAirDate);
            _item.setFirstAirDate(_tmpFirstAirDate);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            _item.setOverview(_tmpOverview);
            final String _tmpOriginalLanguage;
            _tmpOriginalLanguage = _cursor.getString(_cursorIndexOfOriginalLanguage);
            _item.setOriginalLanguage(_tmpOriginalLanguage);
            final ArrayList<Integer> _tmpGenreIds;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfGenreIds);
            _tmpGenreIds = Converters.fromInteger(_tmp);
            _item.setGenreIds(_tmpGenreIds);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            _item.setPosterPath(_tmpPosterPath);
            final ArrayList<String> _tmpOriginCountry;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfOriginCountry);
            _tmpOriginCountry = Converters.fromString(_tmp_1);
            _item.setOriginCountry(_tmpOriginCountry);
            final String _tmpBackdropPath;
            _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
            _item.setBackdropPath(_tmpBackdropPath);
            final String _tmpOriginalName;
            _tmpOriginalName = _cursor.getString(_cursorIndexOfOriginalName);
            _item.setOriginalName(_tmpOriginalName);
            final Double _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            }
            _item.setPopularity(_tmpPopularity);
            final Double _tmpVoteAverage;
            if (_cursor.isNull(_cursorIndexOfVoteAverage)) {
              _tmpVoteAverage = null;
            } else {
              _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            }
            _item.setVoteAverage(_tmpVoteAverage);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpVoteCount;
            if (_cursor.isNull(_cursorIndexOfVoteCount)) {
              _tmpVoteCount = null;
            } else {
              _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
            }
            _item.setVoteCount(_tmpVoteCount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
