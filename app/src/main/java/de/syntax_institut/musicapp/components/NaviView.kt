package de.syntax_institut.musicapp.components


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import de.syntax_institut.musicapp.data.Song
import de.syntax_institut.musicapp.data.navItems
import kotlinx.serialization.Serializable

@Serializable
object HomeView

@Serializable
object ProfileView

@Serializable
object SearchView

@Composable
fun NaviView(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeView,
            modifier = modifier.padding(innerPadding)
        ) {
            composable<HomeView> {
                HomeView(navController = navController)
            }

            composable<ProfileView> {
                ProfileView(navController = {
                    navController.popBackStack()
                })
            }

            composable<SearchView> {
                SearchView()
            }

            composable<Song> {
                val song = it.toRoute<Song>()
                PlayView(song) {
                    navController.navigateUp()
                }
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.Black,
        tonalElevation = 20.dp
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = backStackEntry?.destination

        navItems.forEachIndexed { _, navItem ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(navItem.destination::class) } == true,
                onClick = {
                    navController.navigate(navItem.destination) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    disabledIconColor = Color.White,
                    disabledTextColor = Color.White,
                )
            )
        }
    }
}
