package com.kk.android.coinprice.ui.coinlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.android.coinprice.common.Resource
import com.kk.android.coinprice.domain.use_case.get_coins.CoinsListState
import com.kk.android.coinprice.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {

    private val _coinsListState = mutableStateOf(CoinsListState())
    val coinsListState: State<CoinsListState> = _coinsListState

    init {
        getCoins()
    }

    fun getCoins() {
        getCoinsUseCase()
            .distinctUntilChanged()
            .onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _coinsListState.value = CoinsListState(
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _coinsListState.value = CoinsListState(
                            coins = result.data ?: emptyList()
                        )
                    }

                    is Resource.Error -> {
                        _coinsListState.value = CoinsListState(
                            error = result.message ?: "An unexpected error occurred."
                        )
                    }
                }
            }.launchIn(viewModelScope + SupervisorJob())
    }
}