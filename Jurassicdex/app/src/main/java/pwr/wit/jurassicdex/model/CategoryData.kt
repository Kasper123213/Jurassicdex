package pwr.wit.jurassicdex.model

data class CategoryData(
    val name: String,
    val imageRes: Int,
    val destination: String
)


data class CategoriesData(
    val name: String,
    val categories: List<CategoryData>,
    val showTitle: Boolean = false
)