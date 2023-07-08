package com.example.oilprice.feature.domian.model

data class Station(
    val name: String = "",
    val oil: List<Oil> = listOf(),
    val date: String = ""
)
