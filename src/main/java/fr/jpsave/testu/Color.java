package fr.jpsave.testu;

public class Color {

    private int red;
    private int green;
    private int blue;
    private String code;

    public Color(int red, int green, int blue) {

    }

    public Color(String rgbCode) {

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
        ", g=" +green + ", b=" + blue + "]";
    }
}
