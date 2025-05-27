package pwr.wit.jurassicdex

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    //Sprawdzanie czy syświetla się start screen
    @Test
    fun app_starts_and_shows_start_screen() {
        composeTestRule.onNodeWithTag("start_screen").assertExists()
        composeTestRule.onNodeWithTag("start_screen").assertIsDisplayed()

    }

    //sprawdzenie działania rozwijanego menu
    @Test
    fun hamburger_menu_click() {
        //czy hamburger menu istnieje ale lista kategorii nie
        composeTestRule.onNodeWithTag("hamburger_menu").assertExists()
        composeTestRule.onNodeWithTag("menu_list").assertDoesNotExist()

        //wciśnięcie hamburgera
        composeTestRule
            .onNodeWithTag("hamburger_menu")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("hamburger_menu")
            .performClick()

        //sprawdzenie czy lista kategorii się wyświetliła
        composeTestRule.onNodeWithTag("menu_list").assertExists()
        composeTestRule
            .onNodeWithTag("menu_list")
            .assertIsDisplayed()

    }

    //przejście do kategorii
    @Test
    fun navigateToCategoryScreen() {
        goToCategoryScreen()
    }

    //przejście do quizu
    @Test
    fun navigateToQuizScreen() {
        goToQuizScreen()
    }

    //przejście do o nas
    @Test
    fun navigateToONasScreen() {
        goToOnasScreen()
    }

    //przejście do dinozaurów lądowych
    @Test
    fun navigateToLandDinos() {
        goToLandDinoCategoryScreen()
    }

    //przejście do dinozaura
    @Test
    fun navigateToFirstDino() {
        goToFirstDinoScreen()
    }




    //przejście do startu przez ikonę
    @Test
    fun navigateToStartByIcon() {
        goToOnasScreen()
        composeTestRule
            .onNodeWithTag("logo_button")
            .performClick()

        composeTestRule.onNodeWithTag("start_screen").assertExists()
        composeTestRule.onNodeWithTag("start_screen").assertIsDisplayed()
    }

    //test strzałki powrotnej
    @Test
    fun navigateBack() {
        goToOnasScreen()
        goToCategoryScreen()

        composeTestRule
            .onNodeWithTag("arrow_back_button")
            .performClick()

        composeTestRule.onNodeWithTag("onas_screen").assertExists()
        composeTestRule.onNodeWithTag("onas_screen").assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("arrow_back_button")
            .performClick()

        composeTestRule.onNodeWithTag("start_screen").assertExists()
        composeTestRule.onNodeWithTag("start_screen").assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("arrow_back_button")
            .performClick()

        composeTestRule.onNodeWithTag("start_screen").assertExists()
        composeTestRule.onNodeWithTag("start_screen").assertIsDisplayed()
    }

    //test przycisku home
    @Test
    fun navigateHome() {
        goToOnasScreen()
        composeTestRule
            .onNodeWithTag("home_button")
            .performClick()

        composeTestRule.onNodeWithTag("start_screen").assertExists()
        composeTestRule.onNodeWithTag("start_screen").assertIsDisplayed()
    }

    //test przycisku quiz
    @Test
    fun navigateQuestions() {
        goToOnasScreen()
        composeTestRule
            .onNodeWithTag("question_button")
            .performClick()

        composeTestRule.onNodeWithTag("quiz_screen").assertExists()
        composeTestRule.onNodeWithTag("quiz_screen").assertIsDisplayed()
    }





    //testy znikania stopki
    @Test
    fun footerIsHiddenAfterOrientationChange() {
        composeTestRule.onNodeWithTag("footer").assertExists()
        composeTestRule.onNodeWithTag("footer").assertIsDisplayed()

        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        device.setOrientationLeft()

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("footer").assertDoesNotExist()
        composeTestRule.onNodeWithTag("footer").assertIsNotDisplayed()

        device.setOrientationNatural()
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("footer").assertExists()
        composeTestRule.onNodeWithTag("footer").assertIsDisplayed()
    }








    fun goToFirstDinoScreen() {
        goToLandDinoCategoryScreen()
        composeTestRule
            .onNodeWithTag("category_Brachiozaur_button")
            .performClick()


        composeTestRule.onNodeWithTag("Brachiozaur_screen").assertExists()
        composeTestRule.onNodeWithTag("Brachiozaur_screen").assertIsDisplayed()
    }

    fun goToLandDinoCategoryScreen() {
        goToCategoryScreen()
        composeTestRule
            .onNodeWithTag("category_Dinozaury Lądowe_button")
            .performClick()


        composeTestRule.onNodeWithTag("Dinozaury Lądowe_screen").assertExists()
        composeTestRule.onNodeWithTag("Dinozaury Lądowe_screen").assertIsDisplayed()
    }

    fun goToCategoryScreen() {

        composeTestRule
            .onNodeWithTag("hamburger_menu")
            .performClick()

        composeTestRule
            .onNodeWithTag("category_button")
            .performClick()


        composeTestRule.onNodeWithTag("Kategorie_screen").assertExists()
        composeTestRule.onNodeWithTag("Kategorie_screen").assertIsDisplayed()
    }

    fun goToQuizScreen() {
        composeTestRule
            .onNodeWithTag("hamburger_menu")
            .performClick()

        composeTestRule
            .onNodeWithTag("quiz_button")
            .performClick()


        composeTestRule.onNodeWithTag("quiz_screen").assertExists()
        composeTestRule.onNodeWithTag("quiz_screen").assertIsDisplayed()
    }

    fun goToOnasScreen() {
        composeTestRule
            .onNodeWithTag("hamburger_menu")
            .performClick()

        composeTestRule
            .onNodeWithTag("onas_button")
            .performClick()


        composeTestRule.onNodeWithTag("onas_screen").assertExists()
        composeTestRule.onNodeWithTag("onas_screen").assertIsDisplayed()
    }
}
