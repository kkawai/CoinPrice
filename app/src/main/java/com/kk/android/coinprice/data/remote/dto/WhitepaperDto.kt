package com.kk.android.coinprice.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WhitepaperDto (

  val link      : String = "",
  val thumbnail : String = ""

)