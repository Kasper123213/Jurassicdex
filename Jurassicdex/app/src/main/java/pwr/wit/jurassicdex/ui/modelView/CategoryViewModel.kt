package pwr.wit.jurassicdex.ui.modelView

import androidx.lifecycle.ViewModel
import pwr.wit.jurassicdex.R
import pwr.wit.jurassicdex.model.CategoriesData
import pwr.wit.jurassicdex.model.CategoryData

class CategoryViewModel : ViewModel() {
    val categories = listOf(
        CategoriesData(
            name = "Kategorie",
            categories = listOf(
                CategoryData(
                    name = "Dinozaury Lądowe",
                    imageRes = R.drawable.stegozaur1,
                    destination = "category/Dinozaury Lądowe"
                ),
                CategoryData(
                    name = "Dinozaury Wodne",
                    imageRes =R.drawable.plejozaur1,
                    destination = "category/Dinozaury Wodne"
                ),
                CategoryData(
                    name = "Dinozaury Latające",
                    imageRes = R.drawable.pteranodon3,
                    destination = "category/Dinozaury Latające"
                ),
            )
        ),
        CategoriesData(
            name = "Dinozaury Lądowe",
            categories = listOf(
                CategoryData(
                    name = "Brachiozaur",
                    imageRes = R.drawable.brachiozaur1,
                    destination = "dinosaur/Brachiozaur"
                ),
                CategoryData(
                    name = "Stegozaur",
                    imageRes =R.drawable.stegozaur1,
                    destination = "dinosaur/Stegozaur"
                ),
                CategoryData(
                    name = "Triceratops",
                    imageRes = R.drawable.triceratops1,
                    destination = "dinosaur/Triceratops"
                ),
                CategoryData(
                    name = "Tyrannosaurus rex",
                    imageRes = R.drawable.tyrannosaurusrex1,
                    destination = "dinosaur/Tyrannosaurus rex"
                ),
            ),
            showTitle = true
        ),
        CategoriesData(
            name = "Dinozaury Wodne",
            categories = listOf(
                CategoryData(
                    name = "Liopleurodon",
                    imageRes = R.drawable.liopleurodon1,
                    destination = "dinosaur/Liopleurodon"
                ),
                CategoryData(
                    name = "Ichtiozaur",
                    imageRes =R.drawable.ichtiozaur1,
                    destination = "dinosaur/Ichtiozaur"
                ),
                CategoryData(
                    name = "Mozazaur",
                    imageRes = R.drawable.mozazaur1,
                    destination = "dinosaur/Mozazaur"
                ),
                CategoryData(
                    name = "Plejozaur",
                    imageRes = R.drawable.plejozaur1,
                    destination = "dinosaur/Plejozaur"
                ),
            ),
            showTitle = true
        ),
        CategoriesData(
            name = "Dinozaury Latające",
            categories = listOf(
                CategoryData(
                    name = "Dimorphodon",
                    imageRes = R.drawable.dimorphodon1,
                    destination = "dinosaur/Dimorphodon"
                ),
                CategoryData(
                    name = "Rhamphorhynchus",
                    imageRes =R.drawable.rhamphorhynchus1,
                    destination = "dinosaur/Rhamphorhynchus"
                ),
                CategoryData(
                    name = "Quetzalcoatlus",
                    imageRes = R.drawable.quetzalcoatlus1,
                    destination = "dinosaur/Quetzalcoatlus"
                ),
                CategoryData(
                    name = "Pteranodon",
                    imageRes = R.drawable.pteranodon1,
                    destination = "dinosaur/Pteranodon"
                ),
            ),
            showTitle = true
        )
    )

    fun getCategoryByName(name: String): CategoriesData? {
        return categories.find { it.name == name }
    }
}