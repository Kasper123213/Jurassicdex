package pwr.wit.jurassicdex.ui.view

import android.content.res.Configuration
import pwr.wit.jurassicdex.ui.components.Footer
import pwr.wit.jurassicdex.ui.components.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    BoxWithConstraints(modifier = Modifier.fillMaxSize()){
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
            Row(
                modifier = Modifier
                    .height(200.dp)
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 32.dp, vertical = 21.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                dinozaur.images.forEach { image ->
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "logo",
                        modifier = Modifier
                            .fillMaxHeight()
                    )
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
    }
}





