package com.comics.game.entity

import com.google.gson.annotations.SerializedName

public class Answer(
    private val answer: String,
    @SerializedName(value = "next_question_id") private val nextQuestionId: Int
) {
    fun getText(): String {
        return this.answer
    }

    fun getNextQuestionId(): Int {
        return nextQuestionId;
    }
}