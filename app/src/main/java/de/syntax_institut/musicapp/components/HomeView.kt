package de.syntax_institut.musicapp.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.syntax_institut.musicapp.R
import de.syntax_institut.musicapp.data.Song
import de.syntax_institut.musicapp.data.songs

@Composable
fun HomeView(navController: NavController, modifier: Modifier = Modifier) {
    var changeView by remember { mutableStateOf(false) }

    Column(
        modifier = modifier

            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.onPrimary, CircleShape)
                    .clickable { navController.navigate(ProfileView) },
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = modifier.width(250.dp))

            FloatingActionButton(
                onClick = { changeView = !changeView },
                shape = MaterialTheme.shapes.medium,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
            ) {
                Icon(
                    imageVector = if (changeView) Icons.Default.GridView else Icons.Default.FormatLineSpacing,
                    contentDescription = "Change View"
                )
            }
        }
        if (changeView) {
            SongList(songs = songs, onClick = { song: Song ->
                navController.navigate(
                    Song(song.title, song.artist, song.duration, song.album)
                )
            })
        } else {
            SongGrid(songs = songs, onClick = { song: Song ->
                navController.navigate(
                    Song(song.title, song.artist, song.duration, song.album)
                )
            }
            )
        }
    }
}