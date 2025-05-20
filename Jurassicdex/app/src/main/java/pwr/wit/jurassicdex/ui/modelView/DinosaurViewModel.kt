package pwr.wit.jurassicdex.ui.modelView

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.ViewModel
import pwr.wit.jurassicdex.R
import pwr.wit.jurassicdex.model.DinosaurData

class DinosaurViewModel : ViewModel() {
    val dinosaurs = listOf(
        DinosaurData(
            title = "Brachiozaur",
            images = listOf(
                R.drawable.brachiozaur1,
                R.drawable.brachiozaur2,
                R.drawable.brachiozaur3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Późna jura (154–150 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 25–30 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Wysokość:")
                }
                append(" 12–16 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Waga:")
                }
                append(" 30–60 ton\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Roślinożerny (liście drzew)")
            },
            text2 = "Mimo że był jednym z największych dinozaurów, jego mózg ważył zaledwie około 300 gramów – mniej niż ludzka pięść! Co ciekawe, miał nozdrza na czubku głowy, przez co naukowcy początkowo sądzili, że żył w wodzie jak hipopotam."
        ),



        DinosaurData(
            title = "Stegozaur",
            images = listOf(
                R.drawable.stegozaur1,
                R.drawable.stegozaur2,
                R.drawable.stegozaur3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Późna jura (155–150 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 9 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Wysokość:")
                }
                append(" 4 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Waga:")
                }
                append(" 2–5 ton\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Roślinożerny")
            },
            text2 = "Płyty na jego grzbiecie nie służyły tylko do obrony – najnowsze badania sugerują, że mogły być pokryte " +
                    "żyłami krwionośnymi i pomagały w regulacji temperatury ciała. A jego kolce ogonowe? Nazywane są " +
                    "„thagomizer” – to nieoficjalna nazwa, która powstała dzięki komiksowi „The Far Side”!"
        ),



        DinosaurData(
            title = "Triceratops",
            images = listOf(
                R.drawable.triceratops1,
                R.drawable.triceratops2,
                R.drawable.triceratops3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Późna kreda (68–66 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 8–9 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Wysokość:")
                }
                append(" 3 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Waga:")
                }
                append(" 6–12 ton\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Roślinożerny")
            },
            text2 = "Miał jeden z największych rogatych łbów wśród dinozaurów, a jego kryza mogła pełnić funkcję nie tylko" +
                    "ochronną, ale też służyć do komunikacji w stadzie. Niektóre skamieniałości wskazują na zróżnicowanie " +
                    "kształtu rogów między osobnikami."
        ),



        DinosaurData(
            title = "Tyrannosaurus rex",
            images = listOf(
                R.drawable.tyrannosaurusrex1,
                R.drawable.tyrannosaurusrex2,
                R.drawable.tyrannosaurusrex3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Późna kreda (68–66 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 12–13 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Wysokość:")
                }
                append(" 4–6 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Waga:")
                }
                append(" 8–14 ton\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Mięsożerny")
            },
            text2 = "Miał najsilniejsze ugryzienie ze wszystkich znanych dinozaurów – mógł zgniatać kości z siłą ponad 5 ton " +
                    "na cm²! Ale za to jego przednie łapy były tak małe, że nie sięgały nawet do pyska. Naukowcy wciąż " +
                    "spierają się, czy był drapieżnikiem, czy raczej padlinożercą."
        ),


