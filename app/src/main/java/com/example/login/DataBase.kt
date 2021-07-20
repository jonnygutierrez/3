package com.example.login

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase(context : Context, prueba : String, factory: SQLiteDatabase.CursorFactory?, version: Int ) :
    SQLiteOpenHelper(context, prueba , factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table usuario (cve_usuario integer PRIMARY KEY AUTOINCREMENT, user text, contra text);" +
                "create table recaudacion (cve_recaudacion integer PRIMARY KEY AUTOINCREMENT,verdura text, cantidad integer, fecha text,);")
    }
//    companion object{
 //   private val DATABASE_NAME = "prueba.db"
   // private bal DATABASE_VERSION =1
    // val CUSTOMER_TABLE_NAME="recaudacion"
    // val column_customer_id = "customerid"
    // val column_customer_name = "customername"
    // val column_maxcredit = "maxcredit"
    // }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("Drop table if exists usuario ")
    }


}