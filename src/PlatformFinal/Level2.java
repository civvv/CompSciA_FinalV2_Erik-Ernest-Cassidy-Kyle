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
import java.io.FileWriter;
import static java.lang.Character.toUpperCase;

/**
 *
 * @author beere1633
 */
public class Level2 extends Canvas implements KeyListener, Runnable{
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
    private FileWriter writer;
    private ArrayList<Enemy1> enemyList;

    public Level2() {
        enemyList = new ArrayList<Enemy1>();
        user = new Player(100, 100, 20, 25, Color.blue, 2);
        bob = new Enemy1(200,0,20,260, Color.red, 0, 1);
        bob2 = new Enemy1(280,300,20,260, Color.red, 0, 1);
        bob3 = new Enemy1(200,150,200,20, Color.red, 0, 1);
        bob4 = new Enemy1(380,70,20,380, Color.red, 0, 1);
        bob5 = new Enemy1(440,300,100,20, Color.red, 0, 1);
        bob6 = new Enemy1(580,0,20,600, Color.red, 0, 1);
        bob7 = new Enemy1(270,50,200,20, Color.red, 0, 1);
        goal = new Enemy1(310, 95, 30, 30, Color.green);
        keys = new boolean[4];
        enemyList.add(bob);
        enemyList.add(bob2);
        enemyList.add(bob3);
        enemyList.add(bob4);
        enemyList.add(bob5);
        enemyList.add(bob6);
        enemyList.add(bob7);
        
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

        user.draw(graphToBack);


        //Collision detection: Some problems with up and down, however functional
        for (Enemy1 e: enemyList){
            e.moveAndDraw(graphToBack);
            if (e.isCollide(user)){
                e.setColor(Color.white);
                e.setxPos(0);
                e.setyPos(0);
                e.setColor(Color.red);
            }
            
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