package com.example.pmdm_tema3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm_tema3.ui.theme.Pmdmtema3Theme

@Composable
fun FilaResenya(
    nombre: String,
    comentario: String,
    valoracion: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nombre.first().toString(),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(text = nombre, fontWeight = FontWeight.Bold)
            Text(text = comentario, style = MaterialTheme.typography.bodyMedium)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary
            )
            Text(text = valoracion.toString())
        }
    }
}

@Composable
fun PantallaResenyas(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp)
        ) {
            Text("Reseñas", style = MaterialTheme.typography.headlineMedium)
            FilaResenya("Ana", "Muy buena, la uso a diario.", 4.5)
            FilaResenya("Luis", "Se queda corta de contenido.", 3.0)
            FilaResenya("Marta", "Sencilla y rápida, me encanta.", 5.0)
            FilaResenya("Pablo", "Hay algún fallo al abrirla.", 2.5)
            FilaResenya("Sara", "Cumple lo que promete.", 4.0)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PantallaResenyasPreview() {
    Pmdmtema3Theme {
        PantallaResenyas()
    }
}