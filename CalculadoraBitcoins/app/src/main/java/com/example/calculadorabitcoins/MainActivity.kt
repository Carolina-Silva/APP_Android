package com.example.calculadorabitcoins


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL
import java.text.NumberFormat
import java.util.Locale


class MainActivity : AppCompatActivity() {
    val API_URL = "https://www.mercadobitcoin.net/api/BTC/ticker/"

    lateinit var txtValor: EditText
    lateinit var btnCalcular: Button
    lateinit var txtQtdBitcoins: TextView

    var cotacaoBitcoin: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa as views após o setContentView
        txtValor = findViewById(R.id.txtValor)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtQtdBitcoins = findViewById(R.id.txtQtdBitcoins)

        buscarCotacao()

        btnCalcular.setOnClickListener {
            calcular()
        }
    }


    fun buscarCotacao() {
        GlobalScope.async(Dispatchers.Default) {
            //Acessar a API e buscar seu resultado
            val resposta = URL(API_URL).readText()
            cotacaoBitcoin = JSONObject(resposta).getJSONObject("ticker").getDouble("last")
            //formatacao da moeda
            val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val cotacaoFormatada = f.format(cotacaoBitcoin)

            var txtCotacao = findViewById<TextView>(R.id.txtCotacao)
            txtCotacao.setText("$cotacaoFormatada")

            withContext(Main){

            }
        }

    }

    fun calcular() {
        if (txtValor.text.isEmpty()) {
            txtValor.error = "Preencha um valor"
            return
        }
        //valor digitado pelo usuário
        val valorDigitado = txtValor.text.toString()
            .replace(",", ".").toDouble()
        //caso não vem valor da API
        val resultado = if (cotacaoBitcoin > 0) valorDigitado / cotacaoBitcoin
        else 0.0
        //atualizando o TextView com o resultado formatado com 8 casas decimais
        txtQtdBitcoins.text = "%.8f".format(resultado)
    }

}