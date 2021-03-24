package com.comics.game.entity

import android.util.Log

class Question(
    private val id: Int,
    private val type: String,
    private val question: String,
    private val answers: List<Answer>) {

    /**
     * Всегда возвращаем 4 варианта ответа, потому что на экране 4 ячейки.
     * Если ответов меньше - добиваем пустыми, на слое ui их просто не будут показывать
     */
    fun getAnswers(): List<Answer> {
        val list: MutableList<Answer> = ArrayList(this.answers)
        val shouldAdd: Int = 4 - list.size

        for (i in 1..shouldAdd) {
            list.add(Answer("", -1))
        }

        return list
    }

    fun getText(): String {
        return question
    }

    fun getId(): Int {
        return id
    }

    fun isSuccess(): Boolean {
        return QuestionType.Success.type == type
    }

    fun isFail(): Boolean {
        return QuestionType.Fail.type == type
    }
}