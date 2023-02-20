package com.gabrielhernandes.crudcomposecities.data.dao

import androidx.room.*
import com.gabrielhernandes.crudcomposecities.data.entities.Cities
import kotlinx.coroutines.flow.Flow

@Dao
interface CitiesDao {
    @Insert
    suspend fun insert(cities: Cities)

    @Update
    suspend fun update(cities: Cities)

    @Delete
    suspend fun delete(cities: Cities)

    @Query("select * from cidades")
    fun getAllCities(): Flow<List<Cities>>
}