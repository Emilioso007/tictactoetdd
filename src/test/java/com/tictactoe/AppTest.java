package com.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import processing.core.PApplet;
import tictactoe.classes.logic.GameManager;
import tictactoe.classes.rendering.ScreenManager;
import tictactoe.classes.logic.Cell;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void canSwitchPlayers() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(3);
        Cell c = gm.cells[0][0];
        c.clicked = true;
        gm.runLogic();

        assertTrue(gm.currentPlayer == 'O');

        Cell c2 = gm.cells[0][1];
        c2.clicked = true;
        gm.runLogic();

        assertTrue(gm.currentPlayer == 'X');
    }

    @Test
    public void canWinRow3x3() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(3);

        gm.cells[0][0].setState('X');
        gm.cells[0][1].setState('X');
        gm.cells[0][2].setState('X');

        assertTrue(gm.checkRows());
        assertTrue(gm.winner == 'X');
    }

    @Test
    public void canWinCol3x3() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(3);

        gm.cells[0][0].setState('X');
        gm.cells[1][0].setState('X');
        gm.cells[2][0].setState('X');

        assertTrue(gm.checkCols());
        assertTrue(gm.winner == 'X');
    }

    @Test
    public void canWinDiagonalOne3x3() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(3);

        gm.cells[0][0].setState('X');
        gm.cells[1][1].setState('X');
        gm.cells[2][2].setState('X');

        assertTrue(gm.checkDiagonalOne());
        assertTrue(gm.winner == 'X');
    }

    @Test
    public void canWinDiagonalTwo3x3() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(3);

        gm.cells[0][2].setState('X');
        gm.cells[1][1].setState('X');
        gm.cells[2][0].setState('X');

        assertTrue(gm.checkDiagonalTwo());
        assertTrue(gm.winner == 'X');
    }

    @Test
    public void canWinRow4x4() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(4);

        gm.cells[0][0].setState('X');
        gm.cells[0][1].setState('X');
        gm.cells[0][2].setState('X');
        gm.cells[0][3].setState('X');

        assertTrue(gm.checkRows());
        assertTrue(gm.winner == 'X');
    }

    @Test
    public void canWinCol4x4() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(4);

        gm.cells[0][0].setState('X');
        gm.cells[1][0].setState('X');
        gm.cells[2][0].setState('X');
        gm.cells[3][0].setState('X');

        assertTrue(gm.checkCols());
        assertTrue(gm.winner == 'X');
    }

    @Test
    public void canWinDiagonalOne4x4() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(4);

        gm.cells[0][0].setState('X');
        gm.cells[1][1].setState('X');
        gm.cells[2][2].setState('X');
        gm.cells[3][3].setState('X');

        assertTrue(gm.checkDiagonalOne());
        assertTrue(gm.winner == 'X');
    }

    @Test
    public void canWinDiagonalTwo4x4() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(4);

        gm.cells[0][3].setState('X');
        gm.cells[1][2].setState('X');
        gm.cells[2][1].setState('X');
        gm.cells[3][0].setState('X');

        assertTrue(gm.checkDiagonalTwo());
        assertTrue(gm.winner == 'X');
    }
    

    @Test
    public void canTie() {
            
            PApplet p = new PApplet();
            p.size(100, 100);
    
            ScreenManager.p = p;
    
            GameManager gm = new GameManager(3);
    
            gm.cells[0][0].setState('X');
            gm.cells[0][1].setState('O');
            gm.cells[0][2].setState('X');
            gm.cells[1][0].setState('X');
            gm.cells[1][1].setState('O');
            gm.cells[1][2].setState('O');
            gm.cells[2][0].setState('O');
            gm.cells[2][1].setState('X');
            gm.cells[2][2].setState('X');
    
            assertTrue(gm.checkTie());
    }

    @Test
    public void canOWin3x3() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(3);

        gm.cells[0][0].setState('O');
        gm.cells[0][1].setState('O');
        gm.cells[0][2].setState('O');

        assertTrue(gm.checkRows());
        assertTrue(gm.winner == 'O');
    }

    @Test
    public void canOWin4x4() {

        PApplet p = new PApplet();
        p.size(100, 100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(4);

        gm.cells[0][0].setState('O');
        gm.cells[0][1].setState('O');
        gm.cells[0][2].setState('O');
        gm.cells[0][3].setState('O');

        assertTrue(gm.checkRows());
        assertTrue(gm.winner == 'O');
    }
}