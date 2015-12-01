package presentation.logisticui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;

public class ProcessArrival extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcessArrival frame = new ProcessArrival();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ProcessArrival() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 529, 427);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("日期");
		label.setBounds(46, 46, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(98, 43, 66, 21);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("出发地");
		label_1.setBounds(201, 46, 54, 15);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(278, 43, 66, 21);
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("到达单类型");
		label_2.setBounds(379, 46, 75, 15);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(453, 43, 66, 21);
		textField_2.setEditable(false);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("单据编号");
		label_3.setBounds(46, 117, 54, 15);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 114, 316, 21);
		textField_3.setEditable(false);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("货物条码");
		label_4.setBounds(217, 160, 54, 15);
		panel.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 185, 316, 104);
		panel.add(scrollPane);
		
		textField_4 = new JTextField();
		scrollPane.setViewportView(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("提交");
		button.setBounds(215, 348, 93, 23);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(538, 10, 311, 427);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_5 = new JLabel("日期");
		label_5.setBounds(10, 48, 24, 15);
		panel_1.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(93, 45, 66, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("出发地");
		label_6.setBounds(10, 88, 54, 15);
		panel_1.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(93, 85, 66, 21);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_7 = new JLabel("单据编号");
		label_7.setBounds(10, 137, 54, 15);
		panel_1.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(93, 134, 66, 21);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_8 = new JLabel("到达单类型");
		label_8.setBounds(10, 192, 77, 15);
		panel_1.add(label_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 189, 93, 21);
		panel_1.add(comboBox);
		
		JButton button_1 = new JButton("确认");
		button_1.setBounds(66, 230, 93, 23);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 279, 311, 138);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_9 = new JLabel("货物条码");
		label_9.setBounds(27, 10, 48, 15);
		panel_2.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(114, 7, 66, 21);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JButton button_2 = new JButton("添加");
		button_2.setBounds(64, 83, 93, 23);
		panel_2.add(button_2);
	}
	
}
