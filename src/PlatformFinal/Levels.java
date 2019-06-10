package PlatformFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;  
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JFrame;
public class Levels extends Canvas implements KeyListener, Runnable {

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
    private Enemy1 enemy1;
    private Enemy1 enemy2;
    private Enemy1 enemy3;
    private Enemy1 enemy4;
    private Enemy1 enemy5;
    private Enemy1 enemy6;
    private ArrayList<Enemy1> enemList;
    private JFrame j;
    public Levels(JFrame j ) {
        this.j = j;
        user = new Player(100, 100, 20, 20, Color.blue, 2);
        enemList = new ArrayList<Enemy1>();
        bob = new Enemy1(200,0,20,260, Color.red);
        enemList.add(bob);
        bob2 = new Enemy1(280,300,20,260, Color.red);
        enemList.add(bob2);
        bob3 = new Enemy1(200,150,200,20, Color.red);
        enemList.add(bob3);
        bob4 = new Enemy1(380,70,20,380, Color.red);
        enemList.add(bob4);
        bob5 = new Enemy1(440,300,100,20, Color.red);
        enemList.add(bob5);
        bob6 = new Enemy1(580,0,20,600, Color.red);
        enemList.add(bob6);
        bob7 = new Enemy1(270,50,200,20, Color.red);
        enemList.add(bob7);
        goal = new Enemy1(310, 95, 30, 30, Color.green);
        
        keys = new boolean[4];
        
        enemy1 = new Enemy1(50, 300, 25, 25, Color.black, 2, 0);
        enemList.add(enemy1);
        enemy2 = new Enemy1(420, 350, 25, 25, Color.black, 1, 0);
        enemList.add(enemy2);
        //line pattern
        enemy4 = new Enemy1(400, 100, 25, 25, Color.black, 1, 0);
        enemList.add(enemy4);
        enemy5 = new Enemy1(450, 150, 25, 25, Color.black, 1, 0);
        enemList.add(enemy5);
        enemy6 = new Enemy1(500, 200, 25, 25, Color.black, 1, 0);
        enemList.add(enemy6);
        

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
        bob.draw(graphToBack);
        bob2.draw(graphToBack);
        bob3.draw(graphToBack);
        bob4.draw(graphToBack);
        bob5.draw(graphToBack);
        bob6.draw(graphToBack);
        bob7.draw(graphToBack);
        goal.draw(graphToBack);
        
       
        
        //enemy1 movement pattern
        enemy1.moveAndDraw(graphToBack);
        enemy1.squarePattern(50, 300, 200, 450, 2);
      
        //enemy2 movement pattern
        enemy2.moveAndDraw(graphToBack);
        enemy2.squarePattern(420, 350, 520, 450, 1);
        
        //enemy456 movement pattern
        enemy4.moveAndDraw(graphToBack);
        enemy5.moveAndDraw(graphToBack);
        enemy6.moveAndDraw(graphToBack);
        
        enemy4.horizontalLinePattern(400, 550, 100, 1);
        enemy5.horizontalLinePattern(400, 550, 150, 1);
        enemy6.horizontalLinePattern(400, 550, 200, 1);
        
        //enemy collision detection
        for (Enemy1 e : enemList){
            if (user.isCollide(e)){
                user.draw(graphToBack, Color.WHITE);
                user.setxPos(100);
                user.setyPos(100);
                user.draw(graphToBack, Color.BLUE);
            }
        }

        //Collision detection: Some problems with up and down, however functional
        
        if (goal.didCollideLeft(user) && (goal.didCollideRight(user))&&(user.getyPos()<130)&&(user.getyPos()>90)){
            user.setColor(Color.cyan);
            new Level2Runner();
            j.dispose();
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

/* Erik B.'s Old Code - RIP
        if((user.getX()<enemy1.getX()+25)&&(user.getX()>enemy1.getX()-25)&&(user.getY()<enemy1.getY()+25)&&(user.getY()>enemy1.getY()-25))
        {
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if((user.getX()<enemy2.getX()+25)&&(user.getX()>enemy2.getX()-25)&&(user.getY()<enemy2.getY()+25)&&(user.getY()>enemy2.getY()-25))
        {
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        
        if((user.getX()<enemy4.getX()+25)&&(user.getX()>enemy4.getX()-25)&&(user.getY()<enemy4.getY()+25)&&(user.getY()>enemy4.getY()-25))
        {
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if((user.getX()<enemy5.getX()+25)&&(user.getX()>enemy5.getX()-25)&&(user.getY()<enemy5.getY()+25)&&(user.getY()>enemy5.getY()-25))
        {
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if((user.getX()<enemy6.getX()+25)&&(user.getX()>enemy6.getX()-25)&&(user.getY()<enemy6.getY()+25)&&(user.getY()>enemy6.getY()-25))
        {
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }


        

        //Collision detection for stationary enemies - Works great now!
        if (bob.didCollideLeft(user) && (bob.didCollideRight(user))&&(user.getyPos()<260)){
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if (bob2.didCollideLeft(user) && (bob2.didCollideRight(user))&&(user.getyPos()>275)){
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if ((bob3.didCollideTop(user) || (bob3.didCollideBottom(user)))&&(user.getxPos()<360)&&(user.getxPos()>200)){
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if (bob4.didCollideLeft(user) && (bob4.didCollideRight(user))&&(user.getyPos()>70)&&(user.getyPos()<450)){
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if ((bob5.didCollideTop(user) || (bob5.didCollideBottom(user)))&&(user.getxPos()<540)&&(user.getxPos()>440)){
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if (bob6.didCollideLeft(user) && (bob6.didCollideRight(user))){
           user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if ((bob7.didCollideTop(user) || (bob7.didCollideBottom(user)))&&(user.getxPos()<470)&&(user.getxPos()>270)){
            user.draw(graphToBack, Color.WHITE);
            user.setxPos(100);
            user.setyPos(100);
            user.draw(graphToBack,Color.BLUE);
        }
        if (goal.didCollideLeft(user) && (goal.didCollideRight(user))&&(user.getyPos()<130)&&(user.getyPos()>90)){
            user.setColor(Color.cyan);
            this.setVisible(false);
        }
        */
       