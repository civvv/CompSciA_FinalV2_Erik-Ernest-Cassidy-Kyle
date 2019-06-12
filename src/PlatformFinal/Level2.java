/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlatformFinal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Character.toUpperCase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beere1633
 */
public class Level2 extends Canvas implements KeyListener, Runnable {

    private Player user;
    private ArrayList<Ball> ballList;
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
    private FileWriter writer;
    private ArrayList<Enemy1> enemyList;
    private int score = 0;
    private Enemy1 leftwall;
    private Enemy1 topwall;
    private Enemy1 bottomwall;
    private Enemy1 rightwall;

    public Level2() {
        Ball ball1 = new Ball(350, 100, 30, 30, Color.gray, 2, 1);
        Ball ball2 = new Ball(200, 250, 40, 40, Color.gray, 1, 2);
        Ball ball3 = new Ball(450, 100, 45, 45, Color.black, -4, 2);
        Ball ball4 = new Ball(300, 30, 35, 35, Color.BLACK, 3, 5);
        Ball ball5 = new Ball(80, 450, 25 , 25, Color.black, -5, 2);
        Ball ball6 = new Ball(50, 460, 50, 50, Color.GRAY, 4, 1);
        
        ballList = new ArrayList<Ball>();
        ballList.add(ball1);
        ballList.add(ball2);
        ballList.add(ball3);
        ballList.add(ball4);
        ballList.add(ball5);
        ballList.add(ball6);
        

        enemyList = new ArrayList<Enemy1>();
        user = new Player(100, 100, 25, 25, Color.blue, 2);
        Enemy1 e1 = new Enemy1(550, 90, 20, 360, Color.red, 2, 1);
        Enemy1 e2 = new Enemy1(570, 600, 200, 20, Color.red, 2, 1);
        Enemy1 bob = new Enemy1(250, 110, 20, 200, Color.red, 2, 1);
        Enemy1 bob2 = new Enemy1(190, 420, 170, 20, Color.red, 2, 1);
        Enemy1 bob3 = new Enemy1(400, 300, 20, 100, Color.red, 2, 1);
        Enemy1 bob4 = new Enemy1(550, 490, 200, 20, Color.red, 2, 1);
        enemyList.add(e1);
        enemyList.add(e2);
        enemyList.add(bob);
        enemyList.add(bob2);
        enemyList.add(bob3);
        enemyList.add(bob4);
        goal = new Enemy1(600, 260, 30, 30, Color.green);
        keys = new boolean[4];
        leftwall = new Enemy1(0,0,20,700, Color.red);
        rightwall = new Enemy1(714,0,20,700, Color.red);
        topwall = new Enemy1(0,0,760,20, Color.red);
        bottomwall = new Enemy1(0,541,760,20, Color.red);
        enemyList.add(leftwall);
        enemyList.add(topwall);
        enemyList.add(bottomwall);
        enemyList.add(rightwall);

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);

    }

    public void update(Graphics window) {
        paint(window);
    }

    //Paint method from Pong as there isn't any easy way to write a different method for this.

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.red);
        goal.draw(graphToBack);
        user.draw(graphToBack);
        for (Ball b : ballList) {
            b.moveAndDraw(graphToBack);
            for (Enemy1 e : enemyList) {
                if (b.isCollide(e)) {
                    b.setXSpeed(-b.getXSpeed());
                    b.setYSpeed(-b.getYSpeed());
                }

            }
            if (!(b.getyPos() >= 0 && b.getyPos() <= 450)) {
                b.setYSpeed(-b.getYSpeed());
            }
            if (!(b.getxPos() >= 0 && b.getxPos() <= 650)) {
                b.setXSpeed(-b.getXSpeed());
            }
            if (b.isCollide(user)) {
                user.draw(graphToBack, Color.WHITE);
                user.setxPos(100);
                user.setyPos(100);
                user.draw(graphToBack, Color.BLUE);
                score++;
            }
        }

        if (goal.isCollide(user)) {
            try {
                scorer(score);
            } catch (IOException ex) {
                Logger.getLogger(Level2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }

        for (Enemy1 e : enemyList) {
            e.draw(graphToBack);
            if (user.isCollide(e)) {
                user.draw(graphToBack, Color.WHITE);
                user.setxPos(100);
                user.setyPos(100);
                user.draw(graphToBack, Color.BLUE);
                score++;
            }
        }

        //Collision detection: Some problems with up and down, however functional
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

    public void scorer(int a) throws IOException {
        a = a - 5;
        System.out.println("User " + PlayPlatformer.getName1() + " failed " + a + " times in level 2.");
        BufferedWriter out;
        out = new BufferedWriter(new FileWriter("Scores.txt", true));
        out.append("User " + PlayPlatformer.getName1() + " failed " + a + " times in level 2.");
        out.newLine();
        out.close();
        System.exit(0);
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