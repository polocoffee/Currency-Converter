package com.banklannister.currencyconverter.data

import com.banklannister.currencyconverter.Constants.END_POINT
import com.banklannister.currencyconverter.data.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrencyApi {


    @GET(END_POINT)
    suspend fun getRates(
        @Query("base") base: String
    ): Response<CurrencyResponse>
}