package com.example.razvanpopescuproiectbd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.razvanpopescuproiectbd.logic.services.DatabaseAccessService
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class MainActivity : AppCompatActivity() {

//    private val url = "jdbc:mysql://lefti.cm.upt.ro/lefti_popescurazvan"
//    private val user = "popescurazvan"
//    private val pass = "2b0v561o"

    var list: MutableList<String> = ArrayList()
    var databaseAccessService: DatabaseAccessService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        databaseAccessService = DatabaseAccessService().getInstance(this.applicationContext)
        databaseAccessService!!.open()
        list = databaseAccessService!!.getStarshipPassengers("") as MutableList<String>
        for(string: String in list) {
            display.text = display.text.toString() + string
        }
        databaseAccessService!!.close()

//        val con: Connection = DriverManager.getConnection(url, user, pass)
//        val st: Statement = con.createStatement()
//        val rs: ResultSet = st.executeQuery("USE starwars;
//                                                 CALL insertStarship("DeathStar2.0", "Luke skywalker", "100000")
    }
}