package com.kk.android.coinprice.ui.coindetail

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WebViewScreen(viewModel: CoinDetailViewModel = hiltViewModel()) {
    val context = LocalContext.current
    AndroidView(factory = {
        WebView(context).apply {
            webViewClient = WebViewClient()
            loadUrl("https://www.google.com/search?q=${viewModel.coinName}+${viewModel.coinSymbol}+price")
        }
    })
}
