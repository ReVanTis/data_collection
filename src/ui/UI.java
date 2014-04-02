package ui;
import java.awt.Button;
import java.awt.EventQueue;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JInternalFrame;

import Main.*;
import student.*;
import studentscore.*;


import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;


public class UI {

	private JFrame frame;
	private school sch;

	//XXX 定义一个指向自身的常量，便于在listener中引用 
	final public UI self= this;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private final Action action = new SwingAction();
	private JButton add;
	private JComboBox comboBox;
	JOptionPane optionpane;
	
	studata db;
	int no;
	String name;
	int age;
	String school;

	score score;
	int n;
	int g;
	String c;
	
	connect connect;
	
	private JTextArea txtrData;
	String text="";
	private JComboBox comboBox_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private ButtonGroup sortbuttonGroup;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//XXX 定义需要执行的函数
	public void blahblahblah(String info)
	{
		//TODO
		//Do smething here.
		System.out.println(info);
	}
	/**
	 * Create the application.
	 */


	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//初始化
		db = new studata();
		db.add(new student(1,"zhq",29,"A"));
		db.add(new student(4,"yxm",23,"SS"));
		db.add(new student(3,"zhq",25,"SS"));
		db.add(new student(5,"zhq",26,"A"));
		
		score = new score();
		score.add(new mark(1,78,"SE"));
		score.add(new mark(1,98,"SE"));
		score.add(new mark(3,74,"SE"));
		score.add(new mark(4,86,"SE"));
		score.add(new mark(4,85,"SE"));
		
		add = new JButton("add");
		add.setBounds(289, 310, 80, 23);
		add.setAction(action);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=(String)comboBox.getSelectedItem();
				try {
					no=Integer.parseInt(textField.getText());
					name=textField_1.getText();
					age=Integer.parseInt(textField_2.getText());
					school=textField_3.getText();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "please check inputs", "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//confuse.....
				if(s=="add"){
					db.add(new student(no,name,age,school));
				}
				else if(s=="del"){
					db.delete(no);
				}
				text=db.datatext();
				txtrData.setText(text);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");				
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setBounds(289, 280, 80, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"add", "del"}));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 20, 192, 237);
		
		txtrData = new JTextArea();
		scrollPane.setViewportView(txtrData);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JLabel label = new JLabel("\u6570\u636E\u4FE1\u606F");
		scrollPane.setColumnHeaderView(label);
		
		JButton btnDoIt = new JButton("do it");
		btnDoIt.setBounds(437, 310, 80, 23);
		btnDoIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=(String)comboBox_1.getSelectedItem();
				n=Integer.parseInt(textField_5.getText());
				g=Integer.parseInt(textField_6.getText());
				c=textField_7.getText();
				if (s == "add") {
					score.add(new mark(n, g, c));
					text = connect.showtext((studata)db, score);
					txtrData.setText(text);
					return;
				}
			}
		});
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(437, 280, 80, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"add"}));
		frame.getContentPane().setLayout(null);
		
		sortbuttonGroup = new ButtonGroup();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "sort", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(55, 267, 143, 73);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnNewRadioButton_1 = new JRadioButton("order by school");
		rdbtnNewRadioButton_1.setBounds(6, 42, 121, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				db.schoolsort();
				text=db.datatext();
				txtrData.setText(text);
			}
		});
		sortbuttonGroup.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("order by NO.");
		rdbtnNewRadioButton.setBounds(6, 17, 121, 23);
		panel_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				db.sort();
				text=db.datatext();
				txtrData.setText(text);
			}
		});
		sortbuttonGroup.add(rdbtnNewRadioButton);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5B66\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(265, 20, 119, 237);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(47, 17, 60, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setBounds(6, 20, 54, 15);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(47, 67, 60, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(6, 70, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74\u9F84");
		label_2.setBounds(6, 120, 54, 15);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(47, 117, 60, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(47, 167, 60, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5B66\u9662");
		label_3.setBounds(6, 170, 54, 15);
		panel.add(label_3);
		
		JButton button = new JButton("\u9009\u62E9\u5B66\u9662");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sch!=null)
				{
					sch.dispose();
				}
				sch=new school();
				//XXX 在sch中，设置一个变量引用主窗体，以执行主窗体的函数
				sch.mainUi=self;
				sch.setVisible(true);
			}
		});
		button.setBounds(14, 197, 93, 23);
		panel.add(button);
		frame.getContentPane().add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6210\u7EE9\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(417, 70, 117, 158);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_7 = new JTextField();
		textField_7.setBounds(47, 17, 60, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5B66\u53F7");
		label_4.setBounds(6, 20, 54, 15);
		panel_2.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(47, 67, 60, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6210\u7EE9");
		label_5.setBounds(6, 70, 54, 15);
		panel_2.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(47, 117, 60, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8BFE\u7A0B");
		label_6.setBounds(6, 120, 54, 15);
		panel_2.add(label_6);
		frame.getContentPane().add(btnDoIt);
		frame.getContentPane().add(comboBox_1);
		frame.getContentPane().add(add);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dlg = new JFileChooser();
				int result = dlg.showSaveDialog(null);  // 打"开保存文件"对话框
				if (result == JFileChooser.APPROVE_OPTION) {
					File f = dlg.getSelectedFile();
					file savetoFile = new file(f);
					savetoFile.write(db);
				}
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser dlg = new JFileChooser();
				int result = dlg.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File f = dlg.getSelectedFile();
					file loadFile = new file(f);
					db=(studata) loadFile.read();
				}
			}
		});
		mnFile.add(mntmLoad);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "do it");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
