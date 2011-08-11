package br.gov.senado.signa.ui;

import java.awt.Dimension;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Rudimentary filesystem browser, for navigating the local filesystem.
 * 
 * @author Denis Oliveira - denisbito@gmail.com
 */
@SuppressWarnings("serial")
public class FileSysBrowser extends JPanel {

	protected File currentDir;

	public FileSysBrowser(File dir) {
		setCurrentDir(dir);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		// create a JSplitPane for holding the other components
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(splitPane);

		// add the directory tree
		JScrollPane dirPane = new JScrollPane(new DirTree());
		dirPane.setPreferredSize(new Dimension(260, 0));
		splitPane.add(dirPane);

		// add the file view table
		splitPane.add(new JScrollPane(new FileTable()));
	}

	public FileSysBrowser() {
		this(new File(System.getProperty("user.home")));
	}

	/**
	 * Directory tree shown in the file browser.
	 */
	class DirTree extends JTree {
		public DirTree() {
			super(new DirTreeModel(getCurrentDir()));
		}

	}

	/**
	 * File information table shown in the file browser.
	 */
	class FileTable extends JTable {
		public FileTable() {
			super(new FileListTableModel(FileSysBrowser.this.getCurrentDir()));
			setShowGrid(false);
		}
	}

	/**
	 * Custom TreeModel for the directory tree.
	 */
	class DirTreeModel implements TreeModel {

		protected File root;

		public DirTreeModel(File root) {
			this.root = root;
		}

		/**
		 * Gets a child node in the corresponding position inside the parent
		 * node.
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
		 * Informs the JTree about how many children a parent node has.
		 */
		@Override
		public int getChildCount(Object parent) {
			String[] children = ((File) parent).list();
			int count = children != null ? children.length : 0;
			return count;
		}

		/**
		 * Get a child node's position inside the parent node. If the parent
		 * doesn't hold the child, returns -1.
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
		 * Returns the root node for the JTree.
		 */
		@Override
		public Object getRoot() {
			return root;
		}

		/**
		 * Informs the JTree if the given node is a leaf or not.
		 */
		@Override
		public boolean isLeaf(Object node) {
			return ((File) node).isFile();
		}

		/**
		 * Not implemented, since the JTree isn't currently editable.
		 */
		@Override
		public void valueForPathChanged(TreePath path, Object newValue) {
		}

		// add/remove listener methods won't be implemented, since the JTree
		// isn't currently editable
		@Override
		public void addTreeModelListener(TreeModelListener l) {
		}

		@Override
		public void removeTreeModelListener(TreeModelListener l) {
		}
	}

	/**
	 * Custom TableModel for the file list table.
	 */
	class FileListTableModel extends AbstractTableModel {

		private String[] columnNames = new String[] { "Nome", "Tamanho (KB)",
				"Data modificação" };
		private List<File> fileList;

		public FileListTableModel(File dir) {
			setFileList(Arrays.asList(dir.listFiles()));
		}

		/**
		 * The file information table isn't currently editable.
		 */
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		/**
		 * Get the number of columns in the JTable.
		 */
		@Override
		public int getColumnCount() {
			return this.columnNames.length;
		}

		/**
		 * Get the column's name, given its index.
		 */
		@Override
		public String getColumnName(int colIndex) {
			return this.columnNames[colIndex];
		}

		/**
		 * Get the number of rows in the JTable.
		 */
		@Override
		public int getRowCount() {
			return getFileList().size();
		}

		/**
		 * Get the object at the specified row and column indexes.
		 */
		@Override
		public Object getValueAt(int rowIndex, int colIndex) {
			Object value = null;
			File file = fileList.get(rowIndex);

			switch (colIndex) {
			case 0:
				value = file.getName();
				break;
			case 1:
				value = new Long(file.length());
				break;
			case 2:
				value = new Date(file.lastModified());
				break;
			}

			return value;
		}

		public List<File> getFileList() {
			return fileList;
		}

		public void setFileList(List<File> fileList) {
			this.fileList = fileList;
		}

	}

	public File getCurrentDir() {
		return currentDir;
	}

	public void setCurrentDir(File currentDir) {
		this.currentDir = currentDir;
	}

}
