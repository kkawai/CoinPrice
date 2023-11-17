package com.kk.android.coinprice.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TagsDto (

  val id          : String,
  val name        : String,
  val coinCounter : Int    = 0,
  val icoCounter  : Int    = 0

)