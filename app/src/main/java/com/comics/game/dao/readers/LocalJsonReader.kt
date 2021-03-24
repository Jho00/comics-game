package com.comics.game.dao.readers

import android.content.Context
import java.io.IOException

public class LocalJsonReader(private val context: Context) {
    operator fun invoke(): String {
        val jsonString: String
        try {
            jsonString = context.assets.open("game.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return ""
        }
        return jsonString
    }
}