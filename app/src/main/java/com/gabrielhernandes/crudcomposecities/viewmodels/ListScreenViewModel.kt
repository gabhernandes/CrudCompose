package com.gabrielhernandes.crudcomposecities.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.gabrielhernandes.crudcomposecities.data.entities.Cities
import com.gabrielhernandes.crudcomposecities.data.repository.CitiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(citiesDao: CitiesRepository) : ViewModel() {

    val cities: LiveData<List<Cities>> = citiesDao.getAll().asLiveData()
}