package ph.edu.comteq.talua_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

val playfairdisplayregular = FontFamily(Font(R.font.playfairdisplayregular, FontWeight.Normal))

val optima = FontFamily(Font(R.font.optima, FontWeight.Normal))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MuseumApp()
        }
    }
}

@Composable
fun MuseumApp() {
    var selectedScreen by remember { mutableStateOf("home") }

    when (selectedScreen) {
        "home" -> HomeScreen(onExploreClick = { selectedScreen = "explore" })
        "explore" -> ExploreScreen(
            onBackClick = { selectedScreen = "home" },
            onTicketingClick = { selectedScreen = "ticketing" }
        )
        "ticketing" -> TicketingServiceScreen(onBackClick = { selectedScreen = "explore" })
    }
}
