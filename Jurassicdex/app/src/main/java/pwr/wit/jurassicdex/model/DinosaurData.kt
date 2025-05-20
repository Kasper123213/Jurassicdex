package pwr.wit.jurassicdex.model

import androidx.compose.ui.text.AnnotatedString

data class DinosaurData(
    val title: String,
    val images: List<Int>,
    val text1: AnnotatedString,
    val text2: String
)
