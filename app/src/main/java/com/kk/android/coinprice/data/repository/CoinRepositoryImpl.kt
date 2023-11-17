package com.kk.android.coinprice.data.repository

import com.kk.android.coinprice.data.remote.CoinPaprikaApi
import com.kk.android.coinprice.data.remote.dto.CoinDetailsDto
import com.kk.android.coinprice.data.remote.dto.CoinDto
import com.kk.android.coinprice.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailsDto {
        return api.getCoinDetails(coinId)
    }
}
