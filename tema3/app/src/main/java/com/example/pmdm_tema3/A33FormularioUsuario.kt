package com.example.pmdm_tema3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm_tema3.ui.theme.Pmdmtema3Theme

@Composable
fun PantallaNuevoUsuario(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var recibirAvisos by remember { mutableStateOf(false) }
    val roles = listOf("Jugador", "Moderador", "Administrador")
    var rol by remember { mutableStateOf(roles[0]) }

    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Nuevo usuario", style = MaterialTheme.typography.headlineMedium)

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Recibir notificaciones")
                Switch(checked = recibirAvisos, onCheckedChange = { recibirAvisos = it })
            }

            Text("Tipo de cuenta", style = MaterialTheme.typography.titleMedium)
            roles.forEach { opcion ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = rol == opcion, onClick = { rol = opcion })
                    Text(opcion)
                }
            }

            Button(
                onClick = { /* no hace nada todavía */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar")
            }
            TextButton(
                onClick = { /* no hace nada todavía */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaNuevoUsuarioPreview() {
    Pmdmtema3Theme {
        PantallaNuevoUsuario()
    }
}
