package br.gov.senado.signa.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Signa Desktop example application.
 * 
 * @author Denis Oliveira - denisbito@gmail.com
 */
public class SignaDesktop {

	private static JFrame mainWindow;

	public SignaDesktop() {
		initGUI();
	}

	public static void main(String[] args) {
		new SignaDesktop();
	}

	/**
	 * Initializes the app's graphical interface.
	 */
	public void initGUI() {
		mainWindow = new JFrame("Signa - Assinador Digital");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setPreferredSize(new Dimension(800, 600));

		mainWindow.getContentPane().setLayout(new BorderLayout());
		mainWindow.getContentPane().add(new SignaToolBar(),
				BorderLayout.PAGE_START);
		mainWindow.getContentPane().add(new FileSysBrowser(),
				BorderLayout.CENTER);

		mainWindow.setLocation(100, 100);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}

	public static Component getMainWindow() {
		return mainWindow;
	}

}
