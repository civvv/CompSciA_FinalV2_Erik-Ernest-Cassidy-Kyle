/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlatformFinal;

/**
 *
 * @author line8847
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Level3Runner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Level3Runner()
	{
		super("Erik, Ernest, Cassidy, & Kyle || CompSciA Final - Super Blocko Lv3");
		setSize(WIDTH,HEIGHT);

		Level3 l3 = new Level3();
                ((Component) l3).setFocusable(true);
                getContentPane().add(l3);
                setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}