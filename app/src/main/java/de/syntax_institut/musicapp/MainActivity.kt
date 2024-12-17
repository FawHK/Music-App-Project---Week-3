package de.syntax_institut.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatLineSpacing
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import de.syntax_institut.musicapp.components.SongGrid
import de.syntax_institut.musicapp.components.SongList
import de.syntax_institut.musicapp.data.Song
import de.syntax_institut.musicapp.data.songs
import de.syntax_institut.musicapp.ui.theme.MusicAppTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                SongsListView(songs = songs)
            }
        }
    }
}

@Composable
fun SongsListView(songs: List<Song>, modifier: Modifier = Modifier) {
    var changeView by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(top = 24.dp)) {
        FloatingActionButton (
            onClick = { changeView = !changeView },
            modifier = modifier.padding(start = 30.dp),
            shape = MaterialTheme.shapes.medium,
            containerColor = Color.Red,
            contentColor = Color.White,
        ) {
            Icon(
                imageVector = if (changeView) Icons.Default.GridView else Icons.Default.FormatLineSpacing ,
                contentDescription = "Change View"
            )
        }
        if (changeView) {
            SongList(songs = songs)
        } else {
            SongGrid(songs = songs)
        }
    }
}
