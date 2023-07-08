package com.example.oilprice.feature.data.remote

import com.example.oilprice.feature.data.remote.model.OilPriceResponse
import retrofit2.Response
import retrofit2.http.GET

interface OilPriceApi {

    @GET("latest")
    suspend fun getOil(): Response<OilPriceResponse>


}