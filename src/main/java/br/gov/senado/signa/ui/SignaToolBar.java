package br.gov.senado.signa.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 * Barra de botões.
 * 
 * @author Denis Oliveira
 */
@SuppressWarnings("serial")
public class SignaToolBar extends JToolBar {

	public SignaToolBar() {
		initGUI();
	}

	private void initGUI() {
		// adicionar botões
		add(createSignButton());
	}

	/**
	 * Constrói o botão de "Assinar".
	 */
	private JButton createSignButton() {
		JButton btAssinar = new JButton("Assinar");
		btAssinar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO - implementar!!!
				JOptionPane.showMessageDialog(SignaDesktop.getMainWindow(),
						"Não implementado.");
			}

		});
		return btAssinar;
	}

}
