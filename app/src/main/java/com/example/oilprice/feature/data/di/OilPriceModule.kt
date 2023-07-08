package com.example.oilprice.feature.data.di

import com.example.oilprice.feature.data.remote.OilPriceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OilPriceModule {

    @Provides
    fun provideOilPriceApi(
        // Potential dependencies of this type
    ): OilPriceApi {
        return Retrofit.Builder()
            .baseUrl("https://api.chnwt.dev/thai-oil-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OilPriceApi::class.java)
    }
}