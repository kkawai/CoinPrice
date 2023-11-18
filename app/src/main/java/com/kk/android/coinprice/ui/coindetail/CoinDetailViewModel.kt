package com.kk.android.coinprice.ui.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.android.coinprice.common.Constants
import com.kk.android.coinprice.common.Resource
import com.kk.android.coinprice.domain.model.CoinDetail
import com.kk.android.coinprice.domain.use_case.get_coin.CoinDetailsState
import com.kk.android.coinprice.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(private val getCoinUseCase: GetCoinUseCase,
                                              savedStateHandle: SavedStateHandle): ViewModel() {

    private val _coinDetailsState = mutableStateOf(CoinDetailsState())
    val coinDetailState: State<CoinDetailsState> = _coinDetailsState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId)
            .distinctUntilChanged()
            .onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _coinDetailsState.value = CoinDetailsState(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _coinDetailsState.value = CoinDetailsState(
                        coin = result.data?: CoinDetail()
                    )
                }
                is Resource.Error -> {
                    _coinDetailsState.value = CoinDetailsState(
                        error = result.message?:"An unexpected error occurred."
                    )
                }
            }
        }.launchIn(viewModelScope + SupervisorJob())
    }
}