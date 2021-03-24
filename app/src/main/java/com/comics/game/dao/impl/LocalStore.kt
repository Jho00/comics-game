package com.comics.game.dao.impl

import android.content.Context
import android.util.Log
import com.comics.game.core.exceiptions.QuestionNotFoundException
import com.comics.game.dao.readers.LocalJsonReader
import com.comics.game.dao.Store
import com.comics.game.entity.Question
import com.google.gson.Gson

class LocalStore : Store {
    private var questions: List<Question> = ArrayList()

    private val gson = Gson();

    override fun getAllQuestions(): List<Question> {
        return questions
    }

    override fun getQuestionById(id: Int): Question {
        val question = questions.find { question -> question.getId() == id }
        if (question != null) {
            return question
        }
        throw QuestionNotFoundException("Question not found")
    }

    override fun init(context: Context): Store {
        val jsonString = LocalJsonReader(context)()

        val mappedQuestions: Array<Question> = gson.fromJson(jsonString, Array<Question>::class.java)
        questions = mappedQuestions.toList()

        return this
    }
}