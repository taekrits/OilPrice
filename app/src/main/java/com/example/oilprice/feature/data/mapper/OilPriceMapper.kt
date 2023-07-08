package com.example.oilprice.feature.data.mapper

import com.example.oilprice.feature.data.remote.model.FuelType
import com.example.oilprice.feature.data.remote.model.OilPriceResponse
import com.example.oilprice.feature.data.remote.model.Stations
import com.example.oilprice.feature.domian.model.Oil
import com.example.oilprice.feature.domian.model.OilPrice
import com.example.oilprice.feature.domian.model.Station

fun OilPriceResponse.toOilPrice(): OilPrice {
    val stations = this.response.stations
    val oilPrices = mutableListOf<Station>()

    val allStations = listOf(
        "ptt" to stations.ptt,
        "bcp" to stations.bcp,
        "shell" to stations.shell,
        "esso" to stations.esso,
        "caltex" to stations.caltex,
        "irpc" to stations.irpc,
        "pt" to stations.pt,
        "susco" to stations.susco,
        "pure" to stations.pure,
        "susco_dealers" to stations.susco_dealers
    )

    allStations.forEach { (stationName, stationData) ->
        val oils = stationData::class.java.declaredFields.mapNotNull { field ->
            field.isAccessible = true
            val fuel = field.get(stationData) as? FuelType
            fuel?.let { Oil(it.name, it.price.toDoubleOrNull() ?: 0.0) }
        }
        oilPrices.add(Station(stationName, oils, this.response.date))
    }

    return OilPrice(this.response.date, oilPrices)
}