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
    
    public int getX() {
        int xVal = super.getxPos();
        if (xVal%10==1){
            xVal--;
        }
        if (xVal%10==2){
            xVal=xVal-2;
        }
        if (xVal%10==3){
            xVal=xVal-3;
        }
        if (xVal%10==4){
            xVal=xVal-4;
        }
        if (xVal%10==5){
            xVal=xVal-5;
        }
        if (xVal%10==6){
            xVal=xVal-6;
        }
        if (xVal%10==7){
            xVal=xVal-7;
        }
        if (xVal%10==8){
            xVal=xVal-8;
        }
        if (xVal%10==9){
            xVal=xVal-9;
        }
        return xVal;
    }
     public int getY() {
        int yVal = super.getyPos();
        if (yVal%10==1){
            yVal--;
        }
        if (yVal%10==2){
            yVal=yVal-2;
        }
        if (yVal%10==3){
            yVal=yVal-3;
        }
        if (yVal%10==4){
            yVal=yVal-4;
        }
        if (yVal%10==5){
            yVal=yVal-5;
        }
        if (yVal%10==6){
            yVal=yVal-6;
        }
        if (yVal%10==7){
            yVal=yVal-7;
        }
        if (yVal%10==8){
            yVal=yVal-8;
        }
        if (yVal%10==9){
            yVal=yVal-9;
        }
        return yVal;
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
