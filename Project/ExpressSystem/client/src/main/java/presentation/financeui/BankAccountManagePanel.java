package presentation.financeui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class BankAccountManagePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public BankAccountManagePanel() {
       setSize(WIDTH,HEIGHT);
       setLayout(null);
       
       JLabel label = new JLabel("账号");
       label.setBounds(812, 95, 61, 16);
       add(label);
       
       textField = new JTextField();
       textField.setBounds(905, 89, 204, 28);
       add(textField);
       textField.setColumns(10);
       
       JLabel label_1 = new JLabel("账户名");
       label_1.setBounds(812, 189, 61, 16);
       add(label_1);
       
       textField_1 = new JTextField();
       textField_1.setBounds(905, 183, 204, 28);
       add(textField_1);
       textField_1.setColumns(10);
       
       JLabel label_2 = new JLabel("余额");
       label_2.setBounds(812, 288, 61, 16);
       add(label_2);
       
       textField_2 = new JTextField();
       textField_2.setBounds(905, 282, 204, 28);
       add(textField_2);
       textField_2.setColumns(10);
       
       JButton btnAdd = new JButton("Add");
       btnAdd.setBounds(820, 363, 75, 35);
       add(btnAdd);
       
       JButton btnNewButton = new JButton("Modify");
       btnNewButton.setBounds(933, 363, 73, 35);
       add(btnNewButton);
       
       JButton btnNewButton_1 = new JButton("Delete");
       btnNewButton_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	}
       });
       btnNewButton_1.setBounds(1036, 363, 73, 35);
       add(btnNewButton_1);
       
       name = new Vector();
		name.add("账号");
		name.add("账户名");
		name.add("余额");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(47, 61, 604, 359);
       JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setBounds(47, 61, 604, 359);
       add(scrollPane);
	}

}
