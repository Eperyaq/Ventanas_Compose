import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


fun main() = application {
    val windowState = rememberWindowState(size= DpSize(1200.dp, 800.dp))

    Window(
        onCloseRequest = ::exitApplication,
        title = "Mi primer ejemplo",
        state = windowState
    ) {
        MainScreen1()
    }
}

@Composable
fun MainScreen1(){
    Text(text = "Esto es lo que hay en la primera pantalla :) ")
}

@Composable
fun mipicha(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .align(Alignment.CenterHorizontally)e
    ) {

    }
}

