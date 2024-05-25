package com.leca.angel.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Contacto: AppCompatActivity() {
    private lateinit var nombreContacto: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        nombreContacto = intent.getStringExtra("nombreContacto") ?: ""

        findViewById<Button>(R.id.botonLlamar).setOnClickListener {
            llamar()
        }

        findViewById<Button>(R.id.botonWhatsapp).setOnClickListener {
            enviarMensajeWhatsapp()
        }

        findViewById<Button>(R.id.botonMaps).setOnClickListener {
            abrirGoogleMaps()
        }
    }

    private fun llamar() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:946086951")
        startActivity(intent)
    }

    private fun enviarMensajeWhatsapp() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=123456789&text=Hola%20$nombreContacto")
        startActivity(intent)
    }

    private fun abrirGoogleMaps() {
        val gmmIntentUri = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}