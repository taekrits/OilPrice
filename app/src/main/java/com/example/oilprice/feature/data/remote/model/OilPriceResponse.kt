package com.example.oilprice.feature.data.remote.model

data class OilPriceResponse(
    val status: String,
    val response: Response
)

data class Response(
    val note: String,
    val date: String,
    val stations: Stations
)

data class Stations(
    val ptt: Ptt,
    val bcp: Bcp,
    val shell: Shell,
    val esso: Esso,
    val caltex: Caltex,
    val irpc: Irpc,
    val pt: Pt,
    val susco: Susco,
    val pure: Pure,
    val susco_dealers: SuscoDealers
)

data class FuelType(
    val name: String,
    val price: String
)

data class Ptt(
    val gasoline_95: FuelType,
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val gasohol_e85: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType,
    val diesel_b20: FuelType,
    val premium_diesel: FuelType,
    val premium_gasohol_95: FuelType,
    val superpower_gasohol_95: FuelType
)

data class Bcp(
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val gasohol_e85: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType,
    val diesel_b20: FuelType,
    val premium_gasohol_95: FuelType,
    val premium_gasohol_97: FuelType,
    val premium_diesel: FuelType
)

data class Shell(
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType,
    val diesel_b20: FuelType,
    val premium_gasohol_95: FuelType,
    val premium_diesel: FuelType,
    val vpower_gasohol_95: FuelType,
    val vpower_diesel: FuelType,
    val vpower_diesel_b7: FuelType
)

data class Esso(
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType,
    val premium_gasohol_95: FuelType,
    val premium_diesel: FuelType
)

data class Caltex(
    val gasoline_95: FuelType,
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType,
    val diesel_b20: FuelType,
    val premium_diesel: FuelType
)

data class Irpc(
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType
)

data class Pt(
    val gasoline_95: FuelType,
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType,
    val diesel_b20: FuelType
)

data class Susco(
    val gasoline_95: FuelType,
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType,
    val ngv: FuelType
)

data class Pure(
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType
)

data class SuscoDealers(
    val gasoline_95: FuelType,
    val gasohol_95: FuelType,
    val gasohol_91: FuelType,
    val gasohol_e20: FuelType,
    val diesel: FuelType,
    val diesel_b7: FuelType
)
