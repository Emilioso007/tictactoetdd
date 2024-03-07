
package tictactoe.classes.rendering.screens;

import processing.core.*;
import tictactoe.classes.logic.GameManager;
import tictactoe.classes.rendering.Screen;
import tictactoe.classes.rendering.ScreenManager;

public class GameScreen extends Screen {

    private int n = 3;

    PApplet p;
    PFont f;

    private GameManager gameManager;

    public GameScreen() {
        this.p = ScreenManager.p;
        gameManager = new GameManager(n);

        // PApplet.printArray(PFont.list());
        // f = p.createFont("Source Code Pro Regular", p.width / n * 2);
        // p.textFont(f);
        // p.textAlign(PConstants.CENTER, PConstants.CENTER);

    }

    @Override
    public void update() {
        gameManager.update();
    }

    @Override
    public void render() {

        p.background(255);

        // draw grid
        p.stroke(0);
        p.strokeWeight(4);
        int dimension = p.width / n;
        for (int i = 1; i < n; i++) {
            p.line(i * dimension, 0, i * dimension, p.height);
            p.line(0, i * dimension, p.width, i * dimension);
        }

        // draw symbols
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char tempState = gameManager.cells[i][j].getState();

                if (tempState == 'X') {
                    p.line(j * dimension, i * dimension, (j + 1) * dimension, (i + 1) * dimension);
                    p.line((j + 1) * dimension, i * dimension, j * dimension, (i + 1) * dimension);
                } else if (tempState == 'O') {
                    p.noFill();
                    p.ellipse(j * dimension + dimension / 2, i * dimension + dimension / 2, dimension / 2,
                            dimension / 2);
                }

            }
        }

        // draw winner or tie
        if (gameManager.winner != ' ') {
            p.textAlign(PConstants.CENTER, PConstants.CENTER);
            p.fill(255,0,0);
            p.textSize(72);
            if (gameManager.winner == 'T') {

                p.text("You both suck", p.width / 2, p.height / 2);

            } else {
                p.text("Winner: " + gameManager.winner, p.width / 2, p.height / 2);
            }
        }
    }

}
