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
public class Level2Runner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Level2Runner()
	{
		super("Erik, Ernest, Cassidy, & Kyle || CompSciA Final - Super Blocko Lv2");
		setSize(WIDTH,HEIGHT);

		Level2 l2 = new Level2();
                ((Component) l2).setFocusable(true);
                getContentPane().add(l2);
                setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}