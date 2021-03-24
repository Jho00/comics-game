package com.comics.game.dao

import android.content.Context
import com.comics.game.entity.Answer
import com.comics.game.entity.Question

public interface Store {
    fun getAllQuestions(): List<Question>

    fun getQuestionById(id: Int): Question

    fun init(context: Context): Store
}