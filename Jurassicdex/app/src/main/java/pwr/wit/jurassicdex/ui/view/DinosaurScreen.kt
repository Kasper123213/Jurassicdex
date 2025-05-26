package pwr.wit.jurassicdex.ui.view

import android.content.res.Configuration
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
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




    BoxWithConstraints(modifier = Modifier.fillMaxSize()){
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
                    .background(Color.Black.copy(alpha = 0.5f))
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





