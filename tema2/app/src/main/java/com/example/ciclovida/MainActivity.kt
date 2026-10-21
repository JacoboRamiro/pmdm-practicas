package com.example.ciclovida

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "CicloVida"
    private var contador = 0
    private lateinit var contadorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)

        contadorTextView = findViewById(R.id.contadorTextView)
        val sumarButton = findViewById<Button>(R.id.sumarButton)
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("contador")
        }
        actualizarTexto()
        sumarButton.setOnClickListener {
            contador++
            actualizarTexto()
        }
    }

    private fun actualizarTexto() {
        contadorTextView.text = getString(R.string.contador_texto, contador)
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "onStart") }
    override fun onResume() { super.onResume(); Log.d(TAG, "onResume") }
    override fun onPause() { super.onPause(); Log.d(TAG, "onPause") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop") }
    override fun onRestart() { super.onRestart(); Log.d(TAG, "onRestart") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
        Log.d(TAG, "onSaveInstanceState")
    }
}