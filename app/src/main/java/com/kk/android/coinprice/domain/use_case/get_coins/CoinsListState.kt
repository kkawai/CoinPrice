package com.kk.android.coinprice.domain.use_case.get_coins

import com.kk.android.coinprice.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
