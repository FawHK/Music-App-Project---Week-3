package de.syntax_institut.musicapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.musicapp.R

@Composable
fun ProfileView(navController: () -> Unit, modifier: Modifier = Modifier) {
    var followersNum by rememberSaveable { mutableIntStateOf(25) }
    var isFollowClicked by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
            )
            FloatingActionButton(
                onClick = { navController() },
                modifier = modifier.padding(start = 16.dp, top = 16.dp),
                containerColor = Color.DarkGray,
                contentColor = Color.White,
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Change View",
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProfileStat(number = followersNum, label = stringResource(R.string.followers))
            ProfileStat(number = 17, label = stringResource(R.string.following))
            ProfileStat(number = 9, label = stringResource(R.string.playlists))
        }
        Button(
            onClick = {
                if (isFollowClicked) {
                    followersNum--
                    isFollowClicked = false
                } else {
                    followersNum++
                    isFollowClicked = true
                }
            },
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = if (isFollowClicked) stringResource(R.string.unfollow) else stringResource(R.string.follow),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = modifier.width(100.dp)
            )
        }
        Text(
            text = stringResource(R.string.genres),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = modifier.padding(top = 50.dp, start = 16.dp)
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GenresView(label = stringResource(R.string.rock))
            GenresView(label = stringResource(R.string.pop))
            GenresView(label = stringResource(R.string.heavy_metal))
        }
    }
}

@Composable
fun ProfileStat(number: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "$number",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun GenresView(label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .width(120.dp)
                .padding(12.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileViewPreview() {
    ProfileView(navController = {})
}