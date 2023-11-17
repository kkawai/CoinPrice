package com.kk.android.coinprice.ui

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list")
    object CoinDetailScreen: Screen("coin_details")
}
