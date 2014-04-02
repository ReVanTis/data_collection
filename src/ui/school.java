package ui;

import java.awt.EventQueue;

import javax.accessibility.AccessibleContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;

import java.awt.BorderLayout;
import java.awt.print.Printable;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class school extends JFrame{

	public String SchoolName;
	private JTree tree;
	private JTextPane textPane;
	private JPanel contentPane;
	// XXX 设置指向主窗体的变量
	public UI mainUi;
	school() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		this.setBounds(100, 100, 388, 225);
		contentPane=new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 54, 262, 102);
		contentPane.add(scrollPane);
		
		tree = new JTree();
		tree.addMouseListener(new MouseAdapter() {
			@Override
		      public void mouseClicked(MouseEvent e) { 
		        /* 当鼠标双击事件被触发时，调用alert方法显示树节点的userObject值。 */ 
		        int row = tree.getRowForLocation(e.getX(), e.getY()); 
		        if(row == -1) return; 
		        if(e.getClickCount() == 1) return; 
		        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent(); 
		        if(treeNode.isLeaf())
		        {
		        	SchoolName = (String)treeNode.getUserObject();
		        	//System.out.println(SchoolName);
		        	//TODO
		        	//XXX 执行主窗体的函数
		        	mainUi.blahblahblah(SchoolName); //define your public function todo something.
		        }
		      } 
		});
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				// 利用JTree的getLastSelectedPathComponent()方法取得目前选取的节点.
				DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				SchoolName = selectionNode.toString();

				if (selectionNode.isLeaf())
					textPane.setText("\u9009\u62E9\uFF1A"+"  "+SchoolName);
				else 
					textPane.setText("\u9009\u62E9\uFF1A"+"  "+"nonono！！！！");
			}
		});
		scrollPane.setViewportView(tree);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("BIT") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("School of Software");
						node_1.add(new DefaultMutableTreeNode("Software Engineering"));
						add(node_1);
					node_1 = new DefaultMutableTreeNode("School of Computer");
						node_1.add(new DefaultMutableTreeNode("Computer Science and Technolgy"));
						node_1.add(new DefaultMutableTreeNode("Software Engineering"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("School of Economics");
						node_1.add(new DefaultMutableTreeNode("Economics"));
						add(node_1);
				}
			}
		));
		
		textPane = new JTextPane();
		textPane.setText("\u9009\u62E9\uFF1A");
		textPane.setBounds(55, 20, 262, 21);
		contentPane.add(textPane);
	}
}
