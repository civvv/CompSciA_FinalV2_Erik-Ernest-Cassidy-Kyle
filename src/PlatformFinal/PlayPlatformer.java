package PlatformFinal;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Component;
import java.io.File;

public class PlayPlatformer extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public PlayPlatformer() {
        super("Erik Beer CompSciA Final - Super Blocko");
        setSize(WIDTH, HEIGHT);

        Levels game = new Levels();

        ((Component) game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);
    }

    public static void main(String args[]) {
        PlayPlatformer run = new PlayPlatformer();
    }
}
