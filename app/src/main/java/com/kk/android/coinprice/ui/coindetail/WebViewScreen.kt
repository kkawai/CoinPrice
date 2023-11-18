package com.kk.android.coinprice.ui.coindetail

import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
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
            webViewClient = object : WebViewClient() {
                override fun onReceivedError(
                    view: WebView,
                    request: WebResourceRequest,
                    error: WebResourceError
                ) {
                    loadErrorPage(view)
                }
            }
            loadUrl("https://www.google.com/search?q=${coinName}+${coinSymbol}+price")
        }
    })
}

fun loadErrorPage(webview: WebView) {
    val htmlData =
        "<html><body><div align=\"center\" >No internet connection.  Go back and try again.</div></body>"
    webview.loadUrl("about:blank")
    webview.loadDataWithBaseURL(null, htmlData, "text/html", "UTF-8", null)
    webview.invalidate()
}
