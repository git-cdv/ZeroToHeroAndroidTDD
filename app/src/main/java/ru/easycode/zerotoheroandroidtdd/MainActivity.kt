package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_HIDE_STATE = "myState"
    }

    private lateinit var rootLayout : LinearLayout
    private lateinit var textView : TextView
    private lateinit var button : Button

    private val count = Count.Base(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            textView.text = count.increment(textView.text.toString())
        }
    }

/*    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(KEY_HIDE_STATE, state)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY_HIDE_STATE) as State
        state.removeViewAndDisableButton(rootLayout,textView,removeButton)
    }*/

}