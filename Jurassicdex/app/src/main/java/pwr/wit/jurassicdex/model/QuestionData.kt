package pwr.wit.jurassicdex.model

data class QuestionData(
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: String
)
