package com.kk.android.coinprice.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Coin(
    var id: String = "",
    var name: String = "",
    var symbol: String = "",
    var rank: Int = 1,
    var isNew: Boolean = true,
    var isActive: Boolean = true,
    var type: String = ""
)
