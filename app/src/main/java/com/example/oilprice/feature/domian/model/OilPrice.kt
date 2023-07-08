package com.example.oilprice.feature.domian.model

data class OilPrice(
    var date: String = "",
    var station: List<Station> = listOf()
)
