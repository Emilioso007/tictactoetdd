package tictactoe.classes.logic;

import processing.core.PApplet;
import tictactoe.classes.rendering.ScreenManager;

public class GameManager {

    private PApplet p;

    public Cell[] cells;

    public char currentPlayer = 'X';

    public char winner = ' ';

    public int n;

    public GameManager(int n) {

        this.n = n;

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

            if (c.isClicked() && c.getState() == ' ') {
                c.setState(currentPlayer);
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

        }

        // checkWin();

    }

    public boolean checkWin() {

        // check rows
        char tempWinner = ' ';
        for (int i = 0; i < n; i++) {
            tempWinner = cells[i*n].getState();
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (cells[index].getState() != tempWinner) {
                    tempWinner = ' ';
                    break;
                }
            }
        }
        if(tempWinner != ' '){
            winner = tempWinner;
            return true;
        }

        // check columns (NOT FINISHED)
        for (int i = 0; i < Math.sqrt(cells.length); i++) {
            if (cells[i].getState() == cells[i + 3].getState() && cells[i].getState() == cells[i + 6].getState()
                    && cells[i].getState() != ' ') {
                winner = cells[i].getState();
                return true;
            }
        }

        // check diagonals
        char tempWinner1 = cells[0].getState();
        if (tempWinner1 != ' ') {
            int tempScore1 = 1;
            for (int i = 1; i < n; i++) {
                if (cells[i * n + i].getState() == tempWinner1) {
                    tempScore1 += 1;
                }
            }
            if (tempScore1 == n) {
                winner = tempWinner1;
                return true;
            }
        }

        // check diagonals the other way
        char tempWinner2 = cells[n - 1].getState();
        if (tempWinner2 != ' ') {
            int tempScore2 = 1;
            for (int i = 1; i < n; i++) {
                if (cells[(i + 1) * n - (i + 1)].getState() == tempWinner2) {
                    tempScore2 += 1;
                }
            }
            if (tempScore2 == n) {
                winner = tempWinner2;
                return true;
            }
        }

        return false;
    }

}
