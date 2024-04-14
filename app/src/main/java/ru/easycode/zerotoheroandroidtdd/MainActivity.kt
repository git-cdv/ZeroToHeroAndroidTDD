package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_HIDE_STATE = "myState"
    }

    private var isHided: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.titleTextView)
        val btnChange = findViewById<Button>(R.id.changeButton)
        val btnHide = findViewById<Button>(R.id.hideButton)
        textView.isVisible = !isHided

        btnChange.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
        btnHide.setOnClickListener {
            textView.isVisible = false
            isHided = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(KEY_HIDE_STATE, isHided)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isHided = savedInstanceState.getBoolean(KEY_HIDE_STATE)
    }

}