package com.comics.game

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.comics.game.ui.BaseActivity

class StartActivity: BaseActivity() {
    companion object {
        const val RESULT_MESSAGE: String = "result_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val resultMessage = intent.getStringExtra(RESULT_MESSAGE)
        if (resultMessage != null) {
            findViewById<LinearLayout>(R.id.result_box).visibility = View.VISIBLE
            findViewById<TextView>(R.id.result_box__text).text = resultMessage
        }
    }

    fun handleStartGame(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}