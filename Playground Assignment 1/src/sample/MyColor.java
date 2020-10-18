package sample;

import javafx.scene.paint.Color;

public enum MyColor{
    BLACK(0, 0, 0), BLUE(0, 0, 255), CYAN(0, 255, 255), DARK_GRAY(169, 169, 169), GRAY(128, 128, 128),
    GREEN(0, 255, 0), MAGENTA(255, 0, 255), ORANGE(255, 255, 0), LIGHT_GRAY(211, 211, 211),
    RED(255, 0, 0), WHITE(255, 255, 255), YELLOW(255, 255, 0), PINK(255, 192, 203), NAVY (0, 0, 128);

    private Color color;

    // Constructor

    MyColor(int r, int g, int b) {
        this.color = Color.rgb (r,g,b);
    }
    public Color getColor(){ return color; }
}