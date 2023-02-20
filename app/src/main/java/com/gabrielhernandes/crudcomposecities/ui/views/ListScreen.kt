package com.gabrielhernandes.crudcomposecities.ui.views

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gabrielhernandes.crudcomposecities.data.entities.Cities
import com.gabrielhernandes.crudcomposecities.viewmodels.ListScreenViewModel

@Composable
fun ListScreen(navController: NavController, viewModel: ListScreenViewModel = hiltViewModel()) {
    val cities = viewModel.cities.observeAsState(listOf())

    LazyColumn {
        itemsIndexed(cities.value) { _, item ->
            card(navController = navController, cidade = item)
        }
    }
}

@Composable
private fun card(navController: NavController, cidade: Cities) {
    Card(elevation = 4.dp, modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(36.dp)
        .clickable {
            navController.currentBackStackEntry?.arguments = Bundle().apply {
                putParcelable("cidade", cidade)
            }
            navController.navigate("TelaDetalhes")

        }) {
        Column() {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = cidade.nome.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}