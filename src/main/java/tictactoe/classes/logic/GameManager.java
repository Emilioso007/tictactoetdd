package tictactoe.classes.logic;

import processing.core.PApplet;
import tictactoe.classes.rendering.ScreenManager;

public class GameManager {

    private PApplet p;

    private Cell[] cells;

    public GameManager(int n) {

        this.p = ScreenManager.p;

        cells = new Cell[n * n];

        int dimension = p.width / n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i * n + j] = new Cell(j * dimension, i * dimension, dimension, dimension);
            }
        }

    }

    public void update() {
        for (Cell c : cells) {

            if (c.isClicked()) {
                c.setState('X');
            }

        }
    }

}
