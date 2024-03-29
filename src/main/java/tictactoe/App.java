package tictactoe;


import tictactoe.classes.logic.MH;
import tictactoe.classes.rendering.ScreenManager;
import tictactoe.classes.rendering.screens.GameScreen;
import processing.core.*;

/**
 * Hello world! And hello Casper!
 * Hi!
 *
 */
public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("tictactoe.App");
    }

    @Override
    public void settings() {
        size(600, 600, P2D);
    }

    @Override
    public void setup() {
        surface.setTitle("Tic Tac Toe");
        ScreenManager.setPApplet(this);
        ScreenManager.setScreen(new GameScreen());
    }

    @Override
    public void draw() {
        MH.update();
        MH.mouseX = mouseX;
        MH.mouseY = mouseY;

        ScreenManager.currentScreen.update();
        ScreenManager.currentScreen.render();

    }

    @Override
    public void mousePressed() {
        if (mouseButton == LEFT) {
            MH.leftClicked = true;
        } else {
            MH.rightClicked = true;
        }
    }

    @Override
    public void mouseReleased() {
        if (mouseButton == LEFT) {
            MH.leftClicked = false;
        } else {
            MH.rightClicked = false;
        }
    }

}
