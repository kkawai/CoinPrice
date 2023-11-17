package com.kk.android.coinprice.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TagsDto (

  val id          : String,
  val name        : String,
  val coin_counter : Int    = 0,
  val ico_counter  : Int    = 0

)