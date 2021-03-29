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
        color = new Color(213, 141, 53);
    }

    @Test
    void separateColorsConstructorOKTestCase() {
        color = new Color(233, 11, 99);
        assertEquals(233, color.getRed());
        assertEquals(11, color.getGreen());
        assertEquals(99, color.getBlue());
        assertEquals("#E90B63", color.getRgbCode());
    }

    @Test
    void hexaColorsConstructorOKTestCase() {
        color = new Color("#D58d35");
        assertEquals(213, color.getRed());
        assertEquals(141, color.getGreen());
        assertEquals(53, color.getBlue());
        assertEquals("#D58D35", color.getRgbCode());
    }

    @Test
    void separateColorsConstructorKOTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(257, 12, 43);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(253, 0x0FFE, 43);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(251, 12, 0x100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(-3, 12, 43);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(253, -23, 43);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(25, 12, 0xFFFFFFFE);
        });
    }

    @Test
    void hexaColorsConstructorKOTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("RougeLeger;VertMoyen;BlueSombre");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("%d345F8");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("#d345f34");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("#d345f");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("#d3y5fG");
        });
    }

    @AfterEach
    void tearDownTests() {
        color = null;
    }

    @AfterAll
    static void afterClassTests() {
        System.out.println("Whouah c'est déjà fini...");
    }

}
