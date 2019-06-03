package PlatformFinal;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Block {

    private int speed;

    public Player() {
        super(10, 10);
        speed = 5;
    }

    public Player(int x, int y) {
        super(x, y);
        speed = 5;
    }
    
    public Player(int x, int y, int wid, int ht, Color col, int s) {
        super(x, y, wid, ht, col);
        speed = s;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void moveUpAndDraw(Graphics window) {
        draw(window, Color.white);

        setyPos(getyPos() - getSpeed());

        draw(window);
    }

    public void moveDownAndDraw(Graphics window) {
        draw(window, Color.white);

        setyPos(getyPos() + getSpeed());

        draw(window);
    }
    
    public void moveRightAndDraw(Graphics window) {
        draw(window, Color.white);

        setxPos(getxPos() + getSpeed());

        draw(window);
    }

    public void moveLeftAndDraw(Graphics window) {
        draw(window, Color.white);

        setxPos(getxPos() - getSpeed());

        draw(window);
    }

    public int getSpeed() {
        return speed;
    }

    public String toString() {
        return super.toString() + " " + speed;
    }
}
