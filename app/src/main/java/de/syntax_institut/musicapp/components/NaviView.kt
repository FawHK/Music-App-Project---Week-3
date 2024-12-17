package de.syntax_institut.musicapp.components


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object HomeView

@Serializable
object ProfileView

@Composable
fun NaviView() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeView
    ) {
        composable<HomeView> {
            HomeView(navController = {
                navController.navigate(ProfileView)
            })
        }

        composable<ProfileView> {
            ProfileView(navController = {
                navController.popBackStack()
            })
        }
    }
}
