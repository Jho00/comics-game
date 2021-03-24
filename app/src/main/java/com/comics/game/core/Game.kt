package com.comics.game.core

import android.content.Context
import android.util.Log
import com.comics.game.dao.Store
import com.comics.game.dao.StoreFactory
import com.comics.game.entity.Answer
import com.comics.game.entity.Question

class Game {
    private lateinit var store: Store
    private lateinit var question: Question

    fun init(context: Context) {
        this.store = StoreFactory.getStore(context)

        question = store.getQuestionById(1)
    }

    fun isGameEnd(): Boolean {
        return isSuccess() || isFail()
    }

    fun isSuccess(): Boolean {
        return question.isSuccess()
    }

    fun isFail(): Boolean {
        return question.isFail()
    }

    fun chooseAnswer(numberOfAnswer: Int) {
        val answer: Answer = question.getAnswers()[numberOfAnswer - 1]
        question = store.getQuestionById(answer.getNextQuestionId())
    }

    fun getQuestion(): Question {
        return question
    }
}