package us.anadyr.tangleddesks

//Apache
import RestApiService
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.math.log
import kotlin.system.exitProcess


//import org.apache.http.HttpRequest


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myWebView = WebView(baseContext)
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()



        myWebView.loadUrl("http://web-dev.tangleddesks.com/login.html")


        setContentView(myWebView)
        //setContentView(R.layout.activity_main);



    }


    override fun onStop() {
        super.onStop()


    }


}