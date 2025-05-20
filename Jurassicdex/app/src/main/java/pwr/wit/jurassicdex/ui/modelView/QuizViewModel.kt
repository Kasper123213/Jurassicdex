package pwr.wit.jurassicdex.ui.modelView

import pwr.wit.jurassicdex.model.QuestionData

class QuizViewModel {
    val questions = listOf(
        QuestionData(
            question = "Który dinozaur miał kryzę mogącą służyć do komunikacji w stadzie?",
            answers = listOf("Triceratops", "Stegozaur", "Brachiozaur", "Tyranozaur", "Ichtiozaur", "Quetzalcoatlus", "Pteranodon"),
            correctAnswerIndex = "Triceratops"
        ),

        QuestionData(
            question = "Który dinozaur miał najsilniejsze ugryzienie?",
            answers = listOf("Tyrannosaurus rex", "Stegozaur", "Triceratops", "Liopleurodon", "Mozazaur", "Dimorphodon", "Plejozaur"),
            correctAnswerIndex = "Tyrannosaurus rex"
        ),

        QuestionData(
            question = "Jak wyglądał ichtiozaur?",
            answers = listOf("Jak delfin", "Jak krokodyl", "Jak wąż", "Jak żółw", "Jak lew morski", "Jak orka", "Jak rekin młot"),
            correctAnswerIndex = "Jak delfin"
        ),

        QuestionData(
            question = "Który dinozaur morski miał podwójne stawy w szczękach?",
            answers = listOf("Mozazaur", "Plejozaur", "Liopleurodon", "Ichtiozaur", "Dimorphodon", "Pteranodon", "Stegozaur"),
            correctAnswerIndex = "Mozazaur"
        ),

        QuestionData(
            question = "Jaką rozpiętość skrzydeł miał Quetzalcoatlus?",
            answers = listOf("10–12 m", "1,5 m", "6–7 m", "2–4 m", "1,7–1,8 m", "5–6 m", "15 m"),
            correctAnswerIndex = "10–12 m"
        ),

        QuestionData(
            question = "Co wyróżniało zęby Dimorphodona?",
            answers = listOf("Miał dwa rodzaje zębów", "Były zakrzywione do tyłu", "Nie miał zębów", "Były tępe", "Były bardzo długie", "Były ostre jak igły", "Były tylko na dole"),
            correctAnswerIndex = "Miał dwa rodzaje zębów"
        ),

        QuestionData(
            question = "Jak startował Quetzalcoatlus?",
            answers = listOf("Odpychając się przednimi kończynami", "Rozpędzając się z górki", "Z drzewa", "Z powierzchni wody", "Z krawędzi klifu", "Z podskoku", "Z pomocą wiatru"),
            correctAnswerIndex = "Odpychając się przednimi kończynami"
        ),

        QuestionData(
            question = "Który dinozaur latający nie miał zębów?",
            answers = listOf("Pteranodon", "Dimorphodon", "Rhamphorhynchus", "Quetzalcoatlus", "Mozazaur", "Plejozaur", "Tyranozaur"),
            correctAnswerIndex = "Pteranodon"
        ),

        QuestionData(
            question = "Który z dinozaurów był roślinożerny i poruszał się na czterech nogach?",
            answers = listOf("Stegozaur", "Tyranozaur", "Velociraptor", "Dimorphodon", "Ichtiozaur", "Mozazaur", "Quetzalcoatlus"),
            correctAnswerIndex = "Stegozaur"
        ),

        QuestionData(
            question = "Czym wyróżniała się kryza Triceratopsa?",
            answers = listOf("Chroniła kark i była elementem pokazowym", "Pomagała w lataniu", "Była narządem słuchu", "Zawierała gruczoły jadowe", "Była ruchoma", "Wytwarzała dźwięki", "Służyła jako płetwa"),
            correctAnswerIndex = "Chroniła kark i była elementem pokazowym"
        ),

        QuestionData(
            question = "Dlaczego Stegozaur miał mały mózg?",
            answers = listOf("Ponieważ nie potrzebował dużej inteligencji do przeżycia", "Był niedorozwinięty", "Zajmował miejsce na płyty grzbietowe", "Ewolucja zatrzymała jego rozwój", "Nie miał czaszki", "Był ssakiem", "To była choroba genetyczna"),
            correctAnswerIndex = "Ponieważ nie potrzebował dużej inteligencji do przeżycia"
        ),

        QuestionData(
            question = "Który morski gad przypominał rekina lub orkę?",
            answers = listOf("Ichtiozaur", "Plejozaur", "Mozazaur", "Quetzalcoatlus", "Dimorphodon", "Triceratops", "Brachiozaur"),
            correctAnswerIndex = "Ichtiozaur"
        ),

        QuestionData(
            question = "Czym żywił się Plejozaur?",
            answers = listOf("Ryby i kałamarnice", "Liście", "Dinozaury lądowe", "Owady", "Ptaki", "Ssaki morskie", "Plankton"),
            correctAnswerIndex = "Ryby i kałamarnice"
        ),

        QuestionData(
            question = "Który gad morski był drapieżnikiem z ostrymi zębami i potężną szczęką?",
            answers = listOf("Liopleurodon", "Ichtiozaur", "Stegozaur", "Triceratops", "Dimorphodon", "Pteranodon", "Brachiozaur"),
            correctAnswerIndex = "Liopleurodon"
        ),

        QuestionData(
            question = "Jaka była cecha wspólna morskich gadów jak mozazaur i plejozaur?",
            answers = listOf("Oddychały powietrzem", "Miały skrzela", "Były bezkręgowcami", "Poruszały się na nogach", "Miały pióra", "Były ssakami", "Były ciepłokrwiste"),
            correctAnswerIndex = "Oddychały powietrzem"
        ),

        QuestionData(
            question = "Jak nazywa się największy znany latający gad?",
            answers = listOf("Quetzalcoatlus", "Dimorphodon", "Pteranodon", "Tyranozaur", "Mozazaur", "Plejozaur", "Stegozaur"),
            correctAnswerIndex = "Quetzalcoatlus"
        ),

        QuestionData(
            question = "Który z latających gadów miał rozpiętość skrzydeł ponad 10 metrów?",
            answers = listOf("Quetzalcoatlus", "Dimorphodon", "Pteranodon", "Rhamphorhynchus", "Ichtiozaur", "Plejozaur", "Velociraptor"),
            correctAnswerIndex = "Quetzalcoatlus"
        ),

        QuestionData(
            question = "Dlaczego Dimorphodon zawdzięcza swoją nazwę?",
            answers = listOf("Miał dwa rodzaje zębów", "Miał dwa skrzydła", "Miał dwie głowy", "Był dwupłciowy", "Był dwunożny i czworonożny", "Żył w dwóch epokach", "Był dinozaurem i ptakiem"),
            correctAnswerIndex = "Miał dwa rodzaje zębów"
        ),

        QuestionData(
            question = "Który latający gad miał bezzębny dziób i charakterystyczny grzebień na głowie?",
            answers = listOf("Pteranodon", "Dimorphodon", "Quetzalcoatlus", "Stegozaur", "Plejozaur", "Tyranozaur", "Mozazaur"),
            correctAnswerIndex = "Pteranodon"
        )

    )


}