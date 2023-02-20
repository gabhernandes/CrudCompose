package com.gabrielhernandes.crudcomposecities.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gabrielhernandes.crudcomposecities.data.entities.Cities
import com.gabrielhernandes.crudcomposecities.ui.theme.CrudComposeCitiesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrudComposeCitiesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "TelaInicial") {
                        composable("TelaInicial") { InitialScreen(navController) }
                        composable("TelaCadastro") { ScreenRegister(navController = navController) }
                        composable("TelaDetalhes") {
                            val cidade = navController.previousBackStackEntry?.arguments?.getParcelable<Cities>("cidade")
                            cidade?.let {
                                DetailScreen(navController = navController, cidade = cidade)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun InitialScreen(navController: NavHostController) {
        Scaffold(topBar = {
            TopAppBar() {
                Text(text = "Cidades", Modifier.padding(6.dp))
            }
        }, floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("TelaCadastro") }) {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        }) {
            ListScreen(navController = navController)
        }
    }
}

