package de.syntax_institut.musicapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import de.syntax_institut.musicapp.data.Song
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import de.syntax_institut.musicapp.R
import de.syntax_institut.musicapp.data.songs


@Composable
fun SongView(song: Song, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.omens),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Text(
            text = stringResource(R.string.artist, song.artist),
            fontSize = 14.sp,
            fontWeight = MaterialTheme.typography.titleSmall.fontWeight,
            modifier = Modifier
            .padding(top = 8.dp))

        Text(
            text = stringResource(R.string.song, song.title),
            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun SongGrid(songs: List<Song>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    ) {
        items(songs) { song ->
            SongView(song = song)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SongGridPreview() {
    SongGrid(songs = songs)
}