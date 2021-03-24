package com.comics.game.dao

import android.content.Context
import com.comics.game.dao.impl.LocalStore

class StoreFactory {
    companion object {
        fun getStore(ctx: Context): Store {
            return LocalStore().init(ctx)
        }
    }
}