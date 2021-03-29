package fr.jpsave.testu;

public class Color {

    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public Color(String rgbCode) {
        setRgbCode(rgbCode);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = checkColorNumber(red);
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = checkColorNumber(green);
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = checkColorNumber(blue);
    }

    public String getRgbCode() {
        return String.format("#%06X", (this.red << 16) + (this.green << 8) + this.blue);
    }

    public void setRgbCode(String hexCode) {
        if (hexCode == null || hexCode.isEmpty() || hexCode.charAt(0) != '#' || hexCode.length() != 7) {
            throw new IllegalArgumentException(
                    "Le format d'une couleur doit être #XXXXXX où X est un nombre compris entre 0 et F"
            );
        }

        int code = Integer.parseInt(hexCode.substring(1), 16);

        setRed((code & 0x00FF0000) >> 16);
        setGreen((code & 0x0000FF00) >> 8);
        setBlue(code & 0x000000FF);
    }

    @Override
    public String toString() {
        return "[value=" + getRgbCode() + ", r=" + getRed() +
        ", g=" + getGreen() + ", b=" + getBlue() + "]";
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

}
