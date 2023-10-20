package com.example.listacompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtoAdapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1)
        val listViewProduto = findViewById<ListView>(R.id.list_view_produtos)
        val btnInserir = findViewById<Button>(R.id.btn_Inserir)

        val listViewProdutos =
            findViewById<ListView>(R.id.list_view_produtos)
        val txtProduto =
            findViewById<EditText>(R.id.txt_Produto)

        listViewProduto.adapter = produtoAdapter

        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if(produto.isNotEmpty()){
                produtoAdapter.add(produto)
                txtProduto.text.clear()
            } else{
                txtProduto.error = "Coloque um Produto"
            }

        }
    }
}