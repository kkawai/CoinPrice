package com.kk.android.coinprice.data.remote.dto

import com.kk.android.coinprice.domain.model.Coin
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto (

  val id       : String,
  val name     : String,
  val symbol   : String,
  val rank     : Int,
  val is_new    : Boolean,
  val is_active : Boolean,
  val type     : String

)

fun CoinDto.toCoin(): Coin {

  return Coin(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    isNew = is_new,
    isActive = is_active,
    type = type
  )
}