package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    private var isHided: Boolean = false
    private var state: State = State.Initial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        val btnChange = findViewById<Button>(R.id.changeButton)
        val btnHide = findViewById<Button>(R.id.hideButton)
        val btnRemove = findViewById<Button>(R.id.removeButton)

        btnChange.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
        btnHide.setOnClickListener {
            textView.isVisible = false
            isHided = true
        }
        btnRemove.setOnClickListener {
            state = State.Removed
            state.apply(rootLayout,textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(KEY_HIDE_STATE, state)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY_HIDE_STATE) as State
        state.apply(rootLayout,textView)
    }

}

interface State : Serializable {

    fun apply (linearLayout : LinearLayout, textView : TextView)

    object Initial : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView)  = Unit
    }

    object Removed : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView){
            linearLayout.removeView(textView)
        }
    }
}