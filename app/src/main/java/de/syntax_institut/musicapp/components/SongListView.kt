package de.syntax_institut.musicapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.musicapp.data.Song
import de.syntax_institut.musicapp.data.songs

@Composable
fun SongCard(song: Song, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color.LightGray
        ),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier
                    .weight(1f)) {
                Text(
                    text = song.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Artist: ${song.artist}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Album: ${song.album}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Text(
                text = "${song.duration} min",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}


@Composable
fun SongList(songs: List<Song>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(top = 24.dp)
    ) {
        items(songs) { song ->
            SongCard(song = song)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SongListPreview() {
    SongList(songs = songs)
}

