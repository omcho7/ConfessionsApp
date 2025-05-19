
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.*
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.Modifier
import com.example.confessionsapp.ui.screens.HomeFeedScreen
import com.example.confessionsapp.ui.screens.LeaderboardScreen
import com.example.confessionsapp.ui.screens.PostScreen
import com.example.confessionsapp.ui.screens.ProfileScreen
import com.example.confessionsapp.ui.screens.RouletteScreen


sealed class Screen(val route: String, val label: String, val emoji: String) {
    object Home : Screen("home", "Home", "🏠")
    object Roulette : Screen("roulette", "Roulette", "🎲")
    object Leaderboard : Screen("leaderboard", "Top", "🏆")
    object Post : Screen("post", "Post", "➕")
    object Profile : Screen("profile", "Profile", "👤")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeFeedScreen() }
        composable(Screen.Roulette.route) { RouletteScreen() }
        composable(Screen.Leaderboard.route) { LeaderboardScreen() }
        composable(Screen.Post.route) { PostScreen() }
        composable(Screen.Profile.route) { ProfileScreen() }
    }
}


@Composable
fun MainScreenWithBottomBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Roulette,
        Screen.Leaderboard,
        Screen.Post,
        Screen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Text(screen.emoji) },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(Screen.Home.route) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavigation(navController = navController)
        }
    }
}