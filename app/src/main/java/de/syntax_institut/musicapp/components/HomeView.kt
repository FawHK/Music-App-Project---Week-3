package de.syntax_institut.musicapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatLineSpacing
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
//            modifier = modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FloatingActionButton(
                onClick = { changeView = !changeView },
                shape = MaterialTheme.shapes.medium,
                containerColor = Color.Red,
                contentColor = Color.White,
            ) {
                Icon(
                    imageVector = if (changeView) Icons.Default.GridView else Icons.Default.FormatLineSpacing,
                    contentDescription = "Change View"
                )
            }
            FloatingActionButton(
                onClick = { navController.navigate(ProfileView) },
                shape = MaterialTheme.shapes.medium,
                containerColor = Color.DarkGray,
                contentColor = Color.White,
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Change View"
                )
            }
        }
        if (changeView) {
            SongList(songs = songs)
        } else {
            SongGrid(songs = songs)
        }
    }
}