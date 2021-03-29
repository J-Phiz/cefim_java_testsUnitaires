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
    }

    @Test
    void toStringTestCase() {
        color = new Color(13, 141, 253);
        assertEquals("[value=#0D8DFD, r=13, g=141, b=253]", color.toString());
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
    void separateColorsConstructorRedTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(257, 12, 43);
        });
    }
    @Test
    void separateColorsConstructorGreenTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(253, 0x0FFE, 43);
        });
    }
    @Test
    void separateColorsConstructorBlueTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(251, 12, 0x100);
        });
    }
    @Test
    void separateColorsConstructorRedTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(-3, 12, 43);
        });
    }
    @Test
    void separateColorsConstructorGreenTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(253, -23, 43);
        });
    }
    @Test
    void separateColorsConstructorBlueTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(25, 12, 0xFFFFFFFE);
        });
    }

    @Test
    void hexaColorsConstructorWrongStringTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("RougeLeger;VertMoyen;BlueSombre");
        });
    }
    @Test
    void hexaColorsConstructorWrongHeaderTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("%d345F8");
        });
    }
    @Test
    void hexaColorsConstructorWrongSizeTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("#d345f34");
        });
    }
    @Test
    void hexaColorsConstructorWrongSizeTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("#d345f");
        });
    }
    @Test
    void hexaColorsConstructorWrongHexaTestCase() {
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
