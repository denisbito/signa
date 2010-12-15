package br.gov.senado.signa.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Aplicativo Desktop para o Signa.
 * 
 * @author Denis Oliveira
 */
public class SignaDesktop {

	public static void main(String[] args) {
		JFrame janelaPrincipal = new JFrame("Signa - Assinador Digital");
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setPreferredSize(new Dimension(500, 350));
		// TODO - codificar a interface gráfica
		String msg = "Ainda não implementado."
				+ " Verificar a biblioteca OpenSwing para codificação desta interface.";
		janelaPrincipal.getContentPane().add(new JLabel(msg));
		janelaPrincipal.pack();
		janelaPrincipal.setVisible(true);
	}

}
