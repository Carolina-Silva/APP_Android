package com.example.blocoanotacao

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.example.blocodenotas.AnotacaoPreferencias
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var preferencias: AnotacaoPreferencias? = null
    private var editAnotacao: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editAnotacao = findViewById<EditText>(R.id.blocoAnotacao)
        var preferencias = AnotacaoPreferencias(applicationContext)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            val textoRecuperado = editAnotacao.getText().toString()
            if (textoRecuperado == "") {
                Snackbar.make(view, "Digite uma anotação para ser salva",
                    Snackbar.LENGTH_LONG)
                    .show()
            } else {
                preferencias!!.salvarAnotacao(textoRecuperado)
                Snackbar.make(view, "Anotação salva com sucesso",
                    Snackbar.LENGTH_LONG)
                    .show()
            }
        }

        //recuperar a anotacao salva
        val anotacao = preferencias!!.recuperarAnotacao()
        if (anotacao != "") {
            editAnotacao.setText(anotacao)
        }
    }
}