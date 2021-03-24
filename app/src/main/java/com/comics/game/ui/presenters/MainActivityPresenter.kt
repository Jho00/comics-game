package com.comics.game.ui.presenters

import android.widget.Toast
import com.comics.game.MainActivity
import com.comics.game.core.Game
import com.comics.game.entity.Answer

class MainActivityPresenter {
    private lateinit var activity: MainActivity
    private lateinit var game: Game

    fun onCreate(activity: MainActivity) {
        this.activity = activity

        game = Game()
        game.init(activity.applicationContext)
    }

    fun startGame() {
        updateView()
    }

    private fun updateView() {
        if (game.isGameEnd()) {
            showEndGame()
            return
        }

        activity.setQuestion(game.getQuestion().getText())

        val answers: List<Answer> = game.getQuestion().getAnswers()
        answers.forEachIndexed {idx, answer -> activity.setAnswer(idx + 1, answer.getText())}
    }

    fun chooseAnswer(number: Int) {
        game.chooseAnswer(number)
        updateView()
    }

    private fun showEndGame() {
        if (game.isSuccess()) {
            Toast.makeText(activity, "Win", Toast.LENGTH_LONG).show()
        }

        if (game.isFail()) {
            Toast.makeText(activity, "Lost", Toast.LENGTH_LONG).show()
        }
    }
}