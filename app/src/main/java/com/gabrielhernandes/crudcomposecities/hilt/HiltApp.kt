package com.gabrielhernandes.crudcomposecities.hilt

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.gabrielhernandes.crudcomposecities.data.citiesDatabase.CitiesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class HiltApp : Application() {
}

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context):
            CitiesDatabase {
        return Room.databaseBuilder(
            appContext,
            CitiesDatabase::class.java,
            "Cities"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDao(citiesDatabase: CitiesDatabase) = citiesDatabase.citiesDao()
}