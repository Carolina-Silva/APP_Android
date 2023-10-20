package com.example.app03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtCelsius = findViewById<EditText>(R.id.txtCelsius)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)
        val btn_Converter = findViewById<Button>(R.id.btn_Converter)

        btn_Converter.setOnClickListener {
            if (txtCelsius.text.isEmpty()) {
                txtCelsius.error = "Digite a temperatura em Celsius"
            } else {
                val celsius = txtCelsius.text.toString().toDouble()
                val resultado: Double
                resultado = (9 * celsius + 160) / 5
                txt_Resultado.text = "$celsius Graus Celsius equivale a $resultado Graus " +
                        "Fahrenheit"
                txtCelsius.text.clear()
            }
        }
    }
}