package de.syntax_institut.musicapp.data

import kotlinx.serialization.Serializable

@Serializable
data class Song(
    var title: String,
    var artist: String,
    var duration: String,
    var album: String
)