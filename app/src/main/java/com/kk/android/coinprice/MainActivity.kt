package com.kk.android.coinprice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kk.android.coinprice.common.Constants
import com.kk.android.coinprice.ui.Screen
import com.kk.android.coinprice.ui.coindetail.CoinDetailScreen
import com.kk.android.coinprice.ui.coindetail.WebViewScreen
import com.kk.android.coinprice.ui.coinlist.CoinListScreen
import com.kk.android.coinprice.ui.theme.CoinPriceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinPriceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
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
                            CoinDetailScreen(onCoinNameClicked = { coinName, coinSymbol ->
                                navController.navigate(Screen.CoinWebPageScreen.route + "/${coinName}/${coinSymbol}")
                            })
                        }
                        composable(
                            Screen.CoinWebPageScreen.route + "/{coinName}/{coinSymbol}",
                            arguments = listOf(
                                navArgument("coinName") {
                                    type = NavType.StringType
                                }, navArgument("coinSymbol") {
                                    type = NavType.StringType
                                })
                        )
                        {
                            WebViewScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoinPriceTheme {
        Greeting("Android")
    }
}