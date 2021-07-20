package com.example.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val cerrar= findViewById<Button>(R.id.close)
        val guardar = findViewById<Button>(R.id.guardar)
        val verdura = findViewById<EditText>(R.id.verdura)
        val cantidad = findViewById<EditText>(R.id.cantVerd)
        cerrar.setOnClickListener {
            val sigAct= Intent(this, MainActivity::class.java)
            startActivity(sigAct)
        }
        guardar.setOnClickListener {


            if (verdura.text.toString().length==0 || cantidad.text.toString().length==0 ){
                Toast.makeText(this, "llenar todos los campos ", Toast.LENGTH_SHORT).show()
            }
            else  {

                val admin= DataBase(this, "prueba", null, 1)
                val db = admin.writableDatabase
                val record = ContentValues()
                record.put("verdura", verdura.text.toString())
                record.put("cantidad", cantidad.text.toString())
                db.insert("verduras", null, record)
                db.close()
                verdura.setText("verdura")
                cantidad.setText("cantidad")
                Toast.makeText(this,"datos registrados con exito", Toast.LENGTH_SHORT).show()
                val sigAct= Intent(this, consulta::class.java)
                startActivity(sigAct)
            }


        }




    }
}