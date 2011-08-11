package br.gov.senado.signa.ui;

import java.awt.Dimension;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Navegador de sistema de arquivos.
 * 
 * @author Denis Oliveira - denisbito@gmail.com
 */
@SuppressWarnings("serial")
public class FileSysBrowser extends JPanel {

	public FileSysBrowser() {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		// criar um JSplitPane para colocar os dois outros componentes
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(splitPane);

		// adicionar árvore de diretórios
		JScrollPane dirPane = new JScrollPane(new DirTree());
		dirPane.setPreferredSize(new Dimension(240, 0));
		splitPane.add(dirPane);

		// adicionar tabela de arquivos
		splitPane.add(new JScrollPane(new FileTable()));
	}

	/**
	 * Árvore de diretórios exibida pelo navegador de arquivos.
	 */
	class DirTree extends JTree {
		public DirTree() {
			super(new DirTreeModel(new File(System.getProperty("user.home"))));
		}

	}

	/**
	 * Tabela que mostra informações de arquivos no filesystem.
	 */
	class FileTable extends JTable {
		public FileTable() {

		}
	}

	/**
	 * TreeModel personalizado para a árvore de diretórios
	 */
	class DirTreeModel implements TreeModel {

		protected File root;

		public DirTreeModel(File root) {
			this.root = root;
		}

		/**
		 * O model deve saber devolver, para um determinado nodo pai, o filho em
		 * uma determinada posição.
		 */
		@Override
		public Object getChild(Object parent, int index) {
			Object child = null;
			String[] children = ((File) parent).list();
			if (children != null && index < children.length) {
				child = new File((File) parent, children[index]);
			}
			return child;
		}

		/**
		 * Informar ao JTree a quantidade de filhos de um nodo pai.
		 */
		@Override
		public int getChildCount(Object parent) {
			String[] children = ((File) parent).list();
			int count = children != null ? children.length : 0;
			return count;
		}

		/**
		 * Obter a posição de um nodo filho dentro de um nodo pai. Se o pai não
		 * contiver o objeto filho, devolve a posição -1.
		 */
		@Override
		public int getIndexOfChild(Object parent, Object child) {
			int pos = -1;
			String[] children = ((File) parent).list();
			if (children != null) {
				String childName = ((File) child).getName();
				for (int i = 0; i < children.length; i++) {
					if (childName.equals(children[i])) {
						pos = i;
						break;
					}
				}
			}
			return pos;
		}

		/**
		 * Informa ao JTree o nodo raiz da árvore
		 */
		@Override
		public Object getRoot() {
			return root;
		}

		@Override
		public boolean isLeaf(Object node) {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * Método não precisa ser implementado, pois é utilizado apenas por
		 * árvores editáveis.
		 */
		@Override
		public void valueForPathChanged(TreePath path, Object newValue) {
		}

		/**
		 * Por enquanto, o TreeModel não será editável, portanto não é preciso
		 * implementar os métodos de add/remove listeners.
		 */
		@Override
		public void addTreeModelListener(TreeModelListener l) {
		}

		@Override
		public void removeTreeModelListener(TreeModelListener l) {
		}
	}

}
