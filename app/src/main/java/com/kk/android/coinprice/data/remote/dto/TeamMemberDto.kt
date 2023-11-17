package com.kk.android.coinprice.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TeamMemberDto (

  val id       : String,
  val name     : String,
  val position : String

)