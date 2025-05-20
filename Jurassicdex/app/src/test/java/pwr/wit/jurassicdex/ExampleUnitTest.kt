package pwr.wit.jurassicdex.ui.modelView

class ExampleUnitTest{

}
//
//class DinosaurViewModelTest {
//
//    private val viewModel = DinosaurViewModel()
//
//    @Test
//    fun `should return correct list of dinosaurs`() {
//        // Given
//        val expectedDinosaurCount = 12
//
//        // When
//        val dinosaurs = viewModel.dinosaurs
//
//        // Then
//        assertEquals(expectedDinosaurCount, dinosaurs.size)
//        assertEquals("Brachiozaur", dinosaurs[0].title)
//        assertEquals("Pteranodon", dinosaurs.last().title)
//    }
//
//    @Test
//    fun `getDinosaurByName should return correct dinosaur`() {
//        // Given
//        val dinosaurName = "Tyrannosaurus rex"
//
//        // When
//        val dinosaur = viewModel.getDinosaurByName(dinosaurName)
//
//        // Then
//        assertNotNull(dinosaur)
//        assertEquals(dinosaurName, dinosaur?.title)
//        assertEquals(" Późna kreda (68–66 mln lat temu)", dinosaur?.text1?.text?.split("\n")?.first()?.substringAfter(":"))
//    }
//
//    @Test
//    fun `getDinosaurByName should return null for non-existent dinosaur`() {
//        // Given
//        val nonExistentName = "Nieistniejacy Dinozaur"
//
//        // When
//        val dinosaur = viewModel.getDinosaurByName(nonExistentName)
//
//        // Then
//        assertNull(dinosaur)
//    }
//
//    @Test
//    fun `should have correct properties for Brachiozaur`() {
//        // Given
//        val brachiozaur = viewModel.dinosaurs[0]
//
//        // Then
//        assertEquals("Brachiozaur", brachiozaur.title)
//        assertEquals(3, brachiozaur.images.size)
//        assert(brachiozaur.text1.text.contains("Późna jura (154–150 mln lat temu)"))
//        assert(brachiozaur.text2.contains("Mimo że był jednym z największych dinozaurów"))
//    }
//
//    @Test
//    fun `should have correct properties for Pteranodon`() {
//        // Given
//        val pteranodon = viewModel.dinosaurs.last()
//
//        // Then
//        assertEquals("Pteranodon", pteranodon.title)
//        assertEquals(3, pteranodon.images.size)
//        assert(pteranodon.text1.text.contains("Późna kreda (86–84 mln lat temu)"))
//        assert(pteranodon.text2.contains("W przeciwieństwie do wielu innych pterozaurów"))
//    }
//}
//
//
//
//
//
//
//
//class DinosaurScreenTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//    private lateinit var navController: TestNavHostController
//    private val viewModel = DinosaurViewModel()
//
//    @Before
//    fun setup() {
//        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
//        composeTestRule.setContent {
//            navController = rememberNavController() as TestNavHostController
//            DinosaurScreen(
//                navController = navController,
//                dinozaurName = "Tyrannosaurus rex",
//                dinozaurViewModel = viewModel
//            )
//        }
//    }
//
//    @Test
//    fun shouldDisplayCorrectDinosaurDetails() {
//        composeTestRule.onNodeWithText("Tyrannosaurus rex").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Późna kreda (68–66 mln lat temu)").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Mięsożerny").assertIsDisplayed()
//    }
//
//    @Test
//    fun shouldDisplayAllDinosaurCharacteristics() {
//        val dinosaur = viewModel.getDinosaurByName("Tyrannosaurus rex")
//        val characteristics = dinosaur?.text1?.text?.split("\n") ?: emptyList()
//
//        characteristics.forEach { char ->
//            composeTestRule.onNodeWithText(char.substringAfter(":").trim()).assertIsDisplayed()
//        }
//    }
//
//    @Test
//    fun shouldDisplayDinosaurDescription() {
//        composeTestRule.onNodeWithText(
//            "Miał najsilniejsze ugryzienie ze wszystkich znanych dinozaurów"
//        ).assertIsDisplayed()
//    }
//}
//
//@Test
//fun shouldNavigateBackWhenBackButtonClicked(): Unit {
//    composeTestRule.onNodeWithContentDescription("Back button").performClick()
//    assertEquals(navController.previousBackStackEntry?.destination?.route, "previous_screen_route")
//}
//
//// Jeśli masz przycisk "Powrót" z tekstem zamiast ikony
//@Test
//fun shouldNavigateBackWhenTextBackButtonClicked() {
//    composeTestRule.onNodeWithText("Powrót").performClick()
//    assertEquals(navController.previousBackStackEntry?.destination?.route, "previous_screen_route")
//}