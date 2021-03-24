package com.comics.game

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.comics.game.dao.StoreFactory
import com.comics.game.ui.presenters.MainActivityPresenter

class MainActivity : AppCompatActivity() {
    private val presenter: MainActivityPresenter = MainActivityPresenter()

    private lateinit var questionTextView: TextView
    private lateinit var answer1: TextView
    private lateinit var answer2: TextView
    private lateinit var answer3: TextView
    private lateinit var answer4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        presenter.onCreate(this)

        presenter.startGame()
    }

    private fun initViews() {
        questionTextView = findViewById(R.id.game_box__question)

        answer1 = findViewById(R.id.game_box__answer1)
        answer2 = findViewById(R.id.game_box__answer2)
        answer3 = findViewById(R.id.game_box__answer3)
        answer4 = findViewById(R.id.game_box__answer4)
    }

    fun setQuestion(question: String) {
        questionTextView.text = question
    }

    fun setAnswer(number: Int, text: String) {
        when (number) {
            1 -> updateAnswerField(text, answer1)
            2 -> updateAnswerField(text, answer2)
            3 -> updateAnswerField(text, answer3)
            4 -> updateAnswerField(text, answer4)
        }
    }

    private fun updateAnswerField(text: String, view: TextView) {
        view.text = text
        if (text.length > 2) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    fun choose1(view: View) {
        presenter.chooseAnswer(1)
    }

    fun choose2(view: View) {
        presenter.chooseAnswer(2)
    }

    fun choose3(view: View) {
        presenter.chooseAnswer(3)
    }

    fun choose4(view: View) {
        presenter.chooseAnswer(4)
    }
}