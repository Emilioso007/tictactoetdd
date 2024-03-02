package tictactoe.classes.rendering;

import processing.core.PApplet;

public class ScreenManager {

    public static PApplet p;

    public static Screen currentScreen;

    public ScreenManager() {
    }

    public static void setPApplet(PApplet p) {
        ScreenManager.p = p;
    }

    public static void setScreen(Screen screen) {
        ScreenManager.currentScreen = screen;
    }

}
