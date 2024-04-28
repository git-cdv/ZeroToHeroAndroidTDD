package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.actionButton)
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val tv = findViewById<TextView>(R.id.titleTextView)
        btn.setOnClickListener {
            btn.isEnabled = false
            progress.isVisible = true
            btn.postDelayed({
                tv.isVisible = true
                btn.isEnabled = true
                progress.isVisible = false
            }, 3000)
        }
    }
}