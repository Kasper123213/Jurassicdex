package pwr.wit.jurassicdex.ui.view

import android.content.res.Configuration
import android.media.MediaPlayer
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.annotation.RawRes
import pwr.wit.jurassicdex.ui.components.Footer
import pwr.wit.jurassicdex.ui.components.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import pwr.wit.jurassicdex.R
import pwr.wit.jurassicdex.ui.modelView.DinosaurViewModel

@Composable
fun DinosaurScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    dinozaurName: String,
    dinozaurViewModel: DinosaurViewModel = viewModel()
) {
    val dinozaur = dinozaurViewModel.getDinosaurByName(dinozaurName) ?: return
    val configuration = LocalConfiguration.current
    val listState = rememberLazyListState()

    val isVideoVisible = remember { mutableStateOf(true) }
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP) {
                isVideoVisible.value = false
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }





    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("${dinozaurName}_screen")
    ){
        var fullScreenImage by rememberSaveable { mutableStateOf<Int?>(null) }

        Header(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) maxHeight*0.25f else maxHeight*0.15f)
                .fillMaxWidth(0.9f),
            navController,
            configuration
        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .align(Alignment.TopCenter)
                .offset(y = if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)maxHeight * 0.3f else maxHeight * 0.2f)
                .requiredHeight(height = maxHeight * 0.67f)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = dinozaur.title,
                style = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            )
//            DinoGallery(images = dinozaur.images)

            Box {
                LazyRow(
                    modifier = Modifier
                        .height(200.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = (LocalConfiguration.current.screenWidthDp.dp / 2) - 100.dp),
                    state = listState,
                    flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
                ) {
                    items(dinozaur.images) { image ->
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "Dino",
                            modifier = Modifier
                                .width(200.dp)
                                .fillMaxHeight()
                                .clickable { fullScreenImage = image }
                        )
                    }
                }
            }

            if (isVideoVisible.value && dinozaur.video != null) {
                VideoPlayer(dinozaur.video)
            }



            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
            ){
                Text(
                    text = dinozaur.text1
                )
            }
            Text(
                text = dinozaur.text2,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 21.dp)
            )


            dinozaur.audio?.let { AudioPlayer(it) }
        }


        if(configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            Footer(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(
                        x = 0.dp,
                        y = maxHeight - 106.dp
                    ),
                navController
            )
        }

        // Pełnoekranowe zdjęcie po kliknięciu
        fullScreenImage?.let { image ->
            Box(
                modifier = Modifier
//                    .offset(y = maxHeight/2)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.8f))
                    .clickable { fullScreenImage = null },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Full Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                )
            }
        }
    }
}



@Composable
fun VideoPlayer(@RawRes videoResId: Int) {
    val context = LocalContext.current
    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri("android.resource://${context.packageName}/$videoResId"))
            repeatMode = Player.REPEAT_MODE_ALL
            prepare()
            play()
        }
    }

    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                this.player = player
            }

        },
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(300.dp)
            .padding(top = 10.dp)
    )

    DisposableEffect(Unit) {
        onDispose {
            player.release() // Zwolnienie zasobów
        }
    }
}




@Composable
fun AudioPlayer(
    @RawRes audioResId: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }

    // Tworzymy i przechowujemy MediaPlayer
    val mediaPlayer = remember {
        MediaPlayer.create(context, audioResId)
    }

    // Dodaj listener do zmiany stanu po zakończeniu odtwarzania
    LaunchedEffect(mediaPlayer) {
        mediaPlayer.setOnCompletionListener {
            isPlaying = false
        }
    }

    Column(modifier = modifier.padding(16.dp)) {
        Button(onClick = {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
            } else {
                mediaPlayer.start()
                isPlaying = true
            }
        }) {
            Text(if (isPlaying) "Pause" else "Play")
        }
    }

    // Zwalnianie zasobów po usunięciu komponentu
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
}


