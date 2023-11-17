package com.kk.android.coinprice.domain.model


data class CoinDetail(
    val coinId: String = "",
    val name: String = "",
    val description: String = "",
    val symbol: String = "",
    val rank: Int = 0,
    val isNew: Boolean = false,
    val isActive: Boolean = false,
    val type: String = "",
    val tags: List<String> = emptyList(),
    val team: List<TeamMember> = emptyList()
)

