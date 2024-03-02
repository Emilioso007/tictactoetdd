
package tictactoe.classes.rendering.screens;

import processing.core.*;
import tictactoe.classes.logic.GameManager;
import tictactoe.classes.rendering.Screen;
import tictactoe.classes.rendering.ScreenManager;

public class GameScreen extends Screen{
    
    private int n = 3;

    PApplet p;
    PFont f;

    private GameManager gameManager;

    public GameScreen() {
        this.p = ScreenManager.p;
        gameManager = new GameManager(n);

        p.printArray(PFont.list());
        f = p.createFont("Source Code Pro Regular", p.width / n * 2);
        p.textFont(f);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);

    }

    @Override
    public void update() {
        gameManager.update();
    }

    @Override
    public void render() {
        
        p.background(255);

        p.fill(0);
        
        p.text("XIX", p.width/2, p.height/2);


    }

}
