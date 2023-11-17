package com.kk.android.coinprice.domain.use_case.get_coins

import com.kk.android.coinprice.common.Resource
import com.kk.android.coinprice.data.remote.dto.toCoin
import com.kk.android.coinprice.domain.model.Coin
import com.kk.android.coinprice.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Unexpected HttpException occurred: "+e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach server. Check internet connection. " + e.localizedMessage))
        }
    }
}