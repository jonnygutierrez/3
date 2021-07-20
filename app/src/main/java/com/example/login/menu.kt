package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        val agregar= findViewById<Button>(R.id.agregar)
        val ver= findViewById<Button>(R.id.ver)
        agregar.setOnClickListener {
            val sigAct= Intent(this, home::class.java)
            startActivity(sigAct)
        }
        ver.setOnClickListener {
            val sigAct= Intent(this, consulta::class.java)
            startActivity(sigAct)
        }

    }
}