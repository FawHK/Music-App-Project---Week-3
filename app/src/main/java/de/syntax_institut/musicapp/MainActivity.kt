package de.syntax_institut.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.musicapp.components.NaviView
import de.syntax_institut.musicapp.ui.theme.MusicAppTheme
import de.syntax_institut.musicapp.components.SearchView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                NaviView()
//                ProfileView(navController = {})
//                HomeView(songs = songs, navController = {})
//                QueryGrid(queries = searchQueries)
//                SearchView()
            }
        }
    }
}


