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
  val is_new             : Boolean                 = false,
  val is_active          : Boolean                 = false,
  val type              : String                  = "",
  //val logo              : String                  = "",
  val tags              : ArrayList<TagsDto>          = arrayListOf(),
  val team              : ArrayList<TeamMemberDto>          = arrayListOf(),
  val description       : String                  = "",
  val message           : String                  = "",
  //val open_source        : Boolean                 = true,
  //val started_at         : String                  = "",
  //val development_status : String                  = "",
  //val hardware_wallet    : Boolean                 = false,
  //val proof_type         : String                  = "",
  //val org_structure      : String                  = "",
  //val hash_algorithm     : String                  = "",
  //val links             : LinksDto                   = LinksDto(),
  //val links_extended     : ArrayList<LinksExtendedDto> = arrayListOf(),
  //val whitepaper        : WhitepaperDto              = WhitepaperDto(),
  //val first_data_at       : String                  = "",
  //val last_data_at        : String                  = ""

)

fun CoinDetailsDto.toCoinDetail(): CoinDetail {
  return CoinDetail(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isNew = is_new,
    isActive = is_active?:false,
    type = type,
    tags = tags.map{it.name},
    team = team.map{ TeamMember(id = it.id, name = it.name, position = it.position) }

  )
}