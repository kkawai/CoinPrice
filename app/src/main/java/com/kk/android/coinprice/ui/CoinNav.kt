package com.kk.android.coinprice.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kk.android.coinprice.common.Constants
import com.kk.android.coinprice.ui.coindetail.CoinDetailScreen
import com.kk.android.coinprice.ui.coindetail.WebViewScreen
import com.kk.android.coinprice.ui.coinlist.CoinListScreen

@Composable
fun CoinNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(Screen.CoinListScreen.route) {
            CoinListScreen(onCoinClicked = { coinId ->
                navController.navigate(
                    Screen.CoinDetailScreen.route + "/${coinId}"
                )
            }
            )
        }
        composable(
            Screen.CoinDetailScreen.route + "/{" + Constants.PARAM_COIN_ID + "}",
            arguments = listOf(navArgument(Constants.PARAM_COIN_ID) {
                type = NavType.StringType
            })
        )
        {
            CoinDetailScreen(onFetchCoinPrice = { coinName, coinSymbol ->
                navController.navigate(Screen.CoinWebPageScreen.route + "/${coinName}/${coinSymbol}")
            })
        }
        composable(
            Screen.CoinWebPageScreen.route + "/{" + Constants.PARAM_COIN_NAME + "}/{" + Constants.PARAM_COIN_SYMBOL + "}",
            arguments = listOf(
                navArgument(Constants.PARAM_COIN_NAME) {
                    type = NavType.StringType
                }, navArgument(Constants.PARAM_COIN_SYMBOL) {
                    type = NavType.StringType
                })
        )
        { backStackEntry ->
            WebViewScreen(
                backStackEntry.arguments?.getString(Constants.PARAM_COIN_NAME) ?: "",
                backStackEntry.arguments?.getString(Constants.PARAM_COIN_SYMBOL) ?: ""
            )
        }
    }

}