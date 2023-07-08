package com.example.oilprice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oilprice.feature.ui.detail.DetailScreen
import com.example.oilprice.feature.ui.main.MainScreen
import com.example.oilprice.feature.ui.shared.SharedViewModel
import com.example.oilprice.ui.theme.OilPriceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OilPriceTheme {

                val navController = rememberNavController()
                val sharedViewModel = hiltViewModel<SharedViewModel>()
                NavHost(navController = navController, startDestination = "main") {

                    composable("main") { MainScreen(navController, sharedViewModel = sharedViewModel)  }
                    composable("detail") { DetailScreen(navController, sharedViewModel = sharedViewModel) }
                }





            }
        }
    }
}

