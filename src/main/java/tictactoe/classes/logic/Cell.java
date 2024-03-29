package tictactoe.classes.logic;

public class Cell {

    private int x, y, w, h;
    private char state;

    public boolean clicked = false;

    public Cell(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        state = ' ';
    }

    public void update() {
        if (MH.leftClicked) {
            if (MH.mouseX > x && MH.mouseX < x + w && MH.mouseY > y && MH.mouseY < y + h) {
                clicked = true;
            }
        } else {
            clicked = false;
        }
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

}