//Dinozaury Wodne
        DinosaurData(
            title = "Liopleurodon",
            images = listOf(
                R.drawable.liopleurodon1
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Jura (160–155 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 6–7 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Waga:")
                }
                append(" 1–5 ton\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Mięsożerny (ryby, morskie gady)")
            },
            text2 = "Ten morski potwór mógł osiągać nawet 15 metrów długości, choć niektórzy naukowcy uważają, że mógł " +
                    "być jeszcze większy. Jego zęby były tak ostre, że mógł przegryźć nawet skorupę olbrzymich morskich " +
                    "żółwi!"
        ),



        DinosaurData(
            title = "Ichtiozaur",
            images = listOf(
                R.drawable.ichtiozaur1,
                R.drawable.ichtiozaur2,
                R.drawable.ichtiozaur3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Trias–kreda (250–90 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 2–4 m (niektóre gatunki do 20 m)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Mięsożerny (ryby, kałamarnice)")
            },
            text2 = "Choć wyglądał jak delfin, był gadem – i to jednym z najszybszych w prehistorycznych oceanach. Niektóre " +
                    "gatunki rodziły żywe młode, a nie składały jaja, co rzadko zdarzało się u gadów!"
        ),



        DinosaurData(
            title = "Mozazaur",
            images = listOf(
                R.drawable.mozazaur1,
                R.drawable.mozazaur2,
                R.drawable.mozazaur3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Późna kreda (100–66 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 10–18 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Waga:")
                }
                append(" 5–20 ton\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Mięsożerny (ryby, żółwie, inne morskie gady)")
            },
            text2 = "Miał podwójne stawy w szczękach, dzięki którym mógł połykać ogromne kęsy pokarmu – niczym współczesny wąż. Co więcej, jego zęby były zakrzywione do tyłu, więc ofiara nie miała szans na ucieczkę."
        ),



        DinosaurData(
            title = "Plejozaur",
            images = listOf(
                R.drawable.plejozaur1,
                R.drawable.plejozaur2,
                R.drawable.plejozaur3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Jura–kreda (200–66 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Długość:")
                }
                append(" 3–5 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Mięsożerny (ryby, belemnity)")
            },
            text2 = "Długość jego szyi mogła stanowić nawet połowę całego ciała! Naukowcy długo zastanawiali się, jak mógł " +
                    "polować z tak nieporęczną szyją – prawdopodobnie używał jej jak wędki, by zaskakiwać ofiary szybkim " +
                    "ruchem."
        ),


//Dinozaury Latające
        DinosaurData(
            title = "Dimorphodon",
            images = listOf(
                R.drawable.dimorphodon1
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Wczesna jura (195–190 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Rozpiętość skrzydeł:")
                }
                append(" 1,5 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Mięsożerny (ryby, owady, małe gady)")
            },
            text2 = "Miał dwa rodzaje zębów – długie z przodu i krótkie z tyłu – co jest rzadkością u gadów. Prawdopodobnie " +
                    "polował na owady i małe zwierzęta, ale jego sposób latania był dość niezdarny – bardziej szybował niż " +
                    "aktywnie machał skrzydłami."
        ),



        DinosaurData(
            title = "Rhamphorhynchus",
            images = listOf(
                R.drawable.rhamphorhynchus1,
                R.drawable.rhamphorhynchus2,
                R.drawable.rhamphorhynchus3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Jura (150–148 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Rozpiętość skrzydeł:")
                }
                append(" 1,7–1,8 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Rybożerny")
            },
            text2 = "Jego ogon zakończony był romboidalną płytką, która prawdopodobnie pomagała mu stabilizować lot. Co " +
                    "ciekawe, młode osobniki miały krótsze ogony, które wydłużały się z wiekiem."
        ),



        DinosaurData(
            title = "Quetzalcoatlus",
            images = listOf(
                R.drawable.quetzalcoatlus1,
                R.drawable.quetzalcoatlus2,
                R.drawable.quetzalcoatlus3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Późna kreda (68–66 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Rozpiętość skrzydeł:")
                }
                append(" 10–12 m (największy znany pterozaur)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Wysokość:")
                }
                append(" 5–6 m (stojąc)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Mięsożerny (małe dinozaury, padlina)")
            },
            text2 = ""
        ),



        DinosaurData(
            title = "Pteranodon",
            images = listOf(
                R.drawable.pteranodon1,
                R.drawable.pteranodon2,
                R.drawable.pteranodon3
            ),
            text1 = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Okres występowania:")
                }
                append(" Późna kreda (86–84 mln lat temu)\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Rozpiętość skrzydeł:")
                }
                append(" 6–7 m\n")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("• Pożywienie:")
                }
                append(" Rybożerny")
            },
            text2 = "W przeciwieństwie do wielu innych pterozaurów, nie miał zębów – żywił się rybami, które chwytał " +
                    "w locie. Jego charakterystyczny grzebień mógł służyć do sterowania podczas lotu lub. . . imponowania " +
                    "partnerkom."
        ),





    )

    fun getDinosaurByName(title: String): DinosaurData? {
        return dinosaurs.find { it.title == title }
    }
}