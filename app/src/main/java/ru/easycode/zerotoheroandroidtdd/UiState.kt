package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface UiState {

    fun apply(button: Button, progressBar: ProgressBar, textView: TextView)
    object ShowProgress : UiState{
        override fun apply(button: Button, progressBar: ProgressBar, textView: TextView) {
            button.isEnabled = false
            progressBar.isVisible = true
        }
    }
    object ShowData : UiState{
        override fun apply(button: Button, progressBar: ProgressBar, textView: TextView) {
            button.isEnabled = true
            progressBar.isVisible = false
            textView.isVisible = true
        }
    }
}