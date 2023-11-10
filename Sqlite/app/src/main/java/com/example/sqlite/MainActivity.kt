package com.example.sqlite

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        try {
//            val bd = openOrCreateDatabase("app", MODE_PRIVATE, null)
//
//            bd.execSQL("CREATE TABLE IF NOT EXISTS pessoa(nome VARCHAR, idade INT(3))")
//
//            bd.execSQL("INSERT INTO pessoa (nome,idade) VALUES ('marcos', 50)")
//            bd.execSQL("INSERT INTO pessoa (nome,idade) VALUES ('nicoly', 21)")
//            bd.execSQL("INSERT INTO pessoa (nome,idade) VALUES ('joão', 5)")
//
//            val cursor = bd.rawQuery("SELECT nome, idade FROM pessoa", null)
//
//            val indiceNome = cursor!!.getColumnIndex("nome")
//            val indiceIdade = cursor.getColumnIndex("idade")
//
//            cursor.moveToFirst()
//            while (cursor != null) {
//                Log.i("RESULTADO = NOME: " , cursor.getString(0))
//                Log.i("RESULTADO = NOME: " , cursor.getString(indiceNome))
//                Log.i("RESULTADO = IDADE: " , cursor.getString(indiceIdade))
//                cursor.moveToNext()
//            }
//
//        }catch (e: Exception) {
//            e.printStackTrace()
//        }
   }
}


