package com.example.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //declaracion de variables
        val usuario= findViewById<EditText>(R.id.usuario)
        val pwd = findViewById<EditText>(R.id.contra)
        val reg = findViewById<Button>(R.id.registro)
        val log = findViewById<Button>(R.id.acceder)

        // agregar usuario (lo manda a otra la actividad que contiene el formulario de registro)
        reg.setOnClickListener {
            //prueba para ver si sirve el menu
            val sigAct= Intent(this, menu::class.java)
            startActivity(sigAct)


        }

        log.setOnClickListener {
            val admin = DataBase(this, "prueba", null, 1)
            val db= admin.writableDatabase
            if (db == null){
                Toast.makeText(this, "sin conexion a la base de datos", Toast.LENGTH_SHORT).show()
                }else{
                  val sql : String = "select user, contra from usuario where user= '${usuario.text.toString()}'and contra ='${pwd.text.toString()}'  "

                    val row = db.rawQuery(sql, null)
                    if (row.moveToFirst()){
                        val pass = row.getString(row.getColumnIndex("contra"))

                        if (pass == pwd.text.toString()){

                            Toast.makeText(this, "BIENVENIDO", Toast.LENGTH_SHORT).show()
                            val home = Intent(this, menu::class.java)
                            startActivity(home)
                        }
                        else {
                            Toast.makeText(this, "usuario no encontrado", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
        }








    }
}