package PlatformFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Level extends Canvas implements KeyListener, Runnable {

    private Player user;
    private Enemy1 bob;
    private Enemy1 bob2;
    private Enemy1 bob3;
    private Enemy1 bob4;
    private Enemy1 bob5;
    private Enemy1 bob6;
    private Enemy1 bob7;
    private Enemy1 goal;
    private boolean[] keys;
    private BufferedImage back;


    public Level() {
        user = new Player(100, 100, 20, 25, Color.blue, 2);
        bob = new Enemy1(200,0,20,260, Color.red, 2, 1);
        bob2 = new Enemy1(280,300,20,260, Color.red, 2, 1);
        bob3 = new Enemy1(200,150,200,20, Color.red, 2, 1);
        bob4 = new Enemy1(380,70,20,380, Color.red, 2, 1);
        bob5 = new Enemy1(440,300,100,20, Color.red, 2, 1);
        bob6 = new Enemy1(580,0,20,600, Color.red, 2, 1);
        bob7 = new Enemy1(270,50,200,20, Color.red, 2, 1);
        goal = new Enemy1(310, 95, 30, 30, Color.green);
        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);		
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        Graphics graphToBack = back.createGraphics();

        graphToBack.setColor(Color.red);

        user.draw(graphToBack);
        bob.draw(graphToBack);
        bob2.draw(graphToBack);
        bob3.draw(graphToBack);
        bob4.draw(graphToBack);
        bob5.draw(graphToBack);
        bob6.draw(graphToBack);
        bob7.draw(graphToBack);
        goal.draw(graphToBack);


        if (bob.didCollideLeft(user) && (bob.didCollideRight(user))&&(user.getyPos()<260)){
            user.setxPos(100);
            user.setyPos(100);
        }
        if (bob2.didCollideLeft(user) && (bob2.didCollideRight(user))&&(user.getyPos()>275)){
            user.setxPos(100);
            user.setyPos(100);
        }
        if (bob3.didCollideTop(user) && (bob3.didCollideBottom(user))&&(user.getxPos()<360)&&(user.getxPos()>200)){
            user.setxPos(100);
            user.setyPos(100);
        }
        if (bob4.didCollideLeft(user) && (bob4.didCollideRight(user))&&(user.getyPos()>70)&&(user.getyPos()<450)){
            user.setxPos(100);
            user.setyPos(100);
        }
        if (bob5.didCollideTop(user) && (bob5.didCollideBottom(user))&&(user.getxPos()<540)&&(user.getxPos()>440)){
            user.setxPos(100);
            user.setyPos(100);
        }
        if (bob6.didCollideLeft(user) && (bob6.didCollideRight(user))){
            user.setxPos(100);
            user.setyPos(100);
        }
        if (bob7.didCollideTop(user) && (bob7.didCollideBottom(user))&&(user.getxPos()<470)&&(user.getxPos()>270)){
            user.setxPos(100);
            user.setyPos(100);
        }
        if (goal.didCollideLeft(user) && (goal.didCollideRight(user))&&(user.getyPos()<130)&&(user.getyPos()>90)){
            user.setColor(Color.cyan);
        }
        
        if (keys[0] == true) {
            user.moveUpAndDraw(graphToBack);
        }
        if (keys[1] == true) {
            user.moveDownAndDraw(graphToBack);
        }
        if (keys[2] == true) {
            user.moveLeftAndDraw(graphToBack);
        }
        if (keys[3] == true) {
            user.moveRightAndDraw(graphToBack);
        }
  
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'S':
                keys[1] = true;
                break;
            case 'A':
                keys[2] = true;
                break;
            case 'D':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'S':
                keys[1] = false;
                break;
            case 'A':
                keys[2] = false;
                break;
            case 'D':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
