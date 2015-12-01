package presentation.financeui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class SettlementMangePanel extends JPanel {

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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	public  SettlementMangePanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("收款日期");
		label.setBounds(843, 38, 61, 16);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(939, 32, 164, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("收款人");
		label_1.setBounds(843, 89, 61, 16);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(939, 83, 164, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("收款单位");
		label_2.setBounds(843, 144, 61, 16);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(939, 138, 164, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("交款营业厅");
		label_3.setBounds(843, 194, 78, 16);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(939, 188, 164, 28);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("交款地点");
		label_4.setBounds(843, 246, 61, 16);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(939, 240, 164, 28);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("金额");
		label_5.setBounds(843, 298, 61, 16);
		add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(939, 292, 164, 28);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("银行账号");
		label_6.setBounds(843, 346, 61, 16);
		add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(939, 340, 164, 28);
		add(textField_6);
		textField_6.setColumns(10);
		
		JButton button = new JButton("提交");
		button.setBounds(986, 384, 117, 29);
		add(button);
		
		name = new Vector();
		name.add("收款日期");
		name.add("收款人");
		name.add("收款单位");
		name.add("交款营业厅");
		name.add("交款地点");
		name.add("金额");
		name.add("银行账号");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(17, 17, 713, 404);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(17, 17, 713, 404);
		add(scrollPane);
	}
}
