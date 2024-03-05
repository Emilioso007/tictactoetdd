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
        p.size(100,100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(3);
        gm.update();

        assertFalse(gm.currentPlayer == 'O');
    }

    @Test
    public void canWin() {

        PApplet p = new PApplet();
        p.size(100,100);

        ScreenManager.p = p;

        GameManager gm = new GameManager(4);
        gm.cells[4].setState('X');
        gm.cells[5].setState('X');
        gm.cells[6].setState('X');
        gm.cells[7].setState('X');

        assertTrue(gm.checkWin());
        assertTrue(gm.winner == 'X');

    }
    
}
