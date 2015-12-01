package presentation.financeui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ChartOutPutPanel extends JPanel {

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
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JTextField textField;
	private JTextField textField_1;
	public  ChartOutPutPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("报表种类");
		lblNewLabel_1.setBounds(69, 43, 61, 16);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 39, 107, 27);
		add(comboBox);
		
		JLabel label = new JLabel("起始时间");
		label.setBounds(303, 43, 61, 16);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(361, 37, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("结束时间");
		label_1.setBounds(554, 43, 61, 16);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(619, 37, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(801, 38, 89, 30);
		add(btnNewButton);
		
		JButton button = new JButton("导出");
		button.setBounds(962, 37, 89, 30);
		add(button);
		
		name = new Vector();
		name.add("条形码");
		name.add("货运状态");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(69, 118, 982, 282);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(69, 118, 982, 282);
		add(scrollPane);

	}
}
