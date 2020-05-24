package com.example.razvanpopescuproiectbd.logic.services

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.razvanpopescuproiectbd.logic.helpers.DatabaseOpenHelper

class DatabaseAccessService {

    private var openHelper: SQLiteOpenHelper? = null
    private var database: SQLiteDatabase? = null
    private var instance: DatabaseAccessService? = null

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private fun DatabaseAccessService(context: Context): DatabaseAccessService? {
        openHelper = DatabaseOpenHelper(context)
        return this
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    fun getInstance(context: Context): DatabaseAccessService {
        if (instance == null) {
            instance = DatabaseAccessService(context)
        }
        return instance as DatabaseAccessService
    }

    /**
     * Open the database connection.
     */
    fun open() {
        database = openHelper!!.writableDatabase
    }

    /**
     * Close the database connection.
     */
    fun close() {
        database?.close()
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    fun getStarshipPassengers(name: String): List<String>? {
        val list: MutableList<String> = ArrayList()
        val cursor: Cursor = database!!.rawQuery("SELECT people_name, sum(starship_passengers) as passengers FROM people p JOIN people_starships ps ON(p.peopleID = ps.peopleID) JOIN starship s ON(ps.starshipID = s.starshipID) WHERE people_name LIKE '%$name%' GROUP BY people_name LIMIT 16", null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            for(i in 0..cursor.columnCount-1) {
                list.add(cursor.getColumnName(i))
                list.add(" ")
                list.add(cursor.getString(i))
                list.add("\n")
            }
            cursor.moveToNext()
        }
        cursor.close()
        return list
    }
}