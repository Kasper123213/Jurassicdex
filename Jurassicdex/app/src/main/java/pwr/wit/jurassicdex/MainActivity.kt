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
import androidx.compose.animation.core.tween
import androidx.compose.ui.Alignment

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
    AnimatedNavHost(navController = navController, startDestination = "start") {
        composable(
            route = "start",
            enterTransition = { scaleIn(
                animationSpec = tween(500),
                initialScale = 0.8f
                ) + fadeIn(tween(500))
            },
            exitTransition = { scaleOut(
                animationSpec = tween(400),
                targetScale = 0.8f
                ) + fadeOut(tween(400))
            }
        ) {
            Start(navController=navController)
        }
        composable(
            route = "category/{cathegoryTypeName}",
            enterTransition = { fadeIn(animationSpec = tween(500)) + slideInHorizontally { it } },
            exitTransition = { fadeOut(animationSpec = tween(300)) + slideOutHorizontally { -it } }
            ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("cathegoryTypeName") ?: ""
            CategotyScreen(navController=navController, categoryName = name)
        }
        composable(
            route = "dinosaur/{dinozaurName}",
            enterTransition = { slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
                ) + fadeIn(tween(300))
            },
            exitTransition = { slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300)
                ) + fadeOut(tween(300))
            }
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("dinozaurName") ?: ""
            DinosaurScreen(navController=navController, dinozaurName = name)
        }
        composable(
            route = "onas",
            enterTransition = { expandIn(
                animationSpec = tween(500),
                expandFrom = Alignment.Center
                ) + fadeIn(tween(500))
            },
            exitTransition = {
                shrinkOut(
                    animationSpec = tween(400),
                    shrinkTowards = Alignment.Center
                ) + fadeOut(tween(400))
            }
        ) {
            OnasScreen(navController=navController)
        }
        composable(
            route = "quiz",
            enterTransition = {
                scaleIn(
                    initialScale = 0.8f,
                    animationSpec = tween(400)
                ) + fadeIn(animationSpec = tween(400))
            },
            exitTransition = {
                scaleOut(
                    targetScale = 1.2f, // z normalnego na większy i znika
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
            }
        ) {
            QuizScreen(navController=navController)
        }
    }
}
