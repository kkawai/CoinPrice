package com.kk.android.coinprice.ui.coindetail

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewScreen(coinName: String, coinSymbol: String) {
    val context = LocalContext.current
    AndroidView(factory = {
        WebView(context).apply {
            webViewClient = WebViewClient()
            loadUrl("https://www.google.com/search?q=${coinName}+${coinSymbol}+price")
        }
    })
}
