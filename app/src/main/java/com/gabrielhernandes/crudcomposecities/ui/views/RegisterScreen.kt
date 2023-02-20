package com.gabrielhernandes.crudcomposecities.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gabrielhernandes.crudcomposecities.viewmodels.RegisterScreenViewModel

@Composable
fun ScreenRegister(
    viewModel: RegisterScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val nome = viewModel.name.value
    val cep = viewModel.cep.value
    val uf = viewModel.uf.value

    val state = viewModel.state.observeAsState()

    if (state.value == true) {
        navController.popBackStack()
    }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(label = { Text(text = "NOME") }, value = nome, onValueChange = {
            viewModel.onChangeNome(it)
        })
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(label = { Text(text = "CEP") }, value = cep, onValueChange = {
            viewModel.onChangeCep(it)
        })
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(label = { Text(text = "UF") }, value = uf, onValueChange = {
            viewModel.onChangeUf(it)
        })
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedButton(onClick = { viewModel.register() }, modifier = Modifier.fillMaxWidth().padding(horizontal = 64.dp)) {
            Text(text = "Registrar")
        }
    }
}