package com.example.oilprice.feature.ui.shared

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oilprice.feature.domian.model.Oil
import com.example.oilprice.feature.domian.model.Station
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor():ViewModel() {

    var station by mutableStateOf(Station())

}