package com.gabrielhernandes.crudcomposecities.viewmodels

import androidx.compose.runtime.mutableStateOf
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
class RegisterScreenViewModel @Inject constructor(private val citiesDao: CitiesRepository) : ViewModel() {
    val name = mutableStateOf("")
    val cep = mutableStateOf("")
    val uf = mutableStateOf("")


    fun onChangeNome(newValue: String) {
        name.value = newValue
    }

    fun onChangeCep(newValue: String) {
        cep.value = newValue
    }

    fun onChangeUf(newValue: String) {
        uf.value = newValue
    }

    val state: MutableLiveData<Boolean> = MutableLiveData()

    fun register() {
        viewModelScope.launch(Dispatchers.IO) {
            citiesDao.add(Cities(cep = cep.value, uf = uf.value, nome = name.value))
            state.postValue(true)
        }
    }
}
