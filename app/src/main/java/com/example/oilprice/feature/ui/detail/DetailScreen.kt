package com.example.oilprice.feature.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oilprice.R
import com.example.oilprice.feature.domian.model.Oil
import com.example.oilprice.feature.ui.shared.SharedViewModel
import com.example.oilprice.ui.theme.Black01
import com.example.oilprice.ui.theme.Blue02
import com.example.oilprice.ui.theme.Green01
import com.example.oilprice.ui.theme.OilPriceTheme
import com.example.oilprice.ui.theme.promptBold
import com.example.oilprice.ui.theme.promptRegular

@Composable
fun DetailScreen(nav: NavController, sharedViewModel: SharedViewModel) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.bg_sky),
            contentDescription = null,
            modifier = Modifier.height(300.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
            .align(Alignment.TopCenter)
        ) {
            Text(
                text = sharedViewModel.station.name,
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 40.sp,
                color = Green01,
                fontFamily = promptBold,

            )
            Text(
                text = sharedViewModel.station.date,
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 16.sp,
                color = Black01,
                fontFamily = promptRegular
            )
        }
        Card(
            modifier = Modifier.padding(top = 100.dp).fillMaxSize(),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            colors = CardDefaults.cardColors(Blue02)
        )
        {
            LazyColumn(content = {
                items(sharedViewModel.station.oil){oil ->
                    CardOilPrice(oil = oil)
                }
            })
        }


    }
}

@Composable
fun CardOilPrice (oil: Oil){
    Card(
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
            Text(
                text = oil.name,
                modifier = Modifier
                    .weight(3f),
                fontSize = 24.sp,
                fontFamily = promptRegular,
                color = Black01
            )

            Text(
                text = oil.price.toString(),
                modifier = Modifier
                    .align(CenterVertically)
                    .weight(1f),
                fontSize = 24.sp,
                fontFamily = promptRegular,
                color = Black01
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    OilPriceTheme {
        val navController = rememberNavController()
        val sharedViewModel = hiltViewModel<SharedViewModel>()
        DetailScreen(navController, sharedViewModel )
    }
}

@Preview
@Composable
fun CardOilPricePreview(){
    OilPriceTheme {
        CardOilPrice(oil = Oil("ดีเซล",43.43) )
    }
}