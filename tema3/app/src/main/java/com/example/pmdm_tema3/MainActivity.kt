package com.example.pmdm_tema3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pmdm_tema3.ui.theme.Pmdmtema3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pmdmtema3Theme {
                PantallaListadoInstall()
            }
        }
    }
}