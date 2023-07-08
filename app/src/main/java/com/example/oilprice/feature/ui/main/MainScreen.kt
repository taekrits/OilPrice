package com.example.oilprice.feature.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oilprice.R
import com.example.oilprice.feature.domian.model.Station
import com.example.oilprice.feature.ui.shared.SharedViewModel
import com.example.oilprice.ui.theme.Black01
import com.example.oilprice.ui.theme.Blue02
import com.example.oilprice.ui.theme.Green01
import com.example.oilprice.ui.theme.Green02
import com.example.oilprice.ui.theme.OilPriceTheme
import com.example.oilprice.ui.theme.promptBold
import com.example.oilprice.ui.theme.promptRegular

@Composable
fun MainScreen(nav: NavController, viewModel: MainScreenViewModel = hiltViewModel(),sharedViewModel: SharedViewModel) {
        Box(){
            Image(
                painter = painterResource(id = R.drawable.bg_sky) ,
                contentDescription = null,
                modifier = Modifier.height(300.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 80.dp)
            ) {
                Text(
                    text = "ราคาน้ำมันวันนี้",
                    fontSize = 40.sp,
                    color = Green01,
                    fontFamily = promptBold
                )
                Text(
                    text = viewModel.state.date,
                    fontSize = 24.sp,
                    color = Black01,
                    fontFamily = promptRegular
                )
            }
            Card(
                modifier = Modifier.padding(top = 280.dp),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                colors = CardDefaults.cardColors(Blue02)
            )
            {
                Text(
                    text = "รายชื่อสถานี",
                    modifier = Modifier.padding(start = 24.dp, top = 16.dp),
                    fontFamily = promptRegular,
                    fontSize = 24.sp,
                    color = Black01

                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    content = {
                  items(viewModel.state.station){station ->
                    stationCard(station, modifier = Modifier, nav = nav, sharedViewModel = sharedViewModel)
                  }
                },
                    modifier = Modifier.padding(16.dp)

                )
            }
        }
}

@Composable
fun stationCard(station: Station, modifier: Modifier, nav: NavController, sharedViewModel: SharedViewModel){
    Card(
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                sharedViewModel.station = station
                nav.navigate("detail")
            }
            .height(120.dp)
        ,
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Text(
                text = station.name,
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
                    .align(Center),
                fontFamily = promptBold,
                fontSize = 20.sp,
                color = Black01
            )
        }

    }
}

@Preview
@Composable
fun MainScreenPreview(){
    OilPriceTheme {
        val navController = rememberNavController()
        val sharedViewModel = hiltViewModel<SharedViewModel>()
        MainScreen(navController, sharedViewModel = sharedViewModel)
    }
}

@Preview
@Composable
fun stationCardPreview(){
    OilPriceTheme() {
        val navController = rememberNavController()
        val sharedViewModel = hiltViewModel<SharedViewModel>()
        stationCard(station = Station("PTT", listOf()), modifier = Modifier, navController,sharedViewModel = sharedViewModel)
    }
}