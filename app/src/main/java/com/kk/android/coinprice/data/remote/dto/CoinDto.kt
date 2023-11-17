package com.kk.android.coinprice.data.remote.dto

import com.kk.android.coinprice.domain.model.Coin
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto (

  val id       : String,
  val name     : String,
  val symbol   : String,
  val rank     : Int,
  val isNew    : Boolean,
  val isActive : Boolean,
  val type     : String

)

fun CoinDto.toCoin(): Coin {

  return Coin(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    isNew = isNew,
    isActive = isActive,
    type = type
  )
}