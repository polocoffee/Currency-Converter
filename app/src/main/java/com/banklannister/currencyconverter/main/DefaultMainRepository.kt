package com.banklannister.currencyconverter.main

import com.banklannister.currencyconverter.data.CurrencyApi
import com.banklannister.currencyconverter.data.model.CurrencyResponse
import com.banklannister.currencyconverter.utils.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {
    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(base)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: java.lang.Exception) {
            Resource.Error(e.message ?: "An Error occured")
        }
    }
}