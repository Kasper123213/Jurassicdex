package pwr.wit.jurassicdex.ui.screens

import android.content.res.Configuration
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import pwr.wit.jurassicdex.ui.components.Footer
import pwr.wit.jurassicdex.ui.components.Header
import pwr.wit.jurassicdex.ui.modelView.QuizViewModel

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: QuizViewModel = QuizViewModel()
) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val allQuestions = 5
    var correctAnswers by rememberSaveable  { mutableStateOf(0) }
    var isAnswersCorrect by rememberSaveable { mutableStateOf(true) }
    


    //mieszanie pytań
    val shuffledQuestions = rememberSaveable {
        viewModel.questions.shuffled().map { question ->
            // mieszanie odpowiedzi
            question.copy(
                answers = question.answers.shuffled()
            )
        }.take(allQuestions)
    }

    var currentQuestionIndex by rememberSaveable { mutableStateOf(0) }
    var selectedAnswerIndex by rememberSaveable { mutableStateOf<Int?>(null) }
    var showResult by rememberSaveable { mutableStateOf(false) }

    val question = shuffledQuestions.getOrNull(currentQuestionIndex)
    val configuration = LocalConfiguration.current



    BoxWithConstraints(modifier = Modifier.fillMaxSize()){
        if (question == null) {
            val background = getScoreColor(1.0f-correctAnswers.toFloat()/allQuestions)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(background),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Twój wynik: $correctAnswers/$allQuestions",
                    style = MaterialTheme.typography.headlineMedium,
                    color = getContrastingTextColor(background)
                )
            }

        }
        else {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth(0.9f)
                    .offset(y = if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)maxHeight * 0.3f else maxHeight * 0.2f)
                    .padding(24.dp)
                    .fillMaxHeight(0.67f)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(17.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pytanie ${currentQuestionIndex + 1}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = question.question,
                    fontSize = 18.sp
                )

                question.answers.forEachIndexed { index, answer ->
                    val isSelected = selectedAnswerIndex == index
                    val isCorrect = answer == question.correctAnswerIndex
                    
                    if (showResult && isSelected && !isCorrect) isAnswersCorrect = false
                    
                    val backgroundColor = when {
                        showResult && isCorrect -> Color.Green.copy(alpha = 0.3f)
                        showResult && isSelected && !isCorrect -> Color.Red.copy(alpha = 0.3f)
                        isSelected -> Color.LightGray
                        else -> Color.Transparent
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(backgroundColor)
                            .clickable(enabled = !showResult) { selectedAnswerIndex = index }
                            .padding(16.dp)
                            .shadow(5.dp)
                            .height(87.dp)
                    ) {
                        Text(
                            text = answer,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                }

                Button(
                    onClick = {
                        if (showResult) {
                            currentQuestionIndex++
                            selectedAnswerIndex = null
                            showResult = false
                            if (isAnswersCorrect) correctAnswers++
                            coroutineScope.launch {
                                scrollState.scrollTo(0)  // przewiń na górę
                            }
                            isAnswersCorrect = true

                        } else {
                            showResult = true
                        }
                    },
                    enabled = selectedAnswerIndex != null
                ) {
                    Text(if (showResult) "Następne" else "Sprawdź")
                }
            }
        }
        Header(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) maxHeight*0.25f else maxHeight*0.15f)
                .fillMaxWidth(0.9f),
            navController,
            configuration
        )
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

fun getScoreColor(value: Float): Color {
    return when {
        value <= 0.5f -> {
            // zielony → pomarańczowy
            val ratio = value / 0.5f
            Color(
                red = ratio,
                green = 1f,
                blue = 0f
            )
        }
        else -> {
            // pomarańczowy → czerwony
            val ratio = (value - 0.5f) / 0.5f
            Color(
                red = 1f,
                green = 1f - ratio,
                blue = 0f
            )
        }
    }
}

fun getContrastingTextColor(background: Color): Color {
    val luminance = background.red * 0.2126f + background.green * 0.7152f + background.blue * 0.0722f
    return if (luminance > 0.5f) Color.Black else Color.White
}


@Preview(widthDp = 360, heightDp = 804)
@Composable
private fun StartPreview() {
    QuizScreen(Modifier, NavHostController(LocalContext.current))
}