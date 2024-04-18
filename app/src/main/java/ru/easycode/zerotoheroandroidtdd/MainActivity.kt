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
    private lateinit var removeButton : Button

    private var isHided: Boolean = false
    private var state: State = State.Initial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        val btnChange = findViewById<Button>(R.id.changeButton)
        val btnHide = findViewById<Button>(R.id.hideButton)
        removeButton = findViewById(R.id.removeButton)

        btnChange.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
        btnHide.setOnClickListener {
            textView.isVisible = false
            isHided = true
        }
        removeButton.setOnClickListener {
            state = State.Removed
            state.removeViewAndDisableButton(rootLayout,textView,removeButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(KEY_HIDE_STATE, state)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY_HIDE_STATE) as State
        state.removeViewAndDisableButton(rootLayout,textView,removeButton)
    }

}

interface State : Serializable {

    fun removeViewAndDisableButton (linearLayout : LinearLayout, textView : TextView, button: Button)

    object Initial : State {
        override fun removeViewAndDisableButton(linearLayout: LinearLayout, textView: TextView, button: Button)  = Unit
    }

    object Removed : State {
        override fun removeViewAndDisableButton(linearLayout: LinearLayout, textView: TextView, button: Button){
            linearLayout.removeView(textView)
            button.isEnabled = false
        }
    }
}