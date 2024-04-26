import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


fun main() = application {
    var mostrar1 by remember { mutableStateOf(true) } //Se abre esta por defecto
    var mostrar2 by remember { mutableStateOf(false) } // Y esta, está cerrada

    val windowState = rememberWindowState(size = DpSize(1200.dp, 800.dp))
    val icon = BitmapPainter(useResource("iconoPagina.png", ::loadImageBitmap))

    if (mostrar1) {
        VentanaPrincipal(icono = icon, estado = windowState,onClose = { mostrar1 = false }, onClick = { mostrar1 = false
                                                                                                        mostrar2 = true }
        )
    }

    if (mostrar2) {
        VentanaSecundaria(icono = icon, estado =  windowState, onCloseRequest = { mostrar2 = false }, onClick = {mostrar1 = true
                                                                                                                mostrar2 = false}
        )
    }

//Comprueba si estan las dos cerradas para terminar el programa
    if (!mostrar1 && !mostrar2) {
        exitApplication()
    }

}

@Composable
fun VentanaPrincipal(icono: BitmapPainter, estado: WindowState, onClose: () -> Unit, onClick: () -> Unit){

    Window(
        onCloseRequest = onClose,
        title = "Ventana principal",
        state = estado,
        icon = icono
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "Esto es lo que hay en la primera pantalla :) ")
            Spacer(modifier = Modifier.height(100.dp))
            Button(onClick = onClick )
            {
                Text("Pulsa para cambiar de ventana!")
            }
        }
    }

}

@Composable
fun VentanaSecundaria(icono: BitmapPainter, estado: WindowState, onCloseRequest: () -> Unit, onClick: () -> Unit){

    Window(
        onCloseRequest = onCloseRequest,
        title = "Ventana Secundaria",
        state = estado,
        icon = icono,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Este es el contenido de la segunda pantalla ")
            Spacer(modifier = Modifier.height(100.dp))
            Button(onClick = onClick ){
                Text("Volver a la pagina 1")
            }
        }
    }
}

