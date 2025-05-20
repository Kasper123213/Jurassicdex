package pwr.wit.jurassicdex.ui.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.requiredWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pwr.wit.jurassicdex.R
import pwr.wit.jurassicdex.ui.components.Footer
import pwr.wit.jurassicdex.ui.components.Header


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun OnasScreen(modifier: Modifier = Modifier, navController: NavHostController) {
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
        Row(
//            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
//            verticalAlignment = Alignment.CenterVertically,
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
//                        .requiredWidth(width = 276.dp)
                        .wrapContentHeight()
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()) {
                                append("Cześć! ")
                            }
                            append(
                                "Miło Cię widzieć w Jurassicdex – naszej mobilnej encyklopedii dinozaurów. " +
                                        "To aplikacja, którą stworzyliśmy z pasji do technologii, nauki i – oczywiście – prehistorycznych gadów. " +
                                        "\n\n" +
                                        "Jesteśmy studentami informatyki stosowanej na Politechnice Wrocławskiej:" +
                                        "\n\n"
                            )

                            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()) {
                                append("• Łukasz Welka ")
                            }
                            append(
                                "– wcześniej studiował matematykę, obecnie rozwija się w kierunku informatyki. Interesuje się logiką, algorytmiką i nowoczesnymi technologiami, które pomagają łączyć naukę z codziennością" +
                                        "\n"
                            )

                            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()) {
                                append("• Kasper Radom ")
                            }
                            append(
                                " – absolwent informatyki technicznej, obecnie student na informatyce stosowanej. Lubi tworzyć aplikacje, które są nie tylko funkcjonalne, ale też przyjazne i intuicyjne w obsłudze" +
                                        "\n\n" +
                                        "Jurassicdex powstał w ramach kursu Systemy mobilne i multimedia jako projekt zaliczeniowy, ale traktujemy go jak coś znacznie więcej niż tylko akademickie zadanie. " +
                                        "Chcieliśmy stworzyć coś, co będzie przystępne, ciekawe i inspirujące – zarówno dla dzieciaków zafascynowanych dinozaurami, jak i dla starszych użytkowników, którzy po prostu chcą dowiedzieć się czegoś nowego. " +
                                        "\n" +
                                        "Mamy nadzieję, że nasza aplikacja przypadnie Ci do gustu i pozwoli odkrywać świat dinozaurów w nowoczesny sposób" +
                                        "\n\n"
                            )

                            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()) {
                                append("Dziękujemy, że tu jesteś!")
                            }
                        },
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }
                Image(
                    painter = painterResource(id = R.drawable.onas),
                    contentDescription = "sylwetka Tworcow",
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                )
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





@Preview(widthDp = 360, heightDp = 804)
@Composable
private fun OnasScreenPreview() {
    OnasScreen(Modifier, NavHostController(LocalContext.current))
}