package presentation.financeui;

import java.awt.Choice;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.DefaultComboBoxModel;

public class PaymentInputPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;

	/**
	 * Create the panel.
	 */
	/*public static void main(String[] args){
		JFrame f = new JFrame();
		PaymentInputPanel p = new PaymentInputPanel();
		p.setVisible(true);
		f.setSize(671,335);
	f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
	public PaymentInputPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("付款日期");
		label.setBounds(305, 79, 61, 16);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(426, 73, 168, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("付款人");
		lblNewLabel.setBounds(305, 129, 61, 16);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(426, 123, 168, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("付款账号");
		label_1.setBounds(305, 179, 61, 16);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(426, 173, 168, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("付款种类");
		label_2.setBounds(305, 235, 61, 16);
		add(label_2);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(565, 322, 94, 47);
		add(btnNewButton);
		
		String[] payway = {"租金","运费","工资","奖金"};
		JComboBox comboBox = new JComboBox(payway);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"租金", "运费", "工资", "奖金"}));
		comboBox.setBounds(426, 230, 134, 28);
		//comboBox.setVisible(true);
		add(comboBox);
	}
}
