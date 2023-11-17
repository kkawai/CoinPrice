package com.kk.android.coinprice.domain.use_case.get_coin

import com.kk.android.coinprice.domain.model.CoinDetail

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetail = CoinDetail(),
    val error: String = ""
)
