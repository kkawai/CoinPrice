package com.kk.android.coinprice.domain.repository

import com.kk.android.coinprice.data.remote.dto.CoinDetailsDto
import com.kk.android.coinprice.data.remote.dto.CoinDto


interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinDetails(coinId: String): CoinDetailsDto
}