package PlatformFinal;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;

public class PlayPlatformer extends JFrame {

    //Frame from Pong program, however modifications made.

    private static final int WIDTH = 616;
    private static final int HEIGHT = 550;
    private static String name;

    public PlayPlatformer() {
        super("Erik, Ernest, Cassidy, & Kyle || CompSciA Final - Super Blocko Lv1");
        setSize(WIDTH, HEIGHT);

        Levels game = new Levels(this);
        ((Component) game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        Object[] options1 = {"Okay."};
        JOptionPane.showOptionDialog(null,
                "1. Move the player to the green box" + "\n2. Avoid the enemies by moving around them" + "\n3. And most importantly, have fun.",
                "Game Rules",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);
        String userName = JOptionPane.showInputDialog(null, "Enter your username:");
        if(userName == null){
            System.out.println("INPUT USERNAME");
            System.exit(0);
        }
            
       
        setName1(userName);
        

        PlayPlatformer run = new PlayPlatformer();
    }

    /**
     * @return the name
     */
    public static String getName1() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public static void setName1(String aname) {
        name = aname;
    }
}


/*package PlatformFinal;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Component;
import java.io.File;

public class PlayPlatformer extends JFrame {
    //Frame from Pong program, however modifications made.
    private static final int WIDTH = 616;
    private static final int HEIGHT = 550;
    
    public PlayPlatformer() {
        super("Erik, Ernest, Cassidy, & Kyle || CompSciA Final - Super Blocko Lv1");
        setSize(WIDTH, HEIGHT);

        Levels game = new Levels(this);

        ((Component) game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);
        
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        PlayPlatformer run = new PlayPlatformer();
    }
}*/