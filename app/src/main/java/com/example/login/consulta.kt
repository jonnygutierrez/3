package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer


class consulta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)



        //uso de la base de datos
        val admin= DataBase(this, "prueba", null, 1)
        val db = admin.writableDatabase
        val sql : String ="select verdura, cantidad from recaudacion"

        //array donde se guardaran los datos a mostrar en la lista
        val valores= ArrayList<String>()
        



    }
}