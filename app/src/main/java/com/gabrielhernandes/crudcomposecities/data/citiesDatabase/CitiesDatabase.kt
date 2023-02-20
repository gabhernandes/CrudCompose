package com.gabrielhernandes.crudcomposecities.data.citiesDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabrielhernandes.crudcomposecities.data.dao.CitiesDao
import com.gabrielhernandes.crudcomposecities.data.entities.Cities


@Database(entities = [Cities::class], exportSchema = false, version = 1)
abstract class CitiesDatabase : RoomDatabase() {
    abstract fun citiesDao(): CitiesDao
}