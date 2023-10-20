package com.example.anosmesesdias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_Ano = findViewById<EditText>(R.id.txt_Ano)
        val txt_Mes = findViewById<EditText>(R.id.txt_Mes)
        val txt_Dia = findViewById<EditText>(R.id.txt_Dia)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)
        val btn_Converter = findViewById<Button>(R.id.btn_Converter)

        btn_Converter.setOnClickListener {
            if(txt_Ano.text.isEmpty()){
                txt_Ano.error = "Digite os ano(s)"
            } else if(txt_Mes.text.isEmpty()){
                txt_Mes.error = "Digite os meses"
            }else if (txt_Dia.text.isEmpty()){
                txt_Dia.error = "Digite os dias"
            } else {
                val ano = txt_Ano.text.toString().toInt()
                val mes = txt_Mes.text.toString().toInt()
                val dia = txt_Dia.text.toString().toInt()
                val resultado : Int
                resultado = ano * 360 + mes * 30 + dia
                txt_Resultado.text = "Você já viveu $resultado dia(s) de vida!"
            }
        }
    }
}