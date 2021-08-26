package com.example.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data_utility.models.CityWeatherCache;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CityDao_Impl implements CityDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CityWeatherCache> __insertionAdapterOfCityWeatherCache;

  private final Converters __converters = new Converters();

  public CityDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCityWeatherCache = new EntityInsertionAdapter<CityWeatherCache>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `cityWeatherCache` (`name`,`country`,`lat`,`lon`,`localTime`,`obsTime`,`icons`,`humidity`,`feelsLike`,`is_day`,`desc`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CityWeatherCache value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCountry());
        }
        stmt.bindDouble(3, value.getLat());
        stmt.bindDouble(4, value.getLon());
        stmt.bindLong(5, value.getLocalTime());
        if (value.getObsTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getObsTime());
        }
        final String _tmp;
        _tmp = __converters.fromListOfStringToString(value.getIcons());
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp);
        }
        stmt.bindLong(8, value.getHumidity());
        stmt.bindLong(9, value.getFeelsLike());
        final int _tmp_1;
        _tmp_1 = value.is_day() ? 1 : 0;
        stmt.bindLong(10, _tmp_1);
        final String _tmp_2;
        _tmp_2 = __converters.fromListOfStringToString(value.getDesc());
        if (_tmp_2 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_2);
        }
      }
    };
  }

  @Override
  public Object insertCity(final CityWeatherCache city,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCityWeatherCache.insert(city);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<CityWeatherCache>> continuation) {
    final String _sql = "SELECT * FROM cityWeatherCache";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CityWeatherCache>>() {
      @Override
      public List<CityWeatherCache> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
          final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "lon");
          final int _cursorIndexOfLocalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "localTime");
          final int _cursorIndexOfObsTime = CursorUtil.getColumnIndexOrThrow(_cursor, "obsTime");
          final int _cursorIndexOfIcons = CursorUtil.getColumnIndexOrThrow(_cursor, "icons");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfFeelsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "feelsLike");
          final int _cursorIndexOfIsDay = CursorUtil.getColumnIndexOrThrow(_cursor, "is_day");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
          final List<CityWeatherCache> _result = new ArrayList<CityWeatherCache>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CityWeatherCache _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final float _tmpLat;
            _tmpLat = _cursor.getFloat(_cursorIndexOfLat);
            final float _tmpLon;
            _tmpLon = _cursor.getFloat(_cursorIndexOfLon);
            final long _tmpLocalTime;
            _tmpLocalTime = _cursor.getLong(_cursorIndexOfLocalTime);
            final String _tmpObsTime;
            if (_cursor.isNull(_cursorIndexOfObsTime)) {
              _tmpObsTime = null;
            } else {
              _tmpObsTime = _cursor.getString(_cursorIndexOfObsTime);
            }
            final List<String> _tmpIcons;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfIcons)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfIcons);
            }
            _tmpIcons = __converters.fromStringToListOfString(_tmp);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            final int _tmpFeelsLike;
            _tmpFeelsLike = _cursor.getInt(_cursorIndexOfFeelsLike);
            final boolean _tmpIs_day;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDay);
            _tmpIs_day = _tmp_1 != 0;
            final List<String> _tmpDesc;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDesc);
            }
            _tmpDesc = __converters.fromStringToListOfString(_tmp_2);
            _item = new CityWeatherCache(_tmpName,_tmpCountry,_tmpLat,_tmpLon,_tmpLocalTime,_tmpObsTime,_tmpIcons,_tmpHumidity,_tmpFeelsLike,_tmpIs_day,_tmpDesc);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getCityByName(final String name,
      final Continuation<? super CityWeatherCache> continuation) {
    final String _sql = "SELECT * FROM cityWeatherCache WHERE name is ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CityWeatherCache>() {
      @Override
      public CityWeatherCache call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
          final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "lon");
          final int _cursorIndexOfLocalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "localTime");
          final int _cursorIndexOfObsTime = CursorUtil.getColumnIndexOrThrow(_cursor, "obsTime");
          final int _cursorIndexOfIcons = CursorUtil.getColumnIndexOrThrow(_cursor, "icons");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfFeelsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "feelsLike");
          final int _cursorIndexOfIsDay = CursorUtil.getColumnIndexOrThrow(_cursor, "is_day");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
          final CityWeatherCache _result;
          if(_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final float _tmpLat;
            _tmpLat = _cursor.getFloat(_cursorIndexOfLat);
            final float _tmpLon;
            _tmpLon = _cursor.getFloat(_cursorIndexOfLon);
            final long _tmpLocalTime;
            _tmpLocalTime = _cursor.getLong(_cursorIndexOfLocalTime);
            final String _tmpObsTime;
            if (_cursor.isNull(_cursorIndexOfObsTime)) {
              _tmpObsTime = null;
            } else {
              _tmpObsTime = _cursor.getString(_cursorIndexOfObsTime);
            }
            final List<String> _tmpIcons;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfIcons)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfIcons);
            }
            _tmpIcons = __converters.fromStringToListOfString(_tmp);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            final int _tmpFeelsLike;
            _tmpFeelsLike = _cursor.getInt(_cursorIndexOfFeelsLike);
            final boolean _tmpIs_day;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDay);
            _tmpIs_day = _tmp_1 != 0;
            final List<String> _tmpDesc;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDesc);
            }
            _tmpDesc = __converters.fromStringToListOfString(_tmp_2);
            _result = new CityWeatherCache(_tmpName,_tmpCountry,_tmpLat,_tmpLon,_tmpLocalTime,_tmpObsTime,_tmpIcons,_tmpHumidity,_tmpFeelsLike,_tmpIs_day,_tmpDesc);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
