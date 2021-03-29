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
        color = new Color(0, 12, 43);
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
    void hexaColorsConstructorWrongString1TestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color(null);
        });
    }
    @Test
    void hexaColorsConstructorWrongString2TestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color = new Color("");
        });
    }
    @Test
    void hexaColorsConstructorWrongString3TestCase() {
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

    @Test
    void getRedTestCase() {
        color = new Color(0x23, 0x45, 0x67);
        assertEquals(0x23, color.getRed());
        assertEquals(0x45, color.getGreen());
        assertEquals(0x67, color.getBlue());
        assertEquals("#234567", color.getRgbCode());
    }
    @Test
    void getGreenTestCase() {
        color = new Color(0x23, 0x45, 0x67);
        assertEquals(0x23, color.getRed());
        assertEquals(0x45, color.getGreen());
        assertEquals(0x67, color.getBlue());
        assertEquals("#234567", color.getRgbCode());
    }
    @Test
    void getBlueTestCase() {
        color = new Color(0x23, 0x45, 0x67);
        assertEquals(0x23, color.getRed());
        assertEquals(0x45, color.getGreen());
        assertEquals(0x67, color.getBlue());
        assertEquals("#234567", color.getRgbCode());
    }

    @Test
    void setRedOKTestCase() {
        color = new Color(0x23, 0x45, 0x67);
        color.setRed(255);
        assertEquals(255, color.getRed());
        assertEquals(0x45, color.getGreen());
        assertEquals(0x67, color.getBlue());
        assertEquals("#FF4567", color.getRgbCode());
    }
    @Test
    void setGreenOKTestCase() {
        color = new Color(0x23, 0x45, 0x67);
        color.setGreen(255);
        assertEquals(0x23, color.getRed());
        assertEquals(255, color.getGreen());
        assertEquals(0x67, color.getBlue());
        assertEquals("#23FF67", color.getRgbCode());
    }
    @Test
    void setBlueOKTestCase() {
        color = new Color(0x23, 0x45, 0x67);
        color.setBlue(255);
        assertEquals(0x23, color.getRed());
        assertEquals(0x45, color.getGreen());
        assertEquals(255, color.getBlue());
        assertEquals("#2345FF", color.getRgbCode());
    }
    @Test
    void setCodeOKTestCase() {
        color = new Color("#234567");
        color.setRgbCode("#765432");
        assertEquals(0x76, color.getRed());
        assertEquals(0x54, color.getGreen());
        assertEquals(0x32, color.getBlue());
        assertEquals("#765432", color.getRgbCode());
    }

    @Test
    void setRedTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRed(257);
        });
    }
    @Test
    void setGreenTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setGreen(0x0FFE);
        });
    }
    @Test
    void setBlueTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setBlue(0x100);
        });
    }
    @Test
    void stRedTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRed(-3);
        });
    }
    @Test
    void setGreenTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setGreen(-23);
        });
    }
    @Test
    void setBlueTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setBlue(0xFFFFFFFE);
        });
    }

    @Test
    void setCodeWrongString1TestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRgbCode(null);
        });
    }
    @Test
    void setCodeWrongString2TestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRgbCode("");
        });
    }
    @Test
    void setCodeWrongString3TestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRgbCode("RougeLeger;VertMoyen;BlueSombre");
        });
    }
    @Test
    void setCodeWrongHeaderTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRgbCode("%d345F8");
        });
    }
    @Test
    void setCodeWrongSizeTooBigTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRgbCode("#d345f34");
        });
    }
    @Test
    void setCodeWrongSizeTooSmallTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRgbCode("#d345f");
        });
    }
    @Test
    void setCodeWrongHexaTestCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRgbCode("#d3y5fG");
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
