// Generated by Dagger (https://dagger.dev).
package com.example.database;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomModule_ProvidesWeatherDatabaseFactory implements Factory<WeatherRoomDatabase> {
  private final Provider<Context> ctxProvider;

  public RoomModule_ProvidesWeatherDatabaseFactory(Provider<Context> ctxProvider) {
    this.ctxProvider = ctxProvider;
  }

  @Override
  public WeatherRoomDatabase get() {
    return providesWeatherDatabase(ctxProvider.get());
  }

  public static RoomModule_ProvidesWeatherDatabaseFactory create(Provider<Context> ctxProvider) {
    return new RoomModule_ProvidesWeatherDatabaseFactory(ctxProvider);
  }

  public static WeatherRoomDatabase providesWeatherDatabase(Context ctx) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.providesWeatherDatabase(ctx));
  }
}