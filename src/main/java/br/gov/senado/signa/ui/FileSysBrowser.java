package br.gov.senado.signa.ui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Navegador de sistema de arquivos.
 * 
 * @author Denis Oliveira - denisbito@gmail.com
 */
@SuppressWarnings("serial")
public class FileSysBrowser extends JPanel {

	public FileSysBrowser() {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		// adicionar árvore de diretórios
		add(new FileSysBrowserTree());

		// adicionar tabela de arquivos
		add(new FileSysBrowserList());
	}

}
