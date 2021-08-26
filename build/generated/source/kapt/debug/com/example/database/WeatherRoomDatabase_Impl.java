package com.example.database;

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
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherRoomDatabase_Impl extends WeatherRoomDatabase {
  private volatile CityDao _cityDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cityWeatherCache` (`name` TEXT NOT NULL, `country` TEXT NOT NULL, `lat` REAL NOT NULL, `lon` REAL NOT NULL, `localTime` INTEGER NOT NULL, `obsTime` TEXT NOT NULL, `icons` TEXT NOT NULL, `humidity` INTEGER NOT NULL, `feelsLike` INTEGER NOT NULL, `is_day` INTEGER NOT NULL, `desc` TEXT NOT NULL, PRIMARY KEY(`name`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1590efc74eca96da912e01191113e42f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `cityWeatherCache`");
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
        final HashMap<String, TableInfo.Column> _columnsCityWeatherCache = new HashMap<String, TableInfo.Column>(11);
        _columnsCityWeatherCache.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("lat", new TableInfo.Column("lat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("lon", new TableInfo.Column("lon", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("localTime", new TableInfo.Column("localTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("obsTime", new TableInfo.Column("obsTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("icons", new TableInfo.Column("icons", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("humidity", new TableInfo.Column("humidity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("feelsLike", new TableInfo.Column("feelsLike", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("is_day", new TableInfo.Column("is_day", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityWeatherCache.put("desc", new TableInfo.Column("desc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCityWeatherCache = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCityWeatherCache = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCityWeatherCache = new TableInfo("cityWeatherCache", _columnsCityWeatherCache, _foreignKeysCityWeatherCache, _indicesCityWeatherCache);
        final TableInfo _existingCityWeatherCache = TableInfo.read(_db, "cityWeatherCache");
        if (! _infoCityWeatherCache.equals(_existingCityWeatherCache)) {
          return new RoomOpenHelper.ValidationResult(false, "cityWeatherCache(com.example.data_utility.models.CityWeatherCache).\n"
                  + " Expected:\n" + _infoCityWeatherCache + "\n"
                  + " Found:\n" + _existingCityWeatherCache);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "1590efc74eca96da912e01191113e42f", "95ccc363e4e24a9c690855d3a36d0c40");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "cityWeatherCache");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `cityWeatherCache`");
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
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CityDao.class, CityDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public CityDao cityDao() {
    if (_cityDao != null) {
      return _cityDao;
    } else {
      synchronized(this) {
        if(_cityDao == null) {
          _cityDao = new CityDao_Impl(this);
        }
        return _cityDao;
      }
    }
  }
}
