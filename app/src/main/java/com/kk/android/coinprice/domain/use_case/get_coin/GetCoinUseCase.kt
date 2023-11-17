package com.kk.android.coinprice.domain.use_case.get_coin

import com.kk.android.coinprice.common.Resource
import com.kk.android.coinprice.data.remote.dto.toCoinDetail
import com.kk.android.coinprice.domain.model.CoinDetail
import com.kk.android.coinprice.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = coinRepository.getCoinDetails(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Unexpected HttpException occurred: "+e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach server. Check internet connection. " + e.localizedMessage))
        }
    }
}