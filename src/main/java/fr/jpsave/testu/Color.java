package fr.jpsave.testu;

import java.util.Locale;

public class Color {

    private int red;
    private int green;
    private int blue;
    private String code;

    private boolean checkColorNumber(int number) {
        return number >= 0 && number <= 0xFF;
    }

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;

        if(!checkColorNumber(red) || !checkColorNumber(green) || !checkColorNumber(blue)) {
            throw new IllegalArgumentException(
                    "Le format d'un composant d'une couleur doit être un nombre entre 0 et 255"
            );
        }

        this.code = String.format("#%06X", (red << 16) + (green << 8) + blue);
    }

    public Color(String rgbCode) {
        if (rgbCode == null || rgbCode.isEmpty() || rgbCode.charAt(0) != '#' || rgbCode.length() != 7) {
            throw new IllegalArgumentException(
                    "Le format d'une couleur doit être #XXXXXX où X est un nombre compris entre 0 et F"
            );
        }

        this.code = rgbCode.toUpperCase(Locale.ROOT);


        int code = Integer.parseInt(rgbCode.substring(1), 16);

        this.red = (code & 0x00FF0000) >> 16;
        this.green = (code & 0x0000FF00) >> 8;
        this.blue = code & 0x000000FF;
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
        return code;
    }

    public void setRgbCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "[value=" + code + ", r=" + red +
        ", g=" + green + ", b=" + blue + "]";
    }
}
