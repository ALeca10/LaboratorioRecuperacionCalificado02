package com.leca.angel.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class Registro : AppCompatActivity() {
    private lateinit var nombresLayout: TextInputLayout
    private lateinit var apellidosLayout: TextInputLayout
    private lateinit var numeroCelularLayout: TextInputLayout
    private lateinit var direccionLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nombresLayout = findViewById(R.id.nombresLayout)
        apellidosLayout = findViewById(R.id.apellidosLayout)
        numeroCelularLayout = findViewById(R.id.numeroCelularLayout)
        direccionLayout = findViewById(R.id.direccionLayout)

        val buttonRegistrar: Button = findViewById(R.id.button2)
        buttonRegistrar.setOnClickListener {
            if (validarInputs()) {
                irAContactoActivity()
            }
        }
    }

    private fun validarInputs(): Boolean {
        val nombres = nombresLayout.editText?.text.toString().trim()
        val apellidos = apellidosLayout.editText?.text.toString().trim()
        val numeroCelular = numeroCelularLayout.editText?.text.toString().trim()
        val direccion = direccionLayout.editText?.text.toString().trim()

        if (TextUtils.isEmpty(nombres)) {
            nombresLayout.error = "Por favor ingrese los nombres"
            return false
        } else {
            nombresLayout.error = null
        }

        if (TextUtils.isEmpty(apellidos)) {
            apellidosLayout.error = "Por favor ingrese los apellidos"
            return false
        } else {
            apellidosLayout.error = null
        }

        if (TextUtils.isEmpty(numeroCelular)) {
            numeroCelularLayout.error = "Por favor ingrese el número celular"
            return false
        } else {
            numeroCelularLayout.error = null
        }

        if (TextUtils.isEmpty(direccion)) {
            direccionLayout.error = "Por favor ingrese la dirección"
            return false
        } else {
            direccionLayout.error = null
        }

        return true
    }

    private fun irAContactoActivity() {
        val intent = Intent(this, Contacto::class.java).apply {
            putExtra("nombres", nombresLayout.editText?.text.toString().trim())
            putExtra("apellidos", apellidosLayout.editText?.text.toString().trim())
            putExtra("numeroCelular", numeroCelularLayout.editText?.text.toString().trim())
            putExtra("direccion", direccionLayout.editText?.text.toString().trim())
        }
        startActivity(intent)
    }
}

