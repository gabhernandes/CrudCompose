package com.gabrielhernandes.crudcomposecities.data.repository

import com.gabrielhernandes.crudcomposecities.data.citiesDatabase.CitiesDatabase
import com.gabrielhernandes.crudcomposecities.data.entities.Cities
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class CitiesRepository @Inject constructor(citiesDatabase: CitiesDatabase) {
    private val dao = citiesDatabase.citiesDao()

    fun getAll(): Flow<List<Cities>> = dao.getAllCities()

    suspend fun add(c: Cities) {
        dao.insert(c)
    }

    suspend fun remove(c: Cities) {
        dao.delete(c)
    }

    suspend fun update(c: Cities) {
        dao.update(c)
    }
}