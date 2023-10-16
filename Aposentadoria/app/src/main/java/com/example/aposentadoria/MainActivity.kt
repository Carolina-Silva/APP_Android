package com.example.aposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_Sexo = findViewById<Spinner>(R.id.spn_Sexo)
        val txt_Idade = findViewById<TextView>(R.id.txt_Idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)
        val txt_Erro = findViewById<TextView>(R.id.txt_Erro)

        spn_Sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino","Feminino"))

        //btn_Calcular_onclick
        btn_Calcular.setOnClickListener{
            if(txt_Idade.text.isBlank() || txt_Idade.text.isEmpty()){
                txt_Erro.text = "Idade não pode ser vazia"
            }else {
                val sexo = spn_Sexo.selectedItem as String
                val idade = txt_Idade.text.toString().toInt()
                var resultado = 0
                if (sexo == "Masculino") {
                    resultado = 65 - idade
                } else {
                    resultado = 62 - idade
                }
                txt_Resultado.text = "Faltam $resultado anos para você se aposentar"
            }
        }

    }
}