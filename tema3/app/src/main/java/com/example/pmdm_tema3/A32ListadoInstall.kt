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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm_tema3.ui.theme.Pmdmtema3Theme

@Composable
fun FilaListadoInstall(
    nombre: String,
    categoria: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(text = nombre, style = MaterialTheme.typography.titleMedium)
            Text(
                text = categoria,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Button(onClick = { /* sin acción por ahora */ }) {
            Text("Install")
        }
    }
}

@Composable
fun PantallaListadoInstall(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.statusBarsPadding()) {
            items(30) { indice ->
                FilaListadoInstall(
                    nombre = "Juego ${indice + 1}",
                    categoria = "Acción · 4.${indice % 10}"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaListadoInstallPreview() {
    Pmdmtema3Theme {
        PantallaListadoInstall()
    }
}
