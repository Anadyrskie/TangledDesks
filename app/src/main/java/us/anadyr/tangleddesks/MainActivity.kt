package us.anadyr.tangleddesks

import android.R.string
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.CoreComponentFactory
import android.webkit.WebSettings as WebkitWebSettings


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myWebView = WebView(baseContext)
        CookieManager.getInstance().acceptCookie()
        CookieManager.getInstance().setCookie("http://web-dev.tangleddesks.com", "userid=2")
        CookieManager.getInstance().setCookie("http://web-dev.tangleddesks.com", "key=55cd5012e364b39879c0930a6dd3255b1602430390")
        myWebView.getSettings().javaScriptEnabled = true
        myWebView.loadUrl("http://web-dev.tangleddesks.com/main.html")


        setContentView(myWebView)
    }
}