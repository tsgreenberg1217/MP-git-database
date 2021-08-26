package com.example.database;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.example.database.Converters.class})
@androidx.room.Database(entities = {com.example.data_utility.models.CityWeatherCache.class}, version = 1)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/database/WeatherRoomDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/example/database/WeatherDatabase;", "()V", "database_debug"})
public abstract class WeatherRoomDatabase extends androidx.room.RoomDatabase implements com.example.database.WeatherDatabase {
    
    public WeatherRoomDatabase() {
        super();
    }
}