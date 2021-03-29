package fr.jpsave.testu;

import java.util.Locale;

public class Color {

    private int red;
    private int green;
    private int blue;
    private ColorHexCode code;

    public Color(int red, int green, int blue) {
        this.red = checkColorNumber(red);
        this.green = checkColorNumber(green);
        this.blue = checkColorNumber(blue);

        this.code = new ColorHexCode(String.format("#%06X", (this.red << 16) + (this.green << 8) + this.blue));
    }

    public Color(String rgbCode) {
        this.code = new ColorHexCode(rgbCode);

        this.red = (code.getColorValue() & 0x00FF0000) >> 16;
        this.green = (code.getColorValue() & 0x0000FF00) >> 8;
        this.blue = code.getColorValue() & 0x000000FF;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public String getRgbCode() {
        return code.getColorPrint();
    }

    public void setRgbCode(String code) {
        this.code = new ColorHexCode(code);
    }

    @Override
    public String toString() {
        return "[value=" + code.getColorPrint() + ", r=" + red +
        ", g=" + green + ", b=" + blue + "]";
    }


    private int checkColorNumber(int number) {
        if (number >= 0 && number <= 0xFF) {
            return number;
        } else {
            throw new IllegalArgumentException(
                    "Le format d'un composant d'une couleur doit être un nombre entre 0 et 255"
            );
        }
    }


    private class ColorHexCode {
        private final String colorPrint;
        private final int colorValue;

        ColorHexCode(String color) {
            if (color == null || color.isEmpty() || color.charAt(0) != '#' || color.length() != 7) {
                throw new IllegalArgumentException(
                        "Le format d'une couleur doit être #XXXXXX où X est un nombre compris entre 0 et F"
                );
            }
            this.colorPrint = color.toUpperCase(Locale.ROOT);
            this.colorValue = Integer.parseInt(color.substring(1), 16);
        }

        String getColorPrint() {
            return colorPrint;
        }

        int getColorValue() {
            return colorValue;
        }
    }

}