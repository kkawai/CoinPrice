package com.kk.android.coinprice.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LinksDto (

  val explorer   : ArrayList<String> = arrayListOf(),
  val facebook   : ArrayList<String> = arrayListOf(),
  val reddit     : ArrayList<String> = arrayListOf(),
  val source_code : ArrayList<String> = arrayListOf(),
  val website    : ArrayList<String> = arrayListOf(),
  val youtube    : ArrayList<String> = arrayListOf()

)