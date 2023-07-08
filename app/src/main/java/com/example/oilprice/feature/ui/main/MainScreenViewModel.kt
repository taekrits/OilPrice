package com.example.oilprice.feature.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oilprice.feature.data.mapper.toOilPrice
import com.example.oilprice.feature.data.remote.OilPriceApi
import com.example.oilprice.feature.domian.model.Oil
import com.example.oilprice.feature.domian.model.OilPrice
import com.example.oilprice.feature.domian.model.Station
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(api:OilPriceApi) :ViewModel() {

    var state by mutableStateOf(
        OilPrice()
    )
        private set

    init {
        viewModelScope.launch {
            val oilPrice =  withContext(Dispatchers.IO){ api.getOil().body()?.toOilPrice()}
            state = oilPrice ?: OilPrice()
        }
    }


}