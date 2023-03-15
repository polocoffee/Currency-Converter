package com.banklannister.currencyconverter.main

import com.banklannister.currencyconverter.data.model.CurrencyResponse
import com.banklannister.currencyconverter.utils.Resource

interface MainRepository {

    suspend fun getRates(base: String): Resource<CurrencyResponse>

}