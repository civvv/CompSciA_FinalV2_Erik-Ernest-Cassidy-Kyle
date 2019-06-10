package PlatformFinal;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Component;
import java.io.File;

public class PlayPlatformer extends JFrame {
    //Frame from Pong program, however modifications made.
    private static final int WIDTH = 700;
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
}