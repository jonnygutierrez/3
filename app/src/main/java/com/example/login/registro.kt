package com.example.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val correo= findViewById<EditText>(R.id.nombreUsuario)
        val pass= findViewById<EditText>(R.id.pass)
        val conPass= findViewById<EditText>(R.id.ConPass)
        val cap = findViewById<Button>(R.id.cap)

        cap.setOnClickListener {

        if (pass.text.toString().length==0 || conPass.text.toString().length==0 || correo.text.toString().length==0){
            Toast.makeText(this, "llenar todos los campos ", Toast.LENGTH_SHORT).show()
        }
       else if(pass.text.toString() == conPass.text.toString()) {

            val admin= DataBase(this, "prueba", null, 1)
            val db = admin.writableDatabase
            val record = ContentValues()
            record.put("user", correo.text.toString())
            record.put("contra", pass.text.toString())
            db.insert("usuario", null, record)
            db.close()
            correo.setText("user")
            pass.setText("")
            Toast.makeText(this,"usuario registrado con exito", Toast.LENGTH_SHORT).show()
            val sigAct= Intent(this, menu::class.java)
            startActivity(sigAct)
        }
       else{

            Toast.makeText(this,"las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }


        }











    }
}