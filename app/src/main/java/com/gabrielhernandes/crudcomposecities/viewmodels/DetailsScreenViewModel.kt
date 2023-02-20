package com.gabrielhernandes.crudcomposecities.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielhernandes.crudcomposecities.data.entities.Cities
import com.gabrielhernandes.crudcomposecities.data.repository.CitiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(private val citiesDao: CitiesRepository) :
    ViewModel() {
    var id by mutableStateOf(0)

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    private val _cep = MutableLiveData<String>()
    val cep: LiveData<String> = _cep
    private val _uf = MutableLiveData<String>()
    val uf: LiveData<String> = _uf

    fun onChangeNome(newValue: String) {
        _name.value = newValue
    }

    fun onChangeCep(newValue: String) {
        _cep.value = newValue
    }

    fun onChangeUf(newValue: String) {
        _uf.value = newValue
    }

    var state: MutableLiveData<Boolean> = MutableLiveData()


    fun update() {
        viewModelScope.launch(Dispatchers.IO) {
            citiesDao.update(
                Cities(
                    id = id,
                    uf = uf.value,
                    nome = name.value,
                    cep = cep.value
                )
            )
            state.postValue(true)
        }
    }

    fun remove() {
        viewModelScope.launch(Dispatchers.IO) {
            citiesDao.remove(
                Cities(
                    id = id,
                    uf = uf.value,
                    nome = name.value,
                    cep = cep.value
                )
            )
            state.postValue(true)
        }
    }
}