/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlatformFinal;

/**
 *
 * @author beere1633
 */

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;

    public Block() {

    }

    public Block(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public Block(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public Block(int x, int y, int w, int h, Color c) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = c;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color col) {
        color = col;
    }

    public void setPos(int x, int y) {
        setxPos(x);
        setyPos(y);
    }

    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(getxPos(), getyPos(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        window.fillRect(getxPos(), getyPos(), getWidth(), getHeight());
    }

    public boolean equals(Object obj) {

        Block test = (Block) obj;
        if (this.getColor() != null && test.getColor() != null) {
            if (this.getxPos() == test.getxPos() && this.getyPos() == test.getyPos()
                    && this.getWidth() == test.getWidth() && this.getHeight() == test.getHeight()
                    && this.getColor().equals(test.getColor())) {

                return true;

            }

        } else {
            if (this.getxPos() == test.getxPos() && this.getyPos() == test.getyPos()
                    && this.getWidth() == test.getWidth() && this.getHeight() == test.getHeight()) {

                return true;

            }
        }

        return false;
    }

    //add a toString() method  - x , y , width, height, color
    public String toString() {
        return getxPos() + " " + getyPos() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }

}
