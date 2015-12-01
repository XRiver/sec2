package presentation.financeui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class SystemLogPanel extends JPanel {

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
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	public  SystemLogPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("日志时间");
		label.setBounds(81, 55, 61, 16);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(159, 49, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("内容关键字");
		label_1.setBounds(374, 55, 88, 16);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(470, 49, 272, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(899, 50, 125, 43);
		add(btnNewButton);
		
		name = new Vector();
		name.add("时间");
		name.add("内容");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(65, 120, 1001, 307);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(65, 120, 1001, 307);
		add(scrollPane);

	}
}
