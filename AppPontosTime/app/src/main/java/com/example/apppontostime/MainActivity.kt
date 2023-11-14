package com.example.apppontostime

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var pontuacaoTimeA: Int = 0
    private var pontuacaoTimeB: Int = 0

    private lateinit var pTimeA: TextView
    private lateinit var pTimeB: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pTimeA = findViewById(R.id.placarTimeA)
        pTimeB = findViewById(R.id.placarTimeB)

        val btPontosA: Button = findViewById(R.id.pontosA)
        val btPontosB: Button = findViewById(R.id.pontosB)
        val btReiniciar: Button = findViewById(R.id.reiniciarPartida)


        btPontosA.setOnClickListener { adicionarPontos(1, "A") }

        btPontosB.setOnClickListener { adicionarPontos(1, "B") }

        btReiniciar.setOnClickListener { reiniciarPartida() }


    }

    fun adicionarPontos(pontos: Int, time: String) {
        if(time == "A"){
            pontuacaoTimeA += pontos

        }else {
            pontuacaoTimeB += pontos

        }
        atualizaPlacar(time)
    }

    fun atualizaPlacar(time: String){
        if(time == "A"){
            pTimeA.setText(pontuacaoTimeA.toString())
        }else {
            pTimeB.setText(pontuacaoTimeB.toString())
        }
    }

    fun reiniciarPartida() {
        pontuacaoTimeA = 0
        pTimeA.setText(pontuacaoTimeA.toString())
        pontuacaoTimeB = 0
        pTimeB.setText(pontuacaoTimeB.toString())
        Toast.makeText(this,"Placar reiniciado",Toast.LENGTH_SHORT).show()

    }
}