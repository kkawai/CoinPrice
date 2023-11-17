package com.kk.android.coinprice.data.remote.dto

import com.kk.android.coinprice.domain.model.CoinDetail
import com.kk.android.coinprice.domain.model.TeamMember
import kotlinx.serialization.Serializable


@Serializable
data class CoinDetailsDto (

  val id                : String                  = "",
  val name              : String                  = "",
  val symbol            : String                  = "",
  val rank              : Int                     = 0,
  val isNew             : Boolean                 = false,
  val isActive          : Boolean                 = false,
  val type              : String                  = "",
  val logo              : String                  = "",
  val tags              : ArrayList<TagsDto>          = arrayListOf(),
  val team              : ArrayList<TeamMemberDto>          = arrayListOf(),
  val description       : String                  = "",
  val message           : String                  = "",
  val openSource        : Boolean                 = true,
  val startedAt         : String                  = "",
  val developmentStatus : String                  = "",
  val hardwareWallet    : Boolean                 = false,
  val proofType         : String                  = "",
  val orgStructure      : String                  = "",
  val hashAlgorithm     : String                  = "",
  val links             : LinksDto                   = LinksDto(),
  val linksExtended     : ArrayList<LinksExtendedDto> = arrayListOf(),
  val whitepaper        : WhitepaperDto              = WhitepaperDto(),
  val firstDataAt       : String                  = "",
  val lastDataAt        : String                  = ""

)

fun CoinDetailsDto.toCoinDetail(): CoinDetail {
  return CoinDetail(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isNew = isNew,
    isActive = isActive?:false,
    type = type,
    tags = tags.map{it.name},
    team = team.map{ TeamMember(id = it.id, name = it.name, position = it.position) }

  )
}