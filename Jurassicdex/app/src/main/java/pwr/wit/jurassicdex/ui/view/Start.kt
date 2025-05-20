package pwr.wit.jurassicdex.ui.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import pwr.wit.jurassicdex.R
import pwr.wit.jurassicdex.ui.components.Footer
import pwr.wit.jurassicdex.ui.components.Header


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun Start(modifier: Modifier = Modifier, navController: NavHostController) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()){
        val configuration = LocalConfiguration.current
        Header(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) maxHeight*0.25f else maxHeight*0.15f)
                .fillMaxWidth(0.9f),
            navController,
            configuration
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(0.95f)
                .offset(y = maxHeight * 0.2f)
                .requiredHeight(height = maxHeight*0.67f)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(0.95f)
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = modifier
//                        .requiredWidth(width = 250.dp)
                        .wrapContentHeight()
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()){
                                append("Witamy w Jurassicdex!\n\n")
                            }
                            append("Poznaj fascynujący świat dinozaurów!\n")
                            append("Odkrywaj gatunki, ciekawostki i prehistoryczne fakty w naszej interaktywnej encyklopedii.\n")
                            append("Zanurz się w erę jurajską!")

                        },
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )

                }

                getGif()
            }
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
    }
}



@Composable
fun getGif() {
    val context = LocalContext.current

    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(R.drawable.logogif)
            .build(),
        contentDescription = "Animacja Logo",
        imageLoader = imageLoader,
        modifier = Modifier
            .size(250.dp)
    )
}

@Preview(widthDp = 360, heightDp = 804)
@Composable
private fun StartPreview() {
    Start(Modifier, NavHostController(LocalContext.current))
}