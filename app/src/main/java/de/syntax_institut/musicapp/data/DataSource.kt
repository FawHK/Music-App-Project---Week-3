package de.syntax_institut.musicapp.data


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import de.syntax_institut.musicapp.components.HomeView
import de.syntax_institut.musicapp.components.SearchView




val songs = listOf(
    Song(title = "Nevermore", artist = "Lamb of God", duration = "5:19", album = "Omens"),
    Song(title = "Vanishing", artist = "Lamb of God", duration = "4:00", album = "Omens"),
    Song(title = "To the Grave", artist = "Lamb of God", duration = "3:45", album = "Omens"),
    Song(title = "Ditch", artist = "Lamb of God", duration = "4:13", album = "Omens"),
    Song(title = "Omens", artist = "Lamb of God", duration = "4:13", album = "Omens"),
    Song(title = "Gomorrah", artist = "Lamb of God", duration = "4:07", album = "Omens"),
    Song(title = "Ill Designs", artist = "Lamb of God", duration = "4:00", album = "Omens"),
    Song(title = "Grayscale", artist = "Lamb of God", duration = "4:02", album = "Omens"),
    Song(title = "Denial Mechanism", artist = "Lamb of God", duration = "2:37", album = "Omens"),
    Song(title = "September Song", artist = "Lamb of God", duration = "4:47", album = "Omens"),
)

val searchQueries = listOf(
    SearchQuery(query = "Podcasts", color = Color.Blue),
    SearchQuery(query = "Charts", color = Color.Green),
    SearchQuery(query = "New", color = Color.Gray),
    SearchQuery(query = "Genres", color = Color.Red),
    SearchQuery(query = "Playlists", color = Color.Cyan),
    SearchQuery(query = "Radio", color = Color.Magenta)
)

val navItems = listOf(
    NavItem(title = "Home", icon = Icons.Default.Home, destination = HomeView),
    NavItem(title = "Search", icon = Icons.Default.Person, destination = SearchView)
)
