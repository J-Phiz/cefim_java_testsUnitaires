import fr.jpsave.testu.Color;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTests {

    private Color color;

    @BeforeAll
    static void beforeClassTests() {
        System.out.println("C'est parti pour le déroulement des tests unitaires");
    }

    @BeforeEach
    void setUpTests() {
        System.out.println("Lancement d'un Test");
    }

    @Test
    void jUnitTestCase() {
        System.out.println("Je suis dans le test");
        assertNull(color);
    }

    @Test
    void jUnit2TestCase() {
        assertNotNull(color);
        System.out.println("Je suis dans le test2");
    }

    @AfterEach
    void tearDownTests() {
        System.out.println("Fin du Test");
    }

    @AfterAll
    static void afterClassTests() {
        System.out.println("Dommage c'est déjà fini...");
    }

}
