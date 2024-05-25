package com.leca.angel.usolayoutsv4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class Ejercicio01 : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var buttonMostrar: Button
    private lateinit var buttonOcultar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        buttonMostrar = findViewById(R.id.button_mostrar)
        buttonOcultar = findViewById(R.id.button_ocultar)

        buttonMostrar.setOnClickListener {
            mostrarImageView()
        }

        buttonOcultar.setOnClickListener {
            ocultarImageView()
        }
    }

    private fun mostrarImageView() {
        imageView.visibility = View.VISIBLE
    }

    private fun ocultarImageView() {
        imageView.visibility = View.GONE
    }
}