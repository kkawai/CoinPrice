package com.kk.android.coinprice

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoinPriceApplication: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}