package com.comics.game.ui.presenters

import android.content.Intent
import com.comics.game.MainActivity
import com.comics.game.StartActivity
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
        val intent = Intent(activity, StartActivity::class.java).apply {
            putExtra(StartActivity.RESULT_MESSAGE, game.getQuestion().getText())
        }
        activity.startActivity(intent)
    }
}