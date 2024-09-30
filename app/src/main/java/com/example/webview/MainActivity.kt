package com.example.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // use view bind
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // convert website into app
        // binding.webView.loadUrl("https://66f37c9156c6a4a3bc16cf1a--lustrous-starship-ed2ffe.netlify.app/")
        binding.webView.loadUrl("https://www.youtube.com/")
       // enable javascript now work proper javascript functions in website
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient() // link open in this app no browsers
    }
    // when go back from page so not direct close app, back by back
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event != null && binding.webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {
            binding.webView.goBack() // Go back in the WebView
            return true // Indicate that the event was handled
        }
        return super.onKeyDown(keyCode, event) // Default behavior for other keys
    }

}