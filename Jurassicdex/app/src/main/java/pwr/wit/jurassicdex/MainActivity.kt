package pwr.wit.jurassicdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pwr.wit.jurassicdex.ui.screens.QuizScreen
import pwr.wit.jurassicdex.ui.theme.JurassicdexTheme
import pwr.wit.jurassicdex.ui.view.CategotyScreen
import pwr.wit.jurassicdex.ui.view.DinosaurScreen
import pwr.wit.jurassicdex.ui.view.OnasScreen
import pwr.wit.jurassicdex.ui.view.Start
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import androidx.compose.animation.*
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.Alignment
import androidx.navigation.NavBackStackEntry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Ukrycie paska dolnego i górnego
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.systemBars()) // chowa paski
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE // pokazuje po swipe

        setContent {
            JurassicdexTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(navController: NavHostController) {
    val customEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
        slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth * 2 },
            animationSpec = tween(durationMillis = 400, easing = EaseOut)
        ) + fadeIn(
            animationSpec = tween(durationMillis = 300, delayMillis = 10)
        )
    }

    AnimatedNavHost(navController = navController, startDestination = "start") {
        composable(
            route = "start",
            enterTransition = customEnterTransition

        ) {
            Start(navController=navController)
        }
        composable(
            route = "category/{cathegoryTypeName}",
            enterTransition = customEnterTransition

            ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("cathegoryTypeName") ?: ""
            CategotyScreen(navController=navController, categoryName = name)
        }
        composable(
            route = "dinosaur/{dinozaurName}",
            enterTransition = customEnterTransition

        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("dinozaurName") ?: ""
            DinosaurScreen(navController=navController, dinozaurName = name)
        }
        composable(
            route = "onas",
            enterTransition = customEnterTransition

        ) {
            OnasScreen(navController=navController)
        }
        composable(
            route = "quiz",
            enterTransition = customEnterTransition

        ) {
            QuizScreen(navController=navController)
        }
    }
}



