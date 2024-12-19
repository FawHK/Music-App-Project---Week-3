package de.syntax_institut.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.syntax_institut.musicapp.components.NaviView
import de.syntax_institut.musicapp.ui.theme.MusicAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                NaviView()
//                PlayView(song = Song("Nevermore", "Lamb of God", 5.19f, "Omens"), navigateBack = {})
//                ProfileView(navController = {})
//                HomeView(songs = songs, navController = {})
//                QueryGrid(queries = searchQueries)
//                SearchView()
            }
        }
    }
}


