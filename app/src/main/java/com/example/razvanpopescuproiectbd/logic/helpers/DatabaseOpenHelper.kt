package com.example.razvanpopescuproiectbd.logic.helpers

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DatabaseOpenHelper : SQLiteAssetHelper {

    constructor(context: Context) : super(context, "starwars.db", null, 1)

}