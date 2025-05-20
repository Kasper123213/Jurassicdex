package pwr.wit.jurassicdex.ui.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import pwr.wit.jurassicdex.ui.components.Footer
import pwr.wit.jurassicdex.ui.components.Header
import pwr.wit.jurassicdex.ui.modelView.CategoryViewModel
import pwr.wit.jurassicdex.ui.theme.LightBrown

@Composable
fun CategotyScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    categoryName: String,
    categotyViewModel: CategoryViewModel = viewModel()
) {
    val categoryType = categotyViewModel.getCategoryByName(categoryName) ?: return
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



        Column (
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(0.7f)
                .offset(y = if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)maxHeight * 0.3f else maxHeight * 0.2f)
                .requiredHeight(height = maxHeight*0.685f - 20.dp)
                .verticalScroll(rememberScrollState())

        ){
            if (categoryType.showTitle) {
                Text(
                    text = categoryType.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            categoryType.categories.forEach { category ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                        .background(color = LightBrown)
                        .clickable { navController.navigate("${category.destination}") }

                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(0.928f)
                            .fillMaxHeight(0.75f)
                            .background(color = Color.White)
                    ) {
                        Image(
                            painter = painterResource(id = category.imageRes),
                            contentDescription = "logo",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                    Text(
                        text = category.name
                    )
                }
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





