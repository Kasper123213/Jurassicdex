package pwr.wit.jurassicdex.ui.components

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pwr.wit.jurassicdex.R


@Composable
fun Header(modifier: Modifier = Modifier, navController: NavHostController, configuration: Configuration) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(100.dp)
    ) {
        HamburgerMenuOverlay(navController, configuration)

        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(
                    x = 30.dp,
                    y =  -80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .requiredSize(70.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .testTag("logo_button")
                    .clickable {
                        if (navController.currentBackStackEntry?.destination?.route != "start") {
                            navController.navigate("start"){
                                launchSingleTop = true
                            }
                        }
                    }
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "JurassicDex",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp),
                    modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}



@Composable
fun HamburgerMenuOverlay(navController: NavHostController, configuration: Configuration) {
    var expanded by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp)
                .requiredSize(50.dp)
                .offset(x = 30.dp, y = -60.dp)
                .clickable { expanded = !expanded }
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.primary)
                .testTag("hamburger_menu")
        ) {
            Icon(
                imageVector = if (expanded) Icons.Default.Close else Icons.Default.Menu,
                contentDescription = "hamburger_menu",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .fillMaxSize(0.8f)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .clip(RoundedCornerShape(8.dp))
                .testTag("menu_list"),
            offset = DpOffset(x = 0.dp, y = if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) -100.dp else -60.dp)
        ) {
            DropdownMenuItem(
                text = {
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .height(30.dp)
                            .background(color = MaterialTheme.colorScheme.primary)
                            .clickable {
                                expanded = false
                                coroutineScope.launch {
                                    delay(100)
                                    if (navController.currentBackStackEntry?.destination?.route != "start") {
                                        navController.navigate("start"){
                                            launchSingleTop = true
                                        }
                                    }
                                }
                            },

                    ){
                        Text(
                            text = "Start",
                            color = Color.Black,
                        )
                    }
                },
                onClick = { expanded = false },
            )
            DropdownMenuItem(
                    text = {
                        Box (
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(8.dp))
                                .height(30.dp)
                                .background(color = MaterialTheme.colorScheme.primary)
                                .testTag("category_button")
                                .clickable {
                                    expanded = false
                                    coroutineScope.launch {
                                        delay(100)
                                        val currentCategory = navController.currentBackStackEntry
                                            ?.arguments
                                            ?.getString("cathegoryTypeName")

                                        if (currentCategory != "Kategorie") {
                                            navController.navigate("category/Kategorie"){
                                                launchSingleTop = true
                                            }
                                        }
                                    }
                                },

                            ){
                            Text(
                                text = "Kategorie",
                                color = Color.Black,
                            )
                        }
                    },
            onClick = { expanded = false },
            )
            DropdownMenuItem(
                text = {
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .height(30.dp)
                            .background(color = MaterialTheme.colorScheme.primary)
                            .testTag("quiz_button")
                            .clickable {
                                expanded = false
                                coroutineScope.launch {
                                    delay(100)
                                    if (navController.currentBackStackEntry?.destination?.route != "quiz") {
                                        navController.navigate("quiz"){
                                            launchSingleTop = true
                                        }
                                    }
                                }

                            }

                    ){
                    Text(
                        text = "Quiz",
                        color = Color.Black,
                    )
                    }
                },
                onClick = { expanded = false },
            )
            DropdownMenuItem(
                text = {
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .height(30.dp)
                            .background(color = MaterialTheme.colorScheme.primary)
                            .testTag("onas_button")
                            .clickable {
                                expanded = false
                                coroutineScope.launch {
                                    delay(100)
                                    if (navController.currentBackStackEntry?.destination?.route != "onas") {
                                        navController.navigate("onas"){
                                            launchSingleTop = true
                                        }
                                    }
                                }


                    }
                        ){
                        Text(
                            text = "O nas",
                            color = Color.Black,
                        )
                    }
                },
                onClick = { expanded = false },
            )
        }
    }
}






@Composable
fun Footer(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(height = 106.dp)
            .testTag("footer")
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondary))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 21.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .testTag("arrow_back_button")
                    .clickable {
                        if (navController.previousBackStackEntry != null) {
                            navController.popBackStack()
                        }
                    }

            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "arrow_back",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(43.dp)
                )
            }


            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .testTag("home_button")
                    .clickable {
                        if (navController.currentBackStackEntry?.destination?.route != "start") {
                            navController.navigate("start"){
                                launchSingleTop = true
                            }
                        }
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(48.dp)
                )
            }


            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .testTag("question_button")
                    .clickable {
                        if (navController.currentBackStackEntry?.destination?.route != "quiz") {
                            navController.navigate("quiz"){
                                launchSingleTop = true
                            }
                        }
                    }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.quiz_icon),
                    contentDescription = "Quiz",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(48.dp)
                )
            }
        }

    }
}

