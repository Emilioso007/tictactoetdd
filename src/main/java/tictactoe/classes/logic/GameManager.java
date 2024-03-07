package tictactoe.classes.logic;

import processing.core.PApplet;
import tictactoe.classes.rendering.ScreenManager;

public class GameManager {

    private PApplet p;

    public Cell[][] cells;

    public char currentPlayer = 'X';

    public char winner = ' ';

    public int n;

    public boolean clicked = false;

    public GameManager(int n) {

        this.n = n;

        this.p = ScreenManager.p;

        cells = new Cell[n][n];

        int dimension = p.width / n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell(j * dimension, i * dimension, dimension, dimension);
            }
        }

    }

    public void update() {
        if (!checkWin() && !checkTie()) {
            updateCells();
            runLogic();
        
        }
    }

    public void updateCells() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j].update();
            }
        }
    }

    public void runLogic() {

        for (Cell[] cOut : cells) {
            for (Cell c : cOut) {
                if (c.clicked && c.getState() == ' ') {
                    c.setState(currentPlayer);
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }

    }

    public boolean checkWin() {
        if (checkRows() || checkCols() || checkDiagonalOne() || checkDiagonalTwo()) {
            return true;
        }
        return false;
    }

    public boolean checkRows() {

        // check rows
        for (int i = 0; i < n; i++) {
            char temp = cells[i][0].getState();
            for (int j = 1; j < n; j++) {
                if (temp != cells[i][j].getState()) {
                    break;
                }
                if (j == n - 1 && temp != ' ') {
                    winner = temp;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCols() {

        // check cols
        for (int i = 0; i < n; i++) {
            char temp = cells[0][i].getState();
            for (int j = 1; j < n; j++) {
                if (temp != cells[j][i].getState()) {
                    break;
                }
                if (j == n - 1 && temp != ' ') {
                    winner = temp;
                    return true;
                }
            }
        }

        return false;

    }

    public boolean checkDiagonalOne() {

        // check diagonal one
        char temp = cells[0][0].getState();
        for (int i = 1; i < n; i++) {
            if (temp != cells[i][i].getState()) {
                break;
            }
            if (i == n - 1 && temp != ' ') {
                winner = temp;
                return true;
            }
        }

        return false;

    }

    public boolean checkDiagonalTwo() {

        // check diagonal two
        char temp = cells[0][n - 1].getState();
        for (int i = 1; i < n; i++) {
            if (temp != cells[i][n - 1 - i].getState()) {
                break;
            }
            if (i == n - 1 && temp != ' ') {
                winner = temp;
                return true;
            }
        }
        return false;
    }

    public boolean checkTie() {
        for (Cell[] cOut : cells) {
            for (Cell c : cOut) {
                if (c.getState() == ' ') {
                    return false;
                }
            }
        }
        winner = 'T';
        return true;
    }
}
